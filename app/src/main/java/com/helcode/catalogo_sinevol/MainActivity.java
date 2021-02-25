package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.helcode.catalogo_sinevol.SQLite.ConexionSQLiteHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
EditText passw;
Spinner user;
Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.textUser);
        passw=findViewById(R.id.textpass);
        login=findViewById(R.id.btn_Login);
        login.setOnClickListener(this);


        ArrayAdapter<CharSequence> adapter1 =ArrayAdapter.createFromResource(this, R.array.User, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user.setAdapter(adapter1);

            }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_Login:
                Intent intent =new Intent(getApplicationContext(),MainProductos.class);
                startActivity(intent);
                break;

            }

       }
    }




