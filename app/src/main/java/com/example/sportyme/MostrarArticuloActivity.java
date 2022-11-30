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

    // atributos de la clase
    private Intent intent;
    private Bundle bundle;
    private Almacen almacen;
    private Producto productoActual;

    private ImageView foto;
    private TextView descripcion;
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
        // Lo primero que hacemos es recuperar el producto, usuario y almacen del intent
        intent = getIntent();
        Producto productoEnviado = (Producto) intent.getSerializableExtra("producto");
        // recuperamos el id de la foto del producto
        idPicture = productoEnviado.getIdFoto();
        User s = (User) intent.getSerializableExtra("usuario");
        almacen = (Almacen) intent.getSerializableExtra("almacen");

        Toast.makeText(getApplicationContext(), "Estas eligiendo el articulo " + idPicture, Toast.LENGTH_SHORT).show();

        // seteamos las vistas de la vista a nuestras variables
        foto = (ImageView) findViewById(R.id.imagenMostrarArticulo);
        descripcion = (TextView) findViewById(R.id.descripcionMostrarArticulo);
        disminuir = (Button) findViewById(R.id.botonQuitarMostrarArticulo);
        aumentar = (Button) findViewById(R.id.botonAniadirMostrarArticulo);
        cantidad = (TextView) findViewById(R.id.cantidadMostrarArticulo);
        tallaje = (Spinner) findViewById(R.id.Tallaje);
        aniadirCarrito = (Button) findViewById(R.id.botonAniadirCarrito);
        precio = (TextView) findViewById(R.id.textoPrecio);
        volver = (Button) findViewById(R.id.volverMenu);

        // seteamos los valores corresponientes
        productoActual = Almacen.recuperarProducto(idPicture);

        foto.setImageResource(devuelveDrawableFoto(idPicture));
        descripcion.setText(productoActual.getDescripcion());

        productoActual.setTallaEscogida((String) tallaje.getSelectedItem());

        precio.setText(String.valueOf(productoActual.getPrecio()));

        // Cuando le damos al boton "-" decrementamos la cantidad hasta 0
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

        // Al hacer click en el boton volver, volvemos a la vista activity_princiapal
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenVolver = new Intent(MostrarArticuloActivity.this, PrincipalActivity.class);
                intenVolver.putExtra("usuario", s);
                startActivity(intenVolver);
            }
        });

        // Cuando le damos al boton "+", aumentamos la cantidad
        aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer cantidadActual = Integer.parseInt(cantidad.getText().toString());
                cantidadActual++;
                cantidad.setText(String.valueOf(cantidadActual));
                productoActual.setCantidad(cantidadActual);
            }
        });

        // Al hacer click en el boton añadir al carrito, añadimos el item al carrito
        aniadirCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenemos la cantidad de producto de la vista
                int cantidadActual = Integer.parseInt(cantidad.getText().toString());
                // En caso de que sea 0, no añadimos nada al carrito y avisamos
                if (cantidadActual == 0) {
                    Toast.makeText(MostrarArticuloActivity.this, "No se pueden añadir 0 productos al carrito",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // Generamos un pedido asociado al usuario
                    Pedido pedidoActual = new Pedido(s.getUsername());
                    s.setPedidoActual(pedidoActual);
                    Log.i("tamaño itemPedido", String.valueOf(Pedido.getItemsPedido().size()));
                    // En caso de que no haya ningun item en el pedido
                    if (Pedido.getItemsPedido().size() == 0) {
                        // Generamos un nuevo iten y comprobamos que no este en pedido
                        ItemPedido nuevoItem = new ItemPedido(productoActual, cantidadActual);
                        nuevoItem.getProductoPedido().setTallaEscogida(tallaje.getSelectedItem().toString());
                        if (Almacen.pedicoContieneItem(nuevoItem)) {
                            Toast.makeText(MostrarArticuloActivity.this, "No se puede añadir este producto por que ya existe",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Pedido.getItemsPedido().add(nuevoItem);
                            Log.i("añado a carrito vacio", Pedido.getItemsPedido().get(0).getProductoPedido().getNombreProducto());
                            Log.i("tamaño itemPedido", String.valueOf(Pedido.getItemsPedido().size()));
                            Toast.makeText(getApplicationContext(), "Se han añadido " + cantidadActual + " items de este producto al carrito",
                                    Toast.LENGTH_SHORT).show();
                        }
                    // En caso de que ya existan items en el pedido
                    } else {
                        // Comoprobamos si el item ya esta dentro del pedido
                        if (Pedido.getItemsPedido().contains(productoActual)) {
                            productoActual.setCantidad(productoActual.getCantidad() + 1);
                        // Si no lo continene, generamos un nuevo item y lo añadimos
                        } else {
                            ItemPedido nuevoItem = new ItemPedido(productoActual, cantidadActual);
                            if (Almacen.pedicoContieneItem(nuevoItem)) {
                                Toast.makeText(MostrarArticuloActivity.this, "No se puede añadir este producto por que ya existe",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                nuevoItem.getProductoPedido().setTallaEscogida(tallaje.getSelectedItem().toString());
                                Pedido.getItemsPedido().add(nuevoItem);
                                Toast.makeText(getApplicationContext(), "Se han añadido " + cantidadActual + " items de este producto al carrito",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
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