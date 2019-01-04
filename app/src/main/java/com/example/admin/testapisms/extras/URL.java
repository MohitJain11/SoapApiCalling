package com.example.admin.testapisms.extras;

/**
 * Created by Admin on 1/4/2019.
 */

public class URL {
    public static final String IP_ADDRESS = "http://www.technicalsms.com";
    public static final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    public static final String Param = "param";


    public static class GetSms {
        public final String SOAP_ADDRESS = IP_ADDRESS + "/vendorsms/pushsms.aspx";
        public final String SOAP_ACTION = "http://tempuri.org/pushsms";
        public final String OPERATION_NAME = "pushsms";
    }
}
