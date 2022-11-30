package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import models.Almacen;
import models.Pedido;
import models.User;

public class FinalCompra extends AppCompatActivity {

    private Button btnComprar;
    private TextView textoaMostrar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_compra);

        intent = getIntent();

        User s=(User)intent.getSerializableExtra("usuario");
        Almacen almacen=(Almacen)intent.getSerializableExtra("almacen");

        textoaMostrar=(TextView) findViewById(R.id.textoAMostrar);
        btnComprar=(Button) findViewById(R.id.btnNueva);

        textoaMostrar.setText("Muchas Gracias por realizar su compra "+s.getUsername());


        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                models.Pedido.getItemsPedido().clear();

                Intent volverAComprar= new Intent(FinalCompra.this,PrincipalActivity.class);
                volverAComprar.putExtra("usuario",s);
                volverAComprar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(volverAComprar);

            }
        });



    }
}