package com.safaricom.analytics.tools.mocking.facade.utils;

public class GlobalVariables{

    private GlobalVariables(){
        // Empty private constructor
    }

    public static final String RESPONSE_FAIL = "FAILED";
    public static final String RESPONSE_SUCCESS  = "SUCCESS";
    public static final String RESPONSE_ERROR = "ERROR";
    public static final String CONTENT_TYPE = "application/json";
    public static final String BAD_REQUEST = "Bad Request";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String NOT_FOUND = "Not Found";
    public static final String NOT_AUTHORIZED = "Unauthorized";
    public static final String AUTHENTICATION = "Authentication";
    public static final String SERVICE_NAME = "MS_MLEDGER";
    public static final String IDENTITY_SERVICE = "MS_MLEDGER_IDENTITY";
    public static final String TRANSACTIONS_SERVICE = "MS_MLEDGER_TRANSACTIONS";
    public static final String DURATION_FORMAT = "%sms";

    /*===================================================
     * RESPONSE CODES
     *===================================================*/
    public static final int BAD_REQUEST_CODE = 400;
    public static final int SUCCESS_CODE = 200;
    public static final int FAILED_CODE = 400;
    public static final int NOT_FOUND_CODE = 404;

    /*===================================================
     * ERROR CODES
     *===================================================*/
    public static final String ERR_RECORDS_FETCHED = "CRS000001";
    public static final String ERR_RECORDS_NOT_FETCHED = "CRW000002";
    public static final String ERR_SUM_RECORDS_FETCHED = "CRS000003";
    public static final String ERR_MSG_PRODUCED = "CRS000004";
    public static final String ERR_MSG_NOT_PRODUCED = "CRS000005";
    public static final String ERR_MLEDGER_ACTIVATED = "CRS000006";
    public static final String ERR_MLEDGER_NOT_ACTIVATED = "CRS000007";
    public static final String ERR_MLEDGER_DEACTIVATED = "CRS000008";
    public static final String ERR_MLEDGER_NOT_ACTIVE = "CRW000009";

    public static final String ERR_HEADER_EXC = "CRE000050";
    public static final String ERR_NOT_FOUND_EXC = "CRE000051";
    public static final String ERR_MALFORMED_JSON_EXC = "CRE000052";
    public static final String ERR_NOT_READABLE_EXC = "CRE000053";
    public static final String ERR_INTERNAL_EXC = "CRE000054";
    public static final String ERR_INV_METHOD_EXC = "CRE000055";


    /*===================================================
     * TRANSACTION TYPES
     *===================================================*/
    public static final String DESERIALIZE_PAYLOAD = "DESERIALIZE_PAYLOAD";
    public static final String TRANS_FETCH_MLEDGER = "FETCH_MLEDGER_RECORDS";
    public static final String TRANS_MLEDGER = "MLEDGER";
    public static final String TRANS_DEFAULT = "MLEDGER_RECORDS,MLEDGER_RECORDS,MLEDGER_SERVICE";

    /*===================================================
     * SMS TYPES
     *===================================================*/
    public static final String ACTIVATION_REQUEST = "Mledger Activation Request";
    public static final String DEACTIVATION_REQUEST = "Mledger deactivation Request";

    /*================================================
     * RESPONSE  MESSAGES
     * ==============================================*/
    public static final String REQUEST_HEADER_MSG_FMT = "%s '%s' is not allowed";
    public static final String MISSING_HEADER_MSG_FMT = "Missing '%s' required header";
    public static final String REQUEST_HEADER_INVALID = "Request Header Invalid";
    public static final String REQUEST_HEADER_MISSING = "Missing Request Header";
    public static final String REQUEST_NOT_PROCESSED = "Sorry, request could not be processed";
    public static final String RESOURCE_NOT_FOUND = "Sorry, resource could not be found";
    public static final String MALFORMED_JSON = "Malformed Json";
    public static final String HEADER_BODY_MISMATCH = "Header and Body Msisdn Mismatch";
    public static final String EMPTY_STRING = "";

    /*================================================
     * SERVICE PROCESSES
     * ==============================================*/
    public static final String HEADER_VALIDATION = "Header Validation";
    public static final String PROC_GET_CREDITS = "FETCH_MLEDGER_RECORDS,FETCH_CREDITS_TRANSACTIONS,MONGO_DB";
    public static final String PROC_GET_DEBITS = "FETCH_MLEDGER_RECORDS,FETCH_DEBITS_TRANSACTIONS,MONGO_DB";
    public static final String PROC_GET_CREDITS_SUM = "FETCH_MLEDGER_RECORDS,FETCH_CREDITS_SUMMARY,MONGO_DB";
    public static final String PROC_GET_DEBITS_SUM = "FETCH_MLEDGER_RECORDS,FETCH_DEBITS_SUMMARY,MONGO_DB";
    public static final String PROC_GET_RECENT_TRANSACTIONS = "FETCH_MLEDGER_RECORDS,FETCH_RECENT_TRANSACTIONS,MONGO_DB";
    public static final String PROC_CHECK_STATUS = "CHECK_MLEDGER_ACTIVATION,CHECK_STATUS,MONGO_DB";
    public static final String PROC_DEACTIVATE = "MLEDGER_ACCOUNT_DEACTIVATION,DEACTIVATE_ACCOUNT,MONGO_DB";
    public static final String PROC_ACTIVATE = "MLEDGER_ACCOUNT_ACTIVATION,ACTIVATE_ACCOUNT,"+IDENTITY_SERVICE;
    public static final String PROC_REFRESH = "REFRESH_MLEDGER_DATA,REFRESH_RECENT_TRANSACTIONS,"+TRANSACTIONS_SERVICE;

    /*===================================================
     * HEADERS
     *===================================================*/
    public static final String HEADER_SOURCE_SYSTEM = "x-source-system";
    public static final String HEADER_CONVERSATION_ID = "x-correlation-conversationid";
    public static final String HEADER_X_APP = "x-app";
    public static final String HEADER_X_MESSAGE_ID = "x-messageid";
    public static final String HEADER_CONTENT_TYPE = "content-type";
    public static final String HEADER_ACCEPT_ENCODING = "accept-encoding";
    public static final String HEADER_ACCEPT = "accept";
    public static final String HEADER_X_MSISDN = "x-msisdn";
    public static final String HEADER_AUTHORIZATION = "authorization";

}
