package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.helcode.catalogo_sinevol.API.APIServices;
import com.helcode.catalogo_sinevol.BDConexion.DBConnection;
import com.helcode.catalogo_sinevol.adapter.AdapterProductos;

import com.helcode.catalogo_sinevol.model.itemList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainProductos extends AppCompatActivity implements AdapterProductos.RecyclerItemClick, SearchView.OnQueryTextListener {
RecyclerView listproduct;
SearchView svSearch;
List<itemList>items;
AdapterProductos adapterProductos;
ImageButton btn_buscador;

private static final String TAG="Productos";
private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_productos);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

///// consumir datos de api con retrofit
     /*
        retrofit=new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
        ///// consumir datos de api con retrofit



            initView();
            initValues();
            initListenner();
    }
/*
    private void ObtenerDatos() {

        APIServices services =retrofit.create(APIServices.class);
        Call<RequestAPI> requestAPICall = services.obtenerListaProducto();
        requestAPICall.enqueue(new Callback<RequestAPI>() {
            @Override
            public void onResponse(Call<RequestAPI> call, Response<RequestAPI> response) {
                if (response.isSuccessful()){
                    RequestAPI requestAPI=response.body();
                    ArrayList<Pokemon>lists_producto =requestAPI.getResults();
                    for (int i =0; i<lists_producto.size();i++){
                        Pokemon item= lists_producto.get(i);
                        Log.e(TAG,"POKEMON;"+ item.getName());
                    }
                }else{
                    Log.e(TAG,"Respuesta;"+ response.body());
                }
            }

            @Override
            public void onFailure(Call<RequestAPI> call, Throwable t) {
                Log.e(TAG,"Error:"+ t.getMessage());
            }
        });
    }

 */
    public void initView(){
        listproduct=findViewById(R.id.RecyclerProducto);
        svSearch=findViewById(R.id.Buscador);
        btn_buscador=findViewById(R.id.button);

    }

    public void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listproduct.setLayoutManager(manager);

        items= getItems();
        adapterProductos= new AdapterProductos(items,this);
        listproduct.setAdapter(adapterProductos);
    }

    public void initListenner(){
        svSearch.setOnQueryTextListener(this);
    }


    public List<itemList> getItems(){
    List<itemList>itemLists=new ArrayList<>();

        DBConnection dbConnection = new DBConnection();
        dbConnection.conectar();

        try {

            Statement st = dbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select Nombre,Unidad_Med,PrecioC from inventario");
            while (rs.next()){
            itemLists.add(new itemList(
                    rs.getString("Nombre"),
                    rs.getString("Unidad_Med"),
                    rs.getDouble("PrecioC"),
                    R.drawable.images
                    ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    /*
    itemLists.add(new itemList("cosmetico","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("lapiz de ceja ","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("oso de peluche","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("lapiz de ceja ","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("lapiz de ceja ","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("tinte kool ","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("tinte kool","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("boby azul","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("tinte kool ","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("tinte kool","descripcion",55.60,R.drawable.images));
    itemLists.add(new itemList("boby azul","descripcion",55.60,R.drawable.images));


     */
    return  itemLists;

    }

    @Override
    public void itemClick(itemList item) {
        Intent intent = new Intent(this, MainDetalleProducto.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        btn_buscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterProductos.filter(newText);
            }
        });


        return false;
    }
}