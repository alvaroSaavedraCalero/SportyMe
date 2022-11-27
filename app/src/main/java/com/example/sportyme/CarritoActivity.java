package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import models.Almacen;
import models.ItemPedido;
import models.Pedido;
import models.User;

public class CarritoActivity extends AppCompatActivity {

    private Pedido p;
    private Intent intent;

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        scrollView = (ScrollView) findViewById(R.id.scrollView2);
        intent = getIntent();

        User s = (User) intent.getSerializableExtra("usuario");

        Log.i("valor de usuario en carrito", s.getUsername());

        p = Almacen.buscarPedido(s.getUsername());

        for (ItemPedido i : p.getItemsPedido()) {
            LinearLayout fila = new LinearLayout(scrollView.getContext());
            fila.setOrientation(LinearLayout.HORIZONTAL);

            ImageView imagen = new ImageView(fila.getContext());
            imagen.setImageResource(MostrarArticuloActivity.devuelveDrawableFoto(i.getProductoPedido().getIdFoto()));

            TextView nombre = new TextView(fila.getContext());
            nombre.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
            nombre.setText(i.getProductoPedido().getNombreProducto());

            TextView cantidad = new TextView(fila.getContext());
            cantidad.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
            String a = "x" + String.valueOf(i.getCantidadPedido());
            cantidad.setText(a);

            fila.addView(imagen);
            fila.addView(nombre);
            fila.addView(cantidad);

            scrollView.addView(fila);

        }



    }
}