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
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.helcode.catalogo_sinevol.model.itemList;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainDetalleProducto extends AppCompatActivity  {

private TextView NombreDetalle,Usuario,Descripcion,Precio,Precio2,Precio3,Precio4,Precio5,codigo,PrecioD,PrecioD2,PrecioD3,PrecioD4,PrecioD5,Existencias,Estados,Dolares;
private PhotoView imageView;
private itemList itemDatail;
String imagen="http://ferreteriaelcarpintero.com/images/carpintero/";



            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_producto);
        setTitle("Detalle Producto");


        initView();
        initValues();
        CargarUsuario();

    }

    public void initView(){
    Usuario=findViewById(R.id.Usuarios);
    NombreDetalle=findViewById(R.id.NombreDetalle);
    Descripcion=findViewById(R.id.DescripcionDetalle);
    Dolares=findViewById(R.id.textdolares);
    Precio=findViewById(R.id.PrecioDetalle);
    Precio2=findViewById(R.id.Precio2Detalle);
    Precio3=findViewById(R.id.Precio3Detalle);
    Precio4=findViewById(R.id.Precio4Detalle);
    Precio5=findViewById(R.id.Precio5Detalle);
    PrecioD=findViewById(R.id.PrecioDolarDetalle);
    PrecioD2=findViewById(R.id.PrecioDolar2Detalle);
    PrecioD3=findViewById(R.id.PrecioDolar3Detalle);
    PrecioD4=findViewById(R.id.PrecioDolar4Detalle);
    PrecioD5=findViewById(R.id.PrecioDolar5Detalle);
    imageView = findViewById(R.id.imageDetalle);
    codigo=findViewById(R.id.TextImagen);
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
        Precio.setText("C$"+String.valueOf( itemDatail.getPrecioC()));
        Precio2.setText("C$"+String.valueOf( itemDatail.getPrecioC2()));
        Precio3.setText("C$"+String.valueOf( itemDatail.getPrecioC3()));
        Precio4.setText("C$"+String.valueOf( itemDatail.getPrecioC4()));
        Precio5.setText("C$"+String.valueOf( itemDatail.getPrecioC5()));
        PrecioD.setText("$"+String.valueOf( itemDatail.getPrecioD()));
        PrecioD2.setText("$"+String.valueOf( itemDatail.getPrecioD2()));
        PrecioD3.setText("$"+String.valueOf( itemDatail.getPrecioD3()));
        PrecioD4.setText("$"+String.valueOf( itemDatail.getPrecioD4()));
        PrecioD5.setText("$"+String.valueOf( itemDatail.getPrecioD5()));
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

            private void CargarUsuario(){
                SharedPreferences sharedPref=getSharedPreferences("login_preferences",Context.MODE_PRIVATE);
                String Users=sharedPref.getString("username","");
                Usuario.setText(Users);

                if (Usuario.getText().toString().equals("Marlon")){



                    Existencias.setVisibility(View.VISIBLE);
                    Estados.setVisibility(View.VISIBLE);
                    Dolares.setVisibility(View.VISIBLE);
                    Precio2.setVisibility(View.VISIBLE);
                    Precio3.setVisibility(View.VISIBLE);
                    Precio4.setVisibility(View.VISIBLE);
                    Precio5.setVisibility(View.VISIBLE);
                    PrecioD.setVisibility(View.VISIBLE);
                    PrecioD2.setVisibility(View.VISIBLE);
                    PrecioD3.setVisibility(View.VISIBLE);
                    PrecioD4.setVisibility(View.VISIBLE);
                    PrecioD5.setVisibility(View.VISIBLE);
                } else if (Usuario.getText().toString().equals("Facturacion")){
                    Precio.setVisibility(View.GONE);
                    Precio2.setVisibility(View.VISIBLE);
                    Dolares.setVisibility(View.VISIBLE);
                    PrecioD2.setVisibility(View.VISIBLE);

                }else if (Usuario.getText().toString().equals("Vendedor")){
                    Precio.setVisibility(View.GONE);
                    Precio2.setVisibility(View.VISIBLE);
                    Dolares.setVisibility(View.VISIBLE);
                    PrecioD2.setVisibility(View.VISIBLE);
                }

            }


            /*
                    Existencias.setVisibility(View.GONE);
                    Estados.setVisibility(View.GONE);
                    Dolares.setVisibility(View.GONE);
                    Precio2.setVisibility(View.GONE);
                    Precio3.setVisibility(View.GONE);
                    Precio4.setVisibility(View.GONE);
                    Precio5.setVisibility(View.GONE);
                    PrecioD.setVisibility(View.GONE);
                    PrecioD2.setVisibility(View.GONE);
                    PrecioD3.setVisibility(View.GONE);
                    PrecioD4.setVisibility(View.GONE);
                    PrecioD5.setVisibility(View.GONE);

                     */
}
