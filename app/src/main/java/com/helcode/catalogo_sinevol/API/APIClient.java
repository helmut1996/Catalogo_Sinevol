package com.helcode.catalogo_sinevol.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String  BASE_URL="https://marnor.herokuapp.com/";
    public static Retrofit retrofit;

    public static Retrofit getProductos(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
