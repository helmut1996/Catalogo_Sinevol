package com.helcode.catalogo_sinevol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.helcode.catalogo_sinevol.model.itemList;
import com.squareup.picasso.Picasso;

import java.io.File;

        public class MainDetalleProducto extends AppCompatActivity {
private TextView NombreDetalle,Descripcion,Precio,codigo,PrecioD;
private PhotoView imageView;
private itemList itemDatail;
String imagen="http://ferreteriaelcarpintero.com/images/productos/";
//String username=getFromSharedPreferences("username");



            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_producto);
        setTitle("Detalle Producto");


        initView();
        initValues();

    }

    public void initView(){
    NombreDetalle=findViewById(R.id.NombreDetalle);
    Descripcion=findViewById(R.id.DescripcionDetalle);
    Precio=findViewById(R.id.PrecioDetalle);
    imageView = findViewById(R.id.imageDetalle);
    codigo=findViewById(R.id.TextImagen);
    PrecioD=findViewById(R.id.PrecioDolarDetalle);
    }

    public void initValues(){
        itemDatail= (itemList) getIntent().getExtras().getSerializable("itemDetail");
        Picasso.get().load(imagen+itemDatail.getImagen())
                .error(R.drawable.error)
                .into(imageView);

        codigo.setText(itemDatail.getCodigo());
        NombreDetalle.setText(itemDatail.getNombre());
        Descripcion.setText(itemDatail.getMarca());
        Precio.setText(String.valueOf( itemDatail.getPrecioC()));
        PrecioD.setText(String.valueOf( itemDatail.getPrecioD()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shared,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.share){
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkpath=api.sourceDir;
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(Intent.createChooser(intent,"Compartir en"));
        }else if(id==R.id.email){
            Intent intent = new Intent(getApplicationContext(),MainEmail.class);
            startActivity(intent);
        }
        return true;
    }

/*
            private String getFromSharedPreferences(String key) {
                SharedPreferences sharedPref=getSharedPreferences("login_preferences",Context.MODE_PRIVATE);
                return sharedPref.getString(key,"");
            }


 */
}
