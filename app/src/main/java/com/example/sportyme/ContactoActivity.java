package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactoActivity extends AppCompatActivity {

    // Atributos de la clase
    private Button botonAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Si hacemos click en el boton atras, nos lleva a la vista activity_principal
        botonAtras = (Button) findViewById(R.id.botonAtrasContacto);
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(i);
            }
        });
    }
}