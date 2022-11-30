package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import models.Almacen;
import models.ItemPedido;
import models.Pedido;
import models.User;

public class CarritoActivity extends AppCompatActivity {

    // atributos de clase
    private Pedido p;
    private Intent intent;

    // atributos de clase de la vista activity_carrito
    private TableLayout tabla;
    private Button botonRealizarCompra;
    private TextView subtotal;
    private TextView gastosEnvio;
    private TextView total;
    private Button botonAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        // Obtenemos el usuario y el almacen del intent
        intent = getIntent();
        User s = (User) intent.getSerializableExtra("usuario");
        Almacen almacen=(Almacen)intent.getSerializableExtra("almacen");

        // seteamos las respectivas vistas a los atributos de clase
        botonAtras=(Button)findViewById(R.id.btnSeguir);

        tabla = (TableLayout) findViewById(R.id.TableLayout);
        botonRealizarCompra = (Button) findViewById(R.id.botonRealizarCompraCarrito);

        subtotal = (TextView) findViewById(R.id.textoSubtotal);
        String textoSubtotal = String.valueOf(Almacen.buscarPedido(s.getUsername()).getSubtotal());
        subtotal.setText(textoSubtotal);

        gastosEnvio = (TextView) findViewById(R.id.textoGastosEnvio);
        String textoGE = String.valueOf(Almacen.buscarPedido(s.getUsername()).getGastosDeEnvio());
        gastosEnvio.setText(textoGE);

        total = (TextView) findViewById(R.id.textoTotal);
        String textoTotal = String.valueOf(Almacen.buscarPedido(s.getUsername()).getTotal());
        total.setText(textoTotal);

        // Obtenemos el pedido del almacen
        p = Almacen.buscarPedido(s.getUsername());



        // Para cada item que nos encontremos
        for (ItemPedido i : Pedido.getItemsPedido()) {
            // Añadimos una fila
            TableRow fila = new TableRow(tabla.getContext());
            fila.setOrientation(LinearLayout.HORIZONTAL);

            // Añadimos la imagen
            ImageView imagen = new ImageView(fila.getContext());
            imagen.setImageResource(MostrarArticuloActivity.devuelveDrawableFoto(i.getProductoPedido().getIdFoto()));

            // Añadimos el nombre del item
            TextView nombre = new TextView(fila.getContext());
            nombre.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
            nombre.setPadding(10, 0, 10, 0);
            nombre.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
            nombre.setText(i.getProductoPedido().getNombreProducto());

            // Añadimos la talla del item
            TextView talla = new TextView(fila.getContext());
            talla.setGravity(TextView.TEXT_ALIGNMENT_GRAVITY);
            talla.setPadding(10, 0, 10, 0);
            talla.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
            String tallaString = "Talla " + i.getProductoPedido().getTallaEscogida();
            talla.setText(tallaString);

            // Añadimos la cantidad
            TextView cantidad = new TextView(fila.getContext());
            cantidad.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
            cantidad.setPadding(10, 0, 10, 0);
            cantidad.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.teal_700));
            String a = "x" + String.valueOf(i.getCantidadPedido());
            cantidad.setText(a);

            // Todas estas vista las añadimos a la fila
            fila.addView(imagen);
            fila.addView(nombre);
            fila.addView(talla);
            fila.addView(cantidad);

            // Y la fila la añadimos al TableLayout
            tabla.addView(fila);

        }

        // Cuando hagamos click en el boton de realizar compra, nos dirigimos a la vista activity_final_compra
        botonRealizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent finCompra=new Intent(CarritoActivity.this,FinalCompra.class);
                finCompra.putExtra("usuario",s);
                finCompra.putExtra("almacen",almacen);
                startActivity(finCompra);
            }
        });

        // Si hacemos click en el boton atras, volveremos a la vista activity_principal
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volverComprar=new Intent(CarritoActivity.this,PrincipalActivity.class);
                volverComprar.putExtra("usuario",s);
                volverComprar.putExtra("almacen",almacen);
                startActivity(volverComprar);

            }
        });

    }
}