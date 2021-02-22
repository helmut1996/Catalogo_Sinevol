package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.helcode.catalogo_sinevol.adapter.AdapterProductos;
import com.helcode.catalogo_sinevol.model.itemList;

import java.util.ArrayList;
import java.util.List;

public class MainProductos extends AppCompatActivity {
RecyclerView listproduct;
List<itemList>items;
AdapterProductos adapterProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_productos);

initView();
initValues();

    }

    public void initView(){
        listproduct=findViewById(R.id.RecyclerProducto);
    }

    public void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listproduct.setLayoutManager(manager);

        items= getItems();
        adapterProductos= new AdapterProductos(items);
        listproduct.setAdapter(adapterProductos);
    }

    public List<itemList> getItems(){
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

    }
}