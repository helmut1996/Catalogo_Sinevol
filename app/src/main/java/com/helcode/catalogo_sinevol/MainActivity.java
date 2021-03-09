package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.helcode.catalogo_sinevol.Entity.Usuarios;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    EditText passw;
    Spinner user;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.textUser);
        passw = findViewById(R.id.textpass);
        login = findViewById(R.id.btn_Login);
        login.setOnClickListener(this);

        //esta funcion se utiliza para la lista de usuarios
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.User, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user.setAdapter(adapter1);

///////////////////////////////////////////////////////////////////////////////////////////
    }


/*
para insertar Datos
    private void insertRecords(){
        Usuarios usu = new Usuarios();
        String Users=user.getSelectedItem().toString();
        String Pass=passw.getText().toString();

        usu.setNombreUsuario(Users);
        usu.setPassUsuario(Pass);

        usu.save();
        Toast.makeText(this,"Guardado Usuario",Toast.LENGTH_LONG).show();
        passw.setText("");
    }


 */
public void  login(){
    Usuarios.find(Usuarios.class, "nombre_usuario = ? and password = ?", user.getSelectedItem().toString(), passw.getText().toString());

}
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_Login:
                if (user.getSelectedItemPosition()==0){
                    Toast.makeText(this,"Debes de seleccionar un usuario",Toast.LENGTH_SHORT).show();
                }else if (passw.getText().toString().isEmpty()){
                    Toast.makeText(this,"debes ingresar una contraseña",Toast.LENGTH_SHORT).show();
                }else {
                      login();
                     Intent intent = new Intent(getApplicationContext(), MainProductos.class);
                    startActivity(intent);
                }
              //  insertRecords();

                break;

        }

    }


}

