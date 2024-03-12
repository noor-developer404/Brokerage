package com.example.brokerage.ui.contacts

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import okhttp3.Credentials
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import kotlin.concurrent.thread


class Contact_Fetch_Activity : AppCompatActivity() {

    lateinit var adapter :ContactAdapter
    lateinit var data :JSONArray
//        get() {
//            return
//        }
//        set(value) {
//            adapter.notifyDataSetChanged()
//            Log.e("SetValue", ": "+value.toString(), )
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_fetch)

        val rv=findViewById<RecyclerView>(R.id.contact_rv)
        rv.layoutManager=LinearLayoutManager(this)
        data = JSONArray()
        adapter = ContactAdapter(data)
        rv.adapter=adapter


       thread {
           data=fetchData()
//           data=testFetch()
//           test()
//           adapter.notifyDataSetChanged()
       }
        Handler().postDelayed({
            adapter = ContactAdapter(data)
            rv.adapter=adapter
            Toast.makeText(this,"running"+data.length(),Toast.LENGTH_SHORT).show()
        }, 6000)



    }

    private fun fetchContacts() {
//        val consumer = DefaultOAuthConsumer("ja6mNFJhN9DokMwRYyFSvobFi11pCZiF", "pam2jnbMi3ZvIaj27Fam0Y079m9FSq5t")
//        consumer.setTokenWithSecret("qaghNi0wGxGBnxIql4voipIzlkFHGNOC", "OGLi0tmYz9RHGILCyZIXkt4GivlIUsSZ")
//
//        val client = OkHttpClient()
//        val url = "http://192.168.1.40:8069/restapi/1.0/object/res.partner?ids=3,7&oauth_consumer_key=ja6mNFJhN9DokMwRYyFSvobFi11pCZiF&oauth_token=qaghNi0wGxGBnxIql4voipIzlkFHGNOC&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1708946892&oauth_nonce=15&oauth_version=1.0&oauth_signature=2h9Z0vm8lQI6z9azuHhb62selJo%3D"
//
//        val requestBody = "".toRequestBody("text/plain".toMediaType())
//
//        // Sign the URL
//        val signedUrl = consumer.sign(url)
//
//        val request = Request.Builder()
//            .url(signedUrl)
//            .post(requestBody)
//            .addHeader("Cookie", "frontend_lang=en_US; session_id=57f4e5ed59bad60a8a04f8e18150d367c0c3bad8")
//            .build()
//
//        // Execute the request asynchronously
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                // Handle failure
//                e.printStackTrace()
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                // Log message to indicate onResponse is being executed
//                Log.d("Contact_Fetch_Activity", "onResponse executed")
//
//                // Handle successful response
//                val responseBody = response.body?.string()
//
//                // Update UI components on the main thread
//                runOnUiThread {
//                    // Update your TextView or any other UI component here
//                    // For example, if you have a TextView with id "textView" in your layout
//                    val textView = findViewById<TextView>(R.id.textView)
//                    textView.text = responseBody
//                }
//            }
//        })
    }

    fun fetchData(): JSONArray{
//        val url = "http://192.168.1.40:8069/restapi/1.0/object/res.partner/3?oauth_consumer_key=ja6mNFJhN9DokMwRYyFSvobFi11pCZiF&oauth_token=qaghNi0wGxGBnxIql4voipIzlkFHGNOC&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1709011346&oauth_nonce=3NTeH1VL0SQ&oauth_version=1.0&oauth_signature=nLnJb3c%2FkGqH0m4p0gTpXw78F%2B4%3D"
//        val demmo_url="https://jsonplaceholder.typicode.com/todos/1"
        val client = OkHttpClient()
        val mediaType = "text/plain".toMediaType()
        val body = "".toRequestBody(mediaType)
        val request = Request.Builder()
            .url("http://192.168.1.40:8069/restapi/1.0/object/res.partner?ids=3,7,8,9,10,11,12,13,14&oauth_consumer_key=ja6mNFJhN9DokMwRYyFSvobFi11pCZiF&oauth_token=qaghNi0wGxGBnxIql4voipIzlkFHGNOC&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1709033759&oauth_nonce=vMeGU7vrBdr&oauth_version=1.0&oauth_signature=7b1UApxadwgqDQEg4id7utFdLSI%3D")
            .post(body)
            .addHeader("Cookie", "frontend_lang=en_US; session_id=5e8f12add4cb03d5ad975f645b5a0bae5e8be46a")
            .build()
        val response = client.newCall(request).execute()
        val bodyString = response.peekBody(Long.MAX_VALUE).string()
        Log.e("Contacts", "fetchData: "+  response.peekBody(648).string())
        var jsonData:String = response.body?.string().toString()
        val jsonObject = JSONObject(bodyString)
        Log.e("Contacts", "fetchData: "+ jsonObject.getJSONArray("res.partner").toString())
        val jsonArray = jsonObject.getJSONArray("res.partner")
        return jsonArray
//        if (jsonArray != null) {
//            Log.e("Contacts", "fetchData: "+ jsonArray.getJSONObject(0))
//        }
    }

    fun testFetch():JSONArray{
        val client = OkHttpClient()
        val consumerKey = "ja6mNFJhN9DokMwRYyFSvobFi11pCZiF"
        val consumerSecret = "pam2jnbMi3ZvIaj27Fam0Y079m9FSq5t"
        val accessToken = "vXmfiC61ZAc4YDH1AOExpDbRWug6BDjS"
        val accessSecret = "itvbwQlYVh2paIRcpI8VvAf1UmISB1ju"
        var oauthHeader: String = Credentials.basic(consumerKey, consumerSecret)
        val oauthToken =
            "oauth_token=\"$accessToken\",oauth_token_secret=\"$accessSecret\""
        oauthHeader += ",$oauthToken"
        val request = Request.Builder()
            .url("http://192.168.1.40:8069/restapi/1.0/object/res.partner")
            .header("Authorization", "OAuth $oauthHeader")
            .build()

//        client.newCall(request).execute().use { response ->
//            if (!response.isSuccessful()) throw IOException("Unexpected code $response")
//            System.out.println(response.body()!!.string())
//        }

//        val mediaType = "text/plain".toMediaType()
//        val body = "".toRequestBody(mediaType)
//        val request = Request.Builder()
//            .url("http://192.168.1.40:8069/restapi/1.0/object/res.partner?ids=3,7,8,9,10,11,12,13,14&oauth_consumer_key=ja6mNFJhN9DokMwRYyFSvobFi11pCZiF&oauth_token=qaghNi0wGxGBnxIql4voipIzlkFHGNOC&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1709033759&oauth_nonce=vMeGU7vrBdr&oauth_version=1.0&oauth_signature=7b1UApxadwgqDQEg4id7utFdLSI%3D")
//            .post(body)
//            .addHeader("Cookie", "frontend_lang=en_US; session_id=5e8f12add4cb03d5ad975f645b5a0bae5e8be46a")
//            .build()
        val response = client.newCall(request).execute()
        val bodyString = response.peekBody(Long.MAX_VALUE).string()
        Log.e("Contacts", "fetchData: "+  response.peekBody(648).string())
//        var jsonData:String = response.body?.string().toString()
//        val jsonObject = JSONObject(bodyString)
//        Log.e("Contacts", "fetchData: "+ jsonObject.getJSONArray("res.partner").toString())
//        val jsonArray = jsonObject.getJSONArray("res.partner")
        return JSONArray()
    }

    fun test(){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://192.168.1.40:8069/restapi/1.0/object/res.partner/fields_get?allfields=[]&attributes=['string','help','type']&oauth_consumer_key=ja6mNFJhN9DokMwRYyFSvobFi11pCZiF&oauth_token=qaghNi0wGxGBnxIql4voipIzlkFHGNOC&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1709040934&oauth_nonce=qIgTgDxkZE0&oauth_version=1.0&oauth_signature=CRk4jyaAwBPLhFAf9uHHlkNZcg0%3D")
            .addHeader("Cookie", "frontend_lang=en_US; session_id=5e8f12add4cb03d5ad975f645b5a0bae5e8be46a")
            .build()
        val response = client.newCall(request).execute()
        Log.e("MyTest", "test: "+ response.body!!.string() )
    }
}
