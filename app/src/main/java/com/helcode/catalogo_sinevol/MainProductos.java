package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.helcode.catalogo_sinevol.API.APIClient;
import com.helcode.catalogo_sinevol.API.InterfaceAPI;
import com.helcode.catalogo_sinevol.adapter.AdapterProductos;

import com.helcode.catalogo_sinevol.model.itemList;

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
TextView prueba;
AdapterProductos adapterProductos;
ImageButton btn_buscador;
private InterfaceAPI api;

private static final String TAG="Productos";
private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_productos);




            initView();
            initValues();
            initListenner();

            //IMPLEMENTANDO VOLLEY PARA LLAMAR LOS DATOS
  /*
        RequestQueue queue= Volley.newRequestQueue(this);
        String URL="https://marnor.herokuapp.com/inventario";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                prueba.setText("Respuesta:"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                prueba.setText("ERROR DE CONEXION A LA API");
            }
        });
        queue.add(stringRequest);

   */
    }


    public void initView(){

        prueba=findViewById(R.id.textprueba);
        listproduct=findViewById(R.id.RecyclerProducto);
        svSearch=findViewById(R.id.Buscador);
        btn_buscador=findViewById(R.id.button);

    }

    public void initValues(){
        api= APIClient.getProductos();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listproduct.setLayoutManager(manager);

       // items= getItems();

       // adapterProductos= new AdapterProductos(items,this);
        //listproduct.setAdapter(adapterProductos);
        getItemsSQL();
    }

    public void initListenner(){
        svSearch.setOnQueryTextListener(this);
    }
/* public List<itemList> getItems(){
    List<itemList>itemLists=new ArrayList<>();
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

    return  itemLists;

    } */


public void getItemsSQL(){
    api.getItemBD().enqueue(new Callback<List<itemList>>() {
        @Override
        public void onResponse(Call<List<itemList>> call, Response<List<itemList>> response) {

            items= response.body();
             adapterProductos= new AdapterProductos(items,MainProductos.this);
            listproduct.setAdapter(adapterProductos);
        }

        @Override
        public void onFailure(Call<List<itemList>> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"Error"+t.getMessage(),Toast.LENGTH_LONG).show();
            System.out.println("Error:=====>"+t.getMessage());
        }
    });
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