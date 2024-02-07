package com.example.brokerage;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OdooManager {
    private static final String BASE_URL = "https://www.century21.ae/web/";
//    private static final String BASE_URL = "https://demo.odoo.com/start/";

    private OdooService service;

    public OdooManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OdooService.class);
    }

    public void authenticate(String database, String username, String password) {
        OdooRequest request = new OdooRequest("common", "authenticate", Arrays.asList(
                database, username, password, Collections.emptyMap()));
        Call<OdooResponse> call = service.authenticate(request);
        // Make the authentication request asynchronously
        call.enqueue(new Callback<OdooResponse>() {
            @Override
            public void onResponse(Call<OdooResponse> call, Response<OdooResponse> response) {
                // Handle authentication response
                Log.e("odoo", "onResponse: auth "+ new Gson().toJson(response));
            }

            @Override
            public void onFailure(Call<OdooResponse> call, Throwable t) {
                // Handle authentication failure
                Log.e("odoo", "onFailure: authError" );
            }
        });
    }

    public void execute(String model, String method, List<Object> params) {
        OdooRequest request = new OdooRequest("object", "execute_kw", Arrays.asList(
                model, method, params));
        Call<OdooResponse> call = service.execute(request);
        // Make the execute request asynchronously
        call.enqueue(new Callback<OdooResponse>() {
            @Override
            public void onResponse(Call<OdooResponse> call, Response<OdooResponse> response) {
                // Handle execute response
                Log.e("odoo", "onResponse: execute "+ new Gson().toJson(response));
            }

            @Override
            public void onFailure(Call<OdooResponse> call, Throwable t) {
                // Handle execute failure
                Log.e("odoo", "onFailure: execute error" );
            }
        });
    }
}

