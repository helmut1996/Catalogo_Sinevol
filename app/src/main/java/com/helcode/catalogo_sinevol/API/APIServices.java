package com.helcode.catalogo_sinevol.API;

import com.helcode.catalogo_sinevol.model.RequestAPI;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIServices {
    @GET("pokemon")
    Call<RequestAPI> obtenerListaProducto();

}
