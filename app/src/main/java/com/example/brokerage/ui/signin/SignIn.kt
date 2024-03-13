package com.example.brokerage.ui.signin

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivitySignInBinding
import com.example.brokerage.models.loginModel
import com.example.brokerage.ui.forgotPassword.ForgotPassword
import com.example.brokerage.ui.profileSetup.ProfileSetup
import com.example.brokerage.ui.signup.SignUp
import com.example.brokerage.ui.userhome.user_home
import com.example.brokerage.utils.Constants.LOGIN_BASE_URL
import com.example.brokerage.utils.RetrofitInstance
import com.example.brokerage.utils.SharedPref
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Arrays

class SignIn : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var oneTapClient: SignInClient
    private lateinit var signUpRequest: BeginSignInRequest
    private val REQ_ONE_TAP = 2
    private var showOneTapUI = true
    lateinit var callbackManager : CallbackManager
    lateinit var sp:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginForgotPass.setOnClickListener(this)
        binding.signinRegister.setOnClickListener(this)
        binding.signinGoogle.setOnClickListener(this)
        binding.signinFacebook.setOnClickListener(this)
        binding.signinLoginBtn.setOnClickListener(this)

         sp = SharedPref(this)
        if (sp.SP_ifLogin()){
            val intent = Intent(this,user_home::class.java)
            startActivity(intent)
        }
        oneTapClient = Identity.getSignInClient(this)
        signUpRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.web_client_id))
                    // Show all accounts on the device.
                    .setFilterByAuthorizedAccounts(false)
                    .build())
            .build()

        var intentSender = registerForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult(),
            ActivityResultCallback {
                if (it.resultCode== RESULT_OK){
                    try {
                        val credential = oneTapClient.getSignInCredentialFromIntent(it.data)
                        val idToken = credential.googleIdToken
                        when {
                            idToken != null -> {
                                val email = credential.id
                                val name = credential.displayName
                                val img = credential.profilePictureUri
                                sp.SP_login(name.toString(),email,img.toString())
                                val intent = Intent(this,user_home::class.java)
                                startActivity(intent)
                                this.finish()

                                Toast.makeText(this,"email: "+credential.googleIdToken,Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                // Shouldn't happen.
                                Log.d("google", "No ID token!")
                            }
                        }
                    } catch (e: ApiException) {
                        // ...
                    }
                }
            })

        binding.signinGoogle.setOnClickListener {
            oneTapClient.beginSignIn(signUpRequest)
                .addOnSuccessListener(this) { result ->
                    try {
                        var intentSenderrequest = IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                        intentSender.launch(intentSenderrequest)
                    } catch (e: IntentSender.SendIntentException) {
                        Log.e("google", "Couldn't start One Tap UI: ${e.localizedMessage}")
                    }
                }
                .addOnFailureListener(this) { e ->
                    // No Google Accounts found. Just continue presenting the signed-out UI.
                    Log.d("google", e.localizedMessage)
                }
        }

//        facebook login start
        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    // App code
                    val request = GraphRequest.newMeRequest(loginResult.accessToken, GraphRequest.GraphJSONObjectCallback
                    { obj, response ->
                        sp.SP_login(obj!!.getString("name"),"","")
                        val intent = Intent(applicationContext,user_home::class.java)
                        startActivity(intent)
                        finish()
//                        Toast.makeText(applicationContext,response.toString()+" "+obj.toString(),Toast.LENGTH_SHORT).show()
//                        Log.e("myFacebook", "onSuccess: "+response.toString()+" "+obj.toString() )
                    })
                    val parameters = Bundle().apply {
                        putString("fields", "id,name,email,picture.type(large)")
                    }
                    request.parameters = parameters
                    request.executeAsync()

                    Toast.makeText(applicationContext,"clicked"+loginResult.accessToken.userId,Toast.LENGTH_SHORT).show()
                }

                override fun onCancel() {
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                }
            })
//        facebook login end
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_forgotPass->{
                val intent = Intent(this, ForgotPassword::class.java)
                startActivity(intent)
            }
            R.id.signin_register->{
                val intent = Intent(this, SignUp::class.java)
                startActivity(intent)
            }
            R.id.signin_login_btn->{
//                Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
                if (!sp.SP_ifLogin()){
                    login()
                }
            }
            R.id.signin_facebook->{
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"))
//                Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun login(){
        val instance = RetrofitInstance(LOGIN_BASE_URL)
         instance.getInstance().apiInterface.login(binding.sigiInEmail.text.toString(),"abc@gmail.com","123456",binding.signInPass.text.toString(),"android","13").enqueue(object :Callback<loginModel>{
             override fun onResponse(call: Call<loginModel>, response: Response<loginModel>) {
                 Log.e("loginDetails", "onResponse: "+ response.body()?.get(0).toString() )
//                 Log.e("loginDetails", "onResponse: "+ response.body()?.get(0)?.emailId+"  "+response.body()?.get(0)?.phone_no )
                 sp.SP_login("",response.body()?.get(0)?.emailId.toString(),"")
                 startActivity(Intent(applicationContext,user_home::class.java))
                 finish()
//                 val result = response.body()

             }

             override fun onFailure(call: Call<loginModel>, t: Throwable) {
                 Log.e("loginDetails", "onFailure: "+ t.toString() )
             }

         })

    }
}