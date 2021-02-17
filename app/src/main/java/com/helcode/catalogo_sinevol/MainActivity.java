package com.helcode.catalogo_sinevol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
EditText user,pass;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.textUser);
        pass=findViewById(R.id.textpass);
        login=findViewById(R.id.btn_Login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}