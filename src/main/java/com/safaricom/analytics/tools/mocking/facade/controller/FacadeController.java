package com.safaricom.analytics.tools.mocking.facade.controller;

import com.safaricom.analytics.tools.mocking.facade.models.Message;
import com.safaricom.analytics.tools.mocking.facade.processor.StreamProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class FacadeController {

    @Autowired
    StreamProducer streamProducer;

    @GetMapping("/subscribe")
    public String msgSubscribe() {
        streamProducer.subscribe("test_stream", "test data");
        return "gen-subscribe : subscribe \n test data";
    }

    @PostMapping("/produce")
    public String msgProduce(@RequestBody Message msg) {
        streamProducer.produce(msg);
        return "gen-produce : produce \n" + msg.toString();
    }

    @PostMapping("/tpc_mledger_activation")
    public String mLedgerRequest(@RequestBody String payload) {
        System.out.println(payload);
        streamProducer.subscribe("tpc_mledger_activation", payload);
        return "mledger_activate : subscribe \n" + payload;
    }

    @PostMapping("/data_stream")
    public String dataStream(@RequestBody Message msg) {
        System.out.println(msg);
        streamProducer.produce(msg);
        return "data-stream : produce \n" + msg;
    }

}

