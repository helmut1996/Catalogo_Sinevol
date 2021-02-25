package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainEmail extends AppCompatActivity {

    EditText correo,nombreUsuario,mensaje;
    ImageView imagen_MSM;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_email);

        setTitle("Enviar Correo");


        initViewM();
    }

    private void initViewM() {
        correo=findViewById(R.id.editTextCorreo);
        nombreUsuario=findViewById(R.id.editTextNombre);
        mensaje=findViewById(R.id.editTextMensaje);
        imagen_MSM=findViewById(R.id.imagenMSM);
        btnEnviar=findViewById(R.id.btnenviar);
    }
}