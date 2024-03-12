package com.example.brokerage.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPref{

    var context:Context
    var editor:SharedPreferences.Editor
    var sharedPreference :SharedPreferences

    constructor(context: Context) {
        this.context = context

        val SP_PREF = "AppPreference"
        sharedPreference =  context.getSharedPreferences(SP_PREF,Context.MODE_PRIVATE)
        editor = sharedPreference.edit()
    }


    fun SP_login(name:String,email:String,img:String){
        editor.putString("name",name)
        editor.putString("email",email)
        editor.putString("img",img)
        editor.putBoolean("loginStatus",true)
        editor.commit()
    }
    fun SP_object(){

    }
    fun SP_logout(){
        editor.putString("name","")
        editor.putString("email","")
        editor.putString("img","")
        editor.putBoolean("loginStatus",false)
        editor.commit()
    }
    fun SP_ifLogin() :Boolean{
        return sharedPreference.getBoolean("loginStatus",false)
    }
}