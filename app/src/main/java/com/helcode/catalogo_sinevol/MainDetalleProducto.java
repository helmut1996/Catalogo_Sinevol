package com.helcode.catalogo_sinevol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.PhoneNumberUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.helcode.catalogo_sinevol.model.itemList;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainDetalleProducto extends AppCompatActivity {
private TextView NombreDetalle,Descripcion,Precio,codigo,PrecioD,Existencias,Estados;
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
    Estados=findViewById(R.id.EstadoDetalle);
    Existencias=findViewById(R.id.ExistenciaDetalle);
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
        Existencias.setText(String.valueOf(itemDatail.getExistencia()));
        Estados.setText(itemDatail.getEstado());
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
          CompartirImagen();
        }else if(id==R.id.email){
            Lanzarwhatsapp("86338407");
        }
        return true;
    }

            private void CompartirImagen() {
               StrictMode.VmPolicy.Builder builder=new StrictMode.VmPolicy.Builder();
               StrictMode.setVmPolicy(builder.build());
                BitmapDrawable drawable=(BitmapDrawable)imageView.getDrawable();
                Bitmap bitmap=drawable.getBitmap();
                File f=new File(getExternalCacheDir()+"/"+getResources().getString(R.string.app_name)+".jpg");
                Intent sharedintent;
                try {
                    FileOutputStream outputStream=new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                    outputStream.flush();
                    outputStream.close();
                    sharedintent=new Intent(Intent.ACTION_SEND);
                    sharedintent.setType("image/*");
                    sharedintent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(f));
                    sharedintent.setType("text/plain");
                    sharedintent.putExtra(sharedintent.EXTRA_TEXT,NombreDetalle.getText().toString());
                    sharedintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                }catch (Exception e){
                    throw  new RuntimeException(e);
                }
                startActivity(Intent.createChooser(sharedintent,"Compartiendo imagen"));
            }

    private void Lanzarwhatsapp(String telefono) {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        _intencion.setType("text/plain");
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("505" + telefono)+"@s.whatsapp.net");
        _intencion.putExtra(Intent.EXTRA_TEXT, "Scientia Soluciones Informáticas - http://www.scientia.com.ar");
        startActivity(_intencion);
    }
/*
            private String getFromSharedPreferences(String key) {
                SharedPreferences sharedPref=getSharedPreferences("login_preferences",Context.MODE_PRIVATE);
                return sharedPref.getString(key,"");
            }


 */
}
