package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import models.User;

public class PrincipalActivity extends AppCompatActivity {

    private Intent intent;

    private ImageButton camiseta1;
    private ImageButton camiseta2;
    private ImageButton camiseta3;
    private ImageButton pantalon1;
    private ImageButton pantalon2;
    private ImageButton pantalon3;
    private ImageButton sudadera1;
    private ImageButton sudadera2;
    private ImageButton sudadera3;
    private ImageButton zapas1;
    private ImageButton zapas2;
    private ImageButton zapas3;

    private ArrayList<ImageButton>fotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        intent=getIntent();

        User s = (User) intent.getSerializableExtra("usuario");
        Toast.makeText(getApplicationContext(), "Estoy en la vista principal con el usuario" +
               s.getUsername() , Toast.LENGTH_SHORT).show();


        camiseta1=(ImageButton)findViewById(R.id.camiseta1);
        camiseta2=(ImageButton)findViewById(R.id.camiseta2);
        camiseta3=(ImageButton)findViewById(R.id.camiseta3);
        pantalon1=(ImageButton)findViewById(R.id.pantalon1);
        pantalon2=(ImageButton)findViewById(R.id.pantalon2);
        pantalon3=(ImageButton)findViewById(R.id.pantalon3);
        sudadera1=(ImageButton)findViewById(R.id.sudadera1);
        sudadera2=(ImageButton)findViewById(R.id.sudadera2);
        sudadera3=(ImageButton)findViewById(R.id.sudadera3);
        zapas1=(ImageButton)findViewById(R.id.zapas1);
        zapas2=(ImageButton)findViewById(R.id.zapas2);
        zapas3=(ImageButton)findViewById(R.id.zapas3);

        fotos.add(camiseta1);
        fotos.add(camiseta2);
        fotos.add(camiseta3);
        fotos.add(pantalon1);
        fotos.add(pantalon2);
        fotos.add(pantalon3);
        fotos.add(sudadera1);
        fotos.add(sudadera2);
        fotos.add(sudadera3);
        fotos.add(zapas1);
        fotos.add(zapas2);
        fotos.add(zapas3);


        for(ImageButton foto:fotos){
            foto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {




                }
            });
        }



    }
}