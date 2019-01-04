package com.example.admin.testapisms;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.testapisms.extras.SoapCall;
import com.example.admin.testapisms.extras.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendSMS(View view) {
        new Login().execute();
    }

    class Login extends AsyncTask<String, Void, Void> {
        public final String WSDL_TARGET_NAMESPACE = URL.WSDL_TARGET_NAMESPACE;
        public SoapCall cs;
        JSONObject jsonobject, returnValue;
        String IsError;
        Boolean Isexception;
        URL.GetSms url = new URL.GetSms();
        public final String SOAP_ACTION = url.SOAP_ACTION;
        public final String OPERATION_NAME = url.OPERATION_NAME;
        public final String SOAP_ADDRESS = url.SOAP_ADDRESS;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            try {
                JSONObject json = new JSONObject();


                json.put("user", "vikram");
                json.put("password", "XNWMCS8K");
                json.put("msisdn", "9649359722");
                json.put("sid", "TESTIN");
                json.put("msg", "Test message ");
                json.put("fl", "0");
                json.put("gwid", "2");
                cs = new SoapCall(json.toString(), SOAP_ADDRESS, WSDL_TARGET_NAMESPACE, OPERATION_NAME, SOAP_ACTION);
                String resp = cs.Call();
                jsonobject = new JSONObject(resp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }
    }
}
