package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import models.Almacen;
import models.ItemPedido;
import models.Pedido;
import models.Producto;
import models.User;

public class MostrarArticuloActivity extends AppCompatActivity {

    private Intent intent;
    private Bundle bundle;
    private Almacen almacen;
    private Producto productoActual;
    private String idFoto;

    private ImageView foto;
    private TextView descripción;
    private Button disminuir;
    private Button aumentar;
    private TextView cantidad;
    private Spinner tallaje;
    private Button aniadirCarrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_articulo);

        intent = getIntent();
        idFoto = intent.getStringExtra("nombreFoto");
        User s = (User) intent.getSerializableExtra("usuario");

        almacen = (Almacen) intent.getSerializableExtra("almacen");

        Toast.makeText(getApplicationContext(), "Estas eligiendo el atriculo " + idFoto, Toast.LENGTH_SHORT).show();

        foto = (ImageView) findViewById(R.id.imagenMostrarArticulo);
        descripción = (TextView) findViewById(R.id.descripcionMostrarArticulo);
        disminuir = (Button) findViewById(R.id.botonQuitarMostrarArticulo);
        aumentar = (Button) findViewById(R.id.botonAniadirMostrarArticulo);
        cantidad = (TextView) findViewById(R.id.cantidadMostrarArticulo);
        tallaje = (Spinner) findViewById(R.id.Tallaje);
        aniadirCarrito = (Button) findViewById(R.id.botonAniadirCarrito);




        productoActual = Almacen.recuperarProducto(idFoto);

        foto.setImageResource(devuelveDrawableFoto(idFoto));
        descripción.setText(productoActual.getDescripcion());

        productoActual.setTallaEscogida((String) tallaje.getSelectedItem());




        disminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer cantidadActual = Integer.parseInt(cantidad.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    cantidad.setText(String.valueOf(cantidadActual));
                    productoActual.setCantidad(cantidadActual);
                }
            }
        });

        aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer cantidadActual = Integer.parseInt(cantidad.getText().toString());
                cantidadActual++;
                cantidad.setText(String.valueOf(cantidadActual));
                productoActual.setCantidad(cantidadActual);
            }
        });

        aniadirCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidadActual = Integer.parseInt(cantidad.getText().toString());

                if (Almacen.buscarPedido(idFoto) != null) {
                    ItemPedido item = new ItemPedido(Almacen.recuperarProducto(idFoto), cantidadActual);
                    Almacen.getAlmacenPedidos().get(idFoto).getItemsPedido().add(item);
                } else {
                    Pedido p = new Pedido();
                    ItemPedido item = new ItemPedido(Almacen.recuperarProducto(idFoto), cantidadActual);
                    p.getItemsPedido().add(item);
                    Almacen.getAlmacenPedidos().put(s.getUsername(), p);
                }

                Toast.makeText(getApplicationContext(), "Se han añadido " + cantidadActual + " items de este producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public static int devuelveDrawableFoto(String id) {
        switch (id) {
            case "camiseta1":
                return R.drawable.camiseta1;
            case "camiseta2":
                return R.drawable.camiseta2;
            case "camiseta3":
                return R.drawable.camiseta3;
            case "pantalon1":
                return R.drawable.pantalon1;
            case "pantalon2":
                return R.drawable.pantalon2;
            case "pantalon3":
                return R.drawable.pantalon3;
            case "sudadera1":
                return R.drawable.sudadera1;
            case "sudadera2":
                return R.drawable.sudadera2;
            case "sudadera3":
                return R.drawable.sudadera3;
            case "zapatillas1":
                return R.drawable.zapatillas1;
            case "zapatillas2":
                return R.drawable.zapatillas2;
            case "zapatillas3":
                return R.drawable.zapatillas3;
            default:
                return 0;
        }
    }

}