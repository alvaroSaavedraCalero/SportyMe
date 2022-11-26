package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import models.Almacen;
import models.User;

public class PrincipalActivity extends AppCompatActivity {

    private Intent intent;

    private ImageButton camiseta01;
    private ImageButton camiseta02;
    private ImageButton camiseta03;
    private ImageButton pantalon01;
    private ImageButton pantalon02;
    private ImageButton pantalon03;
    private ImageButton sudadera01;
    private ImageButton sudadera02;
    private ImageButton sudadera03;
    private ImageButton zapas01;
    private ImageButton zapas02;
    private ImageButton zapas03;

    private ArrayList<ImageButton>fotos=new ArrayList<ImageButton>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        intent=getIntent();

        User s = (User) intent.getSerializableExtra("usuario");
        Toast.makeText(getApplicationContext(), "Estoy en la vista principal con el usuario" +
               s.getUsername() , Toast.LENGTH_SHORT).show();
        Almacen almacen = (Almacen) intent.getSerializableExtra("almacen");

        camiseta01=(ImageButton)findViewById(R.id.camiseta1);
        camiseta02=(ImageButton)findViewById(R.id.camiseta2);
        camiseta03=(ImageButton)findViewById(R.id.camiseta3);
        pantalon01=(ImageButton)findViewById(R.id.pantalon1);
        pantalon02=(ImageButton)findViewById(R.id.pantalon2);
        pantalon03=(ImageButton)findViewById(R.id.pantalon3);
        sudadera01=(ImageButton)findViewById(R.id.sudadera1);
        sudadera02=(ImageButton)findViewById(R.id.sudadera2);
        sudadera03=(ImageButton)findViewById(R.id.sudadera3);
        zapas01=(ImageButton)findViewById(R.id.zapatillas1);
        zapas02=(ImageButton)findViewById(R.id.zapatillas2);
        zapas03=(ImageButton)findViewById(R.id.zapatillas3);

        fotos.add(camiseta01);
        fotos.add(camiseta02);
        fotos.add(camiseta03);
        fotos.add(pantalon01);
        fotos.add(pantalon02);
        fotos.add(pantalon03);
        fotos.add(sudadera01);
        fotos.add(sudadera02);
        fotos.add(sudadera03);
        fotos.add(zapas01);
        fotos.add(zapas02);
        fotos.add(zapas03);


       for(ImageButton foto:fotos){
            foto.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String idFoto=foto.getContentDescription().toString();

                    Intent descripFoto=new Intent(PrincipalActivity.this,MostrarArticuloActivity.class);
                    intent.putExtra("nombrefoto",idFoto);
                    intent.putExtra("almacen", almacen);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(descripFoto);

                }
            });
        }



    }
}