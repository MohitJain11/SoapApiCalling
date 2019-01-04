package com.example.admin.testapisms.extras;

/**
 * Created by Admin on 1/4/2019.
 */

import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SoapCall {


    public  String SOAP_ACTION;

    public   String OPERATION_NAME;

    public   String WSDL_TARGET_NAMESPACE;

    public   String SOAP_ADDRESS ;
    String data ;
    public SoapCall(String data, String SOAP_ADDRESS, String WSDL_TARGET_NAMESPACE, String OPERATION_NAME, String SOAP_ACTION)
    {this.OPERATION_NAME=OPERATION_NAME;
        this.SOAP_ADDRESS=SOAP_ADDRESS;
        this.WSDL_TARGET_NAMESPACE=WSDL_TARGET_NAMESPACE;
        this.data=data;
        this.SOAP_ACTION=SOAP_ACTION;
    }
    public String Call()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();
        pi.setName(URL.Param);
       /* JSONObject json =  new JSONObject();

        try {
            json.put("Id","1");

        json.put("Name","test");
        json.put("Category","test");
        json.put("Price","1");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        pi.setValue(data);
        pi.setType(String.class);
        request.addProperty(pi);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS,180000);
        Object response=null;
        SoapObject obj=null;
        try
        {
            httpTransport.call(SOAP_ACTION, envelope);
            response = envelope.getResponse();


          /*JSONArray j =new JSONArray(response.toString());
            JSONObject jobj =new JSONObject (j.get(1).toString());
            */







        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        if(response==null)
        {return "something went wrong";}
        else {
            return response.toString();
        }
    }

    public String geoTaggingCall()
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
        PropertyInfo pi=new PropertyInfo();
        pi.setName("prefixText");
       /* JSONObject json =  new JSONObject();

        try {
            json.put("Id","1");

        json.put("Name","test");
        json.put("Category","test");
        json.put("Price","1");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        pi.setValue(data);
        pi.setType(String.class);
        request.addProperty(pi);
        pi=new PropertyInfo();
        pi.setName("count");
       /* JSONObject json =  new JSONObject();

        try {
            json.put("Id","1");

        json.put("Name","test");
        json.put("Category","test");
        json.put("Price","1");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        pi.setValue(10);
        pi.setType(Integer.class);
        request.addProperty(pi);



        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;

        envelope.setOutputSoapObject(request);


        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response=null;
        SoapObject obj=null;
        try
        {
            httpTransport.call(SOAP_ACTION, envelope);
            response = envelope.getResponse();


          /*JSONArray j =new JSONArray(response.toString());

            JSONObject jobj =new JSONObject (j.get(1).toString());
            */







        }
        catch (Exception exception)
        {
            response=exception.toString();
        }


        return response.toString();
    }
}