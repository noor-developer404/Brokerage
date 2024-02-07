package com.example.brokerage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OdooService {
    @POST("/jsonrpc")
    Call<OdooResponse> authenticate(@Body OdooRequest request);

    @POST("/jsonrpc")
    Call<OdooResponse> execute(@Body OdooRequest request);
}
