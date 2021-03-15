package com.helcode.catalogo_sinevol.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClienteRetrofit {
    private static Retrofit retrofit=null;
    private static String URL_BASE="https://marnor.herokuapp.com/";

    public static  RetrofitApiServices getApiService(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApiServices.class);
    }
}
