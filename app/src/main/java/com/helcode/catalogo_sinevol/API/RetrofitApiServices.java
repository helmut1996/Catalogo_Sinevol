package com.helcode.catalogo_sinevol.API;

import com.helcode.catalogo_sinevol.model.itemList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiServices {
    @GET("inventario")
    Call<List<itemList>>getItemBD();
}
