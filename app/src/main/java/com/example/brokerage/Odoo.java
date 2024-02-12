package com.example.brokerage;

import static java.util.Collections.emptyList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Odoo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odoo);

//        mpass = admin
//        dbname=admin
//        pass = admin
//        emai=@ajath

        final String
                url = "https://www.century21.ae/web",
//                https://www.century21.ae/web/dataset/call_rpc
//                dbAdmin = "mazenwb338-century21-prod-5851762",
//                url="https://ajath4.odoo.com/web",
                db = "ajath4",
                username = "Noor",
                password = "Noor123@";

//        OdooManager manager = new OdooManager();
//        manager.authenticate(db,username,password);
//        manager.execute("res.partner","create",emptyList());


        final XmlRpcClient client = new XmlRpcClient();
        final XmlRpcClientConfigImpl start_config = new XmlRpcClientConfigImpl();
        try {
//            "https://demo.odoo.com/start"
//            start_config.setServerURL(new URL(url));
            start_config.setServerURL(new URL(String.format("%s/xmlrpc/2/common", url)));


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                Log.e("odoo", "onCreate: running" );
                final Map<String, String> info;
                try {
                    client.execute(start_config, "version", emptyList());
//                    info = (Map<String, String>)client.execute(
//                            start_config, "start",emptyList());
                } catch (XmlRpcException e) {
                    throw new RuntimeException(e);
                }
                Log.e("odoo", "onCreate: ");
            }
        });
        thread.start();


    }
}