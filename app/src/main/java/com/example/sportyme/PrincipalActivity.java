package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import models.User;

public class PrincipalActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        intent=getIntent();

        User s = (User) intent.getSerializableExtra("usuario");
        Toast.makeText(getApplicationContext(), "Estoy en la vista principal con el usuario" +
               s.getUsername() , Toast.LENGTH_SHORT).show();

    }
}