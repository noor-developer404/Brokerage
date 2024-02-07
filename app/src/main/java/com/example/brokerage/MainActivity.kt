package com.example.brokerage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.apache.xmlrpc.client.XmlRpcClient
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://www.century21.ae/web"
        val db = "mazenwb338-century21-prod-5851762"
        val username = "mobile-app@century21.ae"
        val password = "e89DMZ8pM"

        val client = XmlRpcClient()
        val clientConfig = XmlRpcClientConfigImpl()

        clientConfig.serverURL= URL(url)

//        client.execute(clientConfig,"start", )
    }
}