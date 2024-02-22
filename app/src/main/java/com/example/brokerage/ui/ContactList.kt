package com.example.brokerage.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RetryPolicy
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.brokerage.R
import kotlinx.coroutines.asCoroutineDispatcher
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.math.log


class ContactList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        thread {
            fetch()
        }


//        val CONSUMER_KEY = "OQit5Xe0elrhM0mLguhfnSgrgUaLEeyG"
//        val CONSUMER_SECRET_KEY="L3IvHNMdzFxp98jkTx0HNfJaF37VjOfw"
//        val ACCESS_TOKEN="vXmfiC61ZAc4YDH1AOExpDbRWug6BDjS"
//        val ACCESS_SECRET_KEY="Lb0T4E9NlFGyshr5PwYgX2zvZ7zoqV7v"
//
//
//        val params = JSONObject()
//        params.put("oauth_consumer_key", "OQit5Xe0elrhM0mLguhfnSgrgUaLEeyG")
//        params.put("oauth_nonce", "To00JcImA8G")
//        params.put("oauth_signature", "qw4bp%2FerbxpOTzYmR7WwMkhm78Y%3D")
//        params.put("oauth_signature_method", "HMAC-SHA1")
//        params.put("oauth_timestamp", "1708602703")
//        params.put("oauth_token", "VxwJKPAY49Pr8T1YCgnGgj5imUIlqBIJ")
//        params.put("oauth_version", "1.0")
//
//
//        val url="http://192.168.1.40:8069/restapi/1.0/object/res.partner/3"
////        val url = "https://jsonplaceholder.typicode.com/todos/1"
//        var queue = Volley.newRequestQueue(this)
//
//
//
////    val queue: RequestQueue = Volley.newRequestQueue(applicationContext)
//
//        // on below line we are creating a variable for request
//        // and initializing it with json object request
//        val request = JsonObjectRequest(Request.Method.GET, url, params, { response ->
//
//            Log.e("MYRES", "onCreate: hii res"+response )
//
//
//        }, { error ->
//            Log.e("MYRES", "onCreate: hii error" )
//            Log.e("MYRES", "RESPONSE IS $error")
//            // in this case we are simply displaying a toast message.
//            Toast.makeText(this, "Fail to get response", Toast.LENGTH_SHORT)
//                .show()
//        })
//
//        request.setRetryPolicy(object : RetryPolicy {
//            override fun getCurrentTimeout(): Int {
//                return 50000
//            }
//
//            override fun getCurrentRetryCount(): Int {
//                return 50000
//            }
//
//            @Throws(VolleyError::class)
//            override fun retry(error: VolleyError) {
//            }
//        })
//
//
//        queue.add(request)


    }

    fun fetch(){
        val client = OkHttpClient()
        val mediaType = "text/plain".toMediaType()
        val body = "".toRequestBody(mediaType)
        val request = Request.Builder()
            .url("http://192.168.1.40:8069/restapi/1.0/object/res.partner/3?oauth_consumer_key=OQit5Xe0elrhM0mLguhfnSgrgUaLEeyG&oauth_token=VxwJKPAY49Pr8T1YCgnGgj5imUIlqBIJ&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1708606391&oauth_nonce=GUTP9ayTlX6&oauth_version=1.0&oauth_signature=yaotf114q1ESUQ7D7iZ1EfBPeL4%3D")
            .post(body)
            .addHeader("Cookie", "frontend_lang=en_US; session_id=f1be9a05c70ca0ce6b5730710d4e3ee385a30025")
            .build()

        val response = client.newCall(request).execute()
        Log.e("MYRES", "fetch:  hiii " + response )
    }

    // at last we are adding
    // our request to our queue.
}