package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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

    private ImageView foto;
    private TextView descripción;
    private Button disminuir;
    private Button aumentar;
    private TextView cantidad;
    private Spinner tallaje;
    private Button aniadirCarrito;
    private TextView precio;
    private Button volver;
    String idPicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_articulo);
        intent = getIntent();

        //--------------------ESTO ES LO QUE HE CAMBIADO----------------//

        Producto productoEnviado = (Producto) intent.getSerializableExtra("producto");

        idPicture = productoEnviado.getIdFoto();

        //-------------------------------------------------------------//

        User s = (User) intent.getSerializableExtra("usuario");

        almacen = (Almacen) intent.getSerializableExtra("almacen");

        Toast.makeText(getApplicationContext(), "Estas eligiendo el articulo " + idPicture, Toast.LENGTH_SHORT).show();

        foto = (ImageView) findViewById(R.id.imagenMostrarArticulo);
        descripción = (TextView) findViewById(R.id.descripcionMostrarArticulo);
        disminuir = (Button) findViewById(R.id.botonQuitarMostrarArticulo);
        aumentar = (Button) findViewById(R.id.botonAniadirMostrarArticulo);
        cantidad = (TextView) findViewById(R.id.cantidadMostrarArticulo);
        tallaje = (Spinner) findViewById(R.id.Tallaje);
        aniadirCarrito = (Button) findViewById(R.id.botonAniadirCarrito);
        precio = (TextView) findViewById(R.id.textoPrecio);
        volver=(Button) findViewById(R.id.volverMenu);


        productoActual = Almacen.recuperarProducto(idPicture);

        foto.setImageResource(devuelveDrawableFoto(idPicture));
        descripción.setText(productoActual.getDescripcion());

        productoActual.setTallaEscogida((String) tallaje.getSelectedItem());

        precio.setText(String.valueOf(productoActual.getPrecio()));

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

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenVolver= new Intent(MostrarArticuloActivity.this,PrincipalActivity.class);
                intenVolver.putExtra("usuario",s);
                startActivity(intenVolver);
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
                Pedido pedidoActual=new Pedido(s.getUsername());
                s.setPedidoActual(pedidoActual);
                Log.i("tamaño itemPedido",String.valueOf(s.getPedidoActual().getItemsPedido().size()));
                if(s.getPedidoActual().getItemsPedido().size()==0){


                    ItemPedido nuevoItem=new ItemPedido(productoActual,cantidadActual);
                    s.getPedidoActual().getItemsPedido().add(nuevoItem);

                    Log.i("añado a carrito vacio",s.getPedidoActual().getItemsPedido().get(0).getProductoPedido().getNombreProducto());
                    Log.i("tamaño itemPedido",String.valueOf(s.getPedidoActual().getItemsPedido().size()));
                }
                else{

                    if(s.getPedidoActual().getItemsPedido().contains(productoActual)){

                        productoActual.setCantidad(productoActual.getCantidad()+1);

                    }else{

                        ItemPedido nuevoItem=new ItemPedido(productoActual,cantidadActual);
                        s.getPedidoActual().getItemsPedido().add(nuevoItem);

                    }

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