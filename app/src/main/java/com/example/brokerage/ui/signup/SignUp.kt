package com.example.brokerage.ui.signup

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.brokerage.R
import com.example.brokerage.databinding.ActivitySignUpBinding
import com.example.brokerage.ui.signin.SignIn
import com.example.brokerage.ui.userhome.user_home
import com.example.brokerage.utils.SharedPref
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import java.util.Arrays
import com.facebook.GraphRequest
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.auth
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers


class SignUp : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySignUpBinding
    private lateinit var oneTapClient: SignInClient
    private lateinit var signUpRequest: BeginSignInRequest
    private val REQ_ONE_TAP = 2
    private var showOneTapUI = true
    lateinit var callbackManager : CallbackManager
    private lateinit var auth: FirebaseAuth
    lateinit var provider: OAuthProvider.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupNextBtn.setOnClickListener(this)
        binding.signupLogin.setOnClickListener(this)
        binding.signupFacebook.setOnClickListener(this)
        auth = Firebase.auth

        var sp = SharedPref(this)
        if (sp.SP_ifLogin()){
            val intent = Intent(this,user_home::class.java)
            startActivity(intent)
            this.finish()
        }


//        apple signin start

        provider = OAuthProvider.newBuilder("apple.com")
        provider.setScopes(arrayOf("email", "name").toMutableList())
        // Localize the Apple authentication screen in French.
        provider.addCustomParameter("locale", "fr")
        val pending = auth.pendingAuthResult
        if (pending != null) {
            pending.addOnSuccessListener { authResult ->
                Log.d("apple", "checkPending:onSuccess:$authResult")
                // Get the user profile with authResult.getUser() and
                // authResult.getAdditionalUserInfo(), and the ID
                // token from Apple with authResult.getCredential().
            }.addOnFailureListener { e ->
                Log.w("apple", "checkPending:onFailure", e)
            }
        } else {

            Log.d("apple", "pending: null")
        }

        auth.startActivityForSignInWithProvider(this, provider.build())
            .addOnSuccessListener { authResult ->
                // Sign-in successful!
                Log.d("apple", "activitySignIn:onSuccess:${authResult.user}")
                val user = authResult.user
                // ...
            }
            .addOnFailureListener { e ->
                Log.w("apple", "activitySignIn:onFailure", e)
            }


//        apple signin end


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


        var intentSender = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult(),
            ActivityResultCallback {
                if (it.resultCode==Activity.RESULT_OK){
                    try {
                        val credential = oneTapClient.getSignInCredentialFromIntent(it.data)
                        val idToken = credential.googleIdToken
                        when {
                            idToken != null -> {
                                val email = credential.id
                                val name = credential.displayName
                                val img = credential.profilePictureUri
//                                sp.SP_userDetails(name.toString(),email,img.toString())
                                sp.SP_login(name.toString(),email,img.toString())
                                val intent = Intent(this,user_home::class.java)
                                startActivity(intent)
                                this.finish()

                                Toast.makeText(this,"email: "+credential.googleIdToken,Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                // Shouldn't happen.
                                Log.e("google", "No ID token!")
                            }
                        }
                    } catch (e: ApiException) {
                        // ...
                    }
                }
            })
        binding.signupGoogleBtn.setOnClickListener {
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
                    Log.e("google", e.localizedMessage)
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
//        facebook login end1


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.signup_login->{
                val intent = Intent(this,SignIn::class.java)
                startActivity(intent)
            }
            R.id.signup_next_btn->{
                val intent = Intent(this,user_home::class.java)
                startActivity(intent)
            }
            R.id.signup_apple_btn->{



            }
            R.id.signup_google_btn->{

            }
            R.id.signup_facebook->{
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"))
//                Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

}