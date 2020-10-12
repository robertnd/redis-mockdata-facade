package com.safaricom.analytics.tools.mocking.facade.processor;

import com.safaricom.analytics.tools.mocking.facade.config.ConfigProperties;
import com.safaricom.analytics.tools.mocking.facade.models.Message;
import com.safaricom.analytics.tools.mocking.facade.utils.EncryptorDecryptor;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStreamCommands;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Stream producer.
 */
@Component
public class StreamProducer implements InitializingBean {
    @Autowired
    private ConfigProperties configProperties;

    private StatefulRedisConnection<String, String> connection;

    @Override
    public void afterPropertiesSet() throws Exception {
        String password = EncryptorDecryptor.decryptor(
                "production",
                "1.0.0", configProperties.getSecretKey(),
                configProperties.getRedisPassword());

        RedisURI redisUri = RedisURI.Builder
                .redis(configProperties.getRedisHost(), Integer.parseInt(configProperties.getRedisPort()))
                .withPassword(password)
                .build();
        this.connection = RedisClient.create(redisUri).connect();
    }

    private void streamMessage(Message message){
        RedisStreamCommands<String, String> commands = connection.sync();
        Map<String, String> mappedObject = parameters(message);
        commands.xadd(configProperties.getStreamName(), mappedObject);
    }

    private static Map<String, String> parameters(Object obj) {
        Map<String, String> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), String.valueOf(field.get(obj)));
            } catch (Exception e){
                // ignore exception
            }
        }

        return map;
    }

    /**
     * Produce.
     *
     * @param transactionId     the transaction id
     * @param serviceName       the service name
     * @param msisdn            the msisdn
     * @param sourceSystem      the source system
     * @param callback          the callback
     * @param transactionType   the transaction type
     * @param productId         the product id
     * @param amount            the amount
     * @param channel           the channel
     * @param checkoutRequestID the checkout request id
     * @param merchantRequestID the merchant request id
     */
    public void produce(String transactionId, String serviceName, String msisdn, String sourceSystem,
                        boolean callback, String  transactionType, String productId, String amount, String channel,
                        String checkoutRequestID, String merchantRequestID){

        Message message = new Message();
        message.setTransactionId(transactionId);
        message.setServiceName(serviceName);
        message.setMsisdn(msisdn);
        message.setSourceSystem(sourceSystem);
        message.setCallback(callback);
        message.setTransactionType(transactionType);
        message.setProductId(productId);
        message.setAmount(amount);
        message.setChannel(channel);
        message.setCheckoutRequestID(checkoutRequestID);
        message.setMerchantRequestID(merchantRequestID);
        this.streamMessage(message);
    }

    public void produce(Message message){
        this.streamMessage(message);
    }

    public void subscribe(String topic, String payload){
        RedisStreamCommands<String, String> commands = connection.sync();
        Map<String, String> map = new HashMap<>();
        map.put("payload", payload);
        commands.xadd(topic, map);
    }

    public String subscribe(String topic, String payload, boolean ack){
        RedisStreamCommands<String, String> commands = connection.sync();
        Map<String, String> map = new HashMap<>();
        map.put("payload", payload);
        return commands.xadd(topic, map);
    }

    public void setGroups(String groupName){
        RedisStreamCommands<String, String> commands = connection.sync();
        XReadArgs.StreamOffset<String> stringStreamOffset = XReadArgs.StreamOffset.from(configProperties.getStreamName(), "0");
        commands.xgroupCreate(stringStreamOffset, groupName);
    }

    public void setGroups(String groupName, String topic){
        RedisStreamCommands<String, String> commands = connection.sync();
        XReadArgs.StreamOffset<String> stringStreamOffset = XReadArgs.StreamOffset.from(topic, "0");
        commands.xgroupCreate(stringStreamOffset, groupName);
    }
}

