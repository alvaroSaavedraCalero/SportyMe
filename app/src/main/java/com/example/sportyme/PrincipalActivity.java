package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import models.Almacen;
import models.Pedido;
import models.Producto;
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
    private String idFoto;
    private ImageButton resetClick;

    private Button botonCompra;


    private ArrayList<ImageButton>fotos=new ArrayList<ImageButton>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        intent=getIntent();

        User s = (User) intent.getSerializableExtra("usuario");

        Toast.makeText(getApplicationContext(), "Estoy en la vista principal con el usuario " +
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
        resetClick=(ImageButton)findViewById(R.id.imageView);

        botonCompra = (Button) findViewById(R.id.botonRealizarCompra);

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

        resetClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                camiseta01.setImageResource(R.drawable.camiseta1);
                camiseta02.setImageResource(R.drawable.camiseta2);
                camiseta03.setImageResource(R.drawable.camiseta3);
                camiseta01.setContentDescription("camiseta1");
                camiseta02.setContentDescription("camiseta2");
                camiseta03.setContentDescription("camiseta3");
                pantalon01.setVisibility(View.VISIBLE);
                pantalon02.setVisibility(View.VISIBLE);
                pantalon03.setVisibility(View.VISIBLE);
                sudadera01.setVisibility(View.VISIBLE);
                sudadera02.setVisibility(View.VISIBLE);
                sudadera03.setVisibility(View.VISIBLE);
                zapas01.setVisibility(View.VISIBLE);
                zapas02.setVisibility(View.VISIBLE);
                zapas03.setVisibility(View.VISIBLE);

            }
        });

       for(ImageButton foto:fotos){
            foto.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    idFoto=foto.getContentDescription().toString();

                    //-------ESTO ES LO QUE HE METIDO NUEVO----------//

                    Producto productoPinchado=new Producto(idFoto);

                    Intent descripFoto=new Intent(PrincipalActivity.this,MostrarArticuloActivity.class);
                    descripFoto.putExtra("producto",productoPinchado);
                    descripFoto.putExtra("almacen", almacen);
                    descripFoto.putExtra("usuario", s);
                    descripFoto.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    Log.i("pillo el id",idFoto);

                    startActivity(descripFoto);

                    //----------------------------------------------//
                }
            });
        }

        botonCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername(s.getUsername());
                intent = new Intent(getApplicationContext(), CarritoActivity.class);
                intent.putExtra("usuario", user);
                intent.putExtra("almacen",almacen);
                Log.i("vista principal valor usuario", user.getUsername());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    // Añadimos el menu a la vista
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_vista_principal, menu);
        return true;
    }

    // Lo que vamos a hacer con cada opcion
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.FiltradoXCamisetas:

                filtrarporCamisetas();

                return true;

            case R.id.FiltradoXPantalones:

                filtrarporPantalones();

                return true;

            case R.id.FiltradoXSudaderas:

                filtrarporSudaderas();

                return true;

            case R.id.FiltradoXZapatillas:

                filtrarporZapatillas();

                return true;

            case R.id.Perfil:

                User s = (User) intent.getSerializableExtra("usuario");
                Intent nuevoIntent= new Intent(PrincipalActivity.this,PerfilActivity.class);
                nuevoIntent.putExtra("usuario",s);
                startActivity(nuevoIntent);
                return true;

            case R.id.Contacto:
                intent.setClass(PrincipalActivity.this, ContactoActivity.class);
                startActivity(intent);
                return true;

            case R.id.logOut:
                // nos vamos a la vista login y eliminamos del intent los datos
                intent.removeExtra("usuario");
                intent.setClass(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            default:
                Toast.makeText(getApplicationContext(), "No se ha podido realizar el filtrado", Toast.LENGTH_SHORT).show();
                return false;
        }
    }

    public void filtrarporCamisetas(){

        camiseta01.setImageResource(R.drawable.camiseta1);
        camiseta02.setImageResource(R.drawable.camiseta2);
        camiseta03.setImageResource(R.drawable.camiseta3);
        camiseta01.setContentDescription("camiseta1");
        camiseta02.setContentDescription("camiseta2");
        camiseta03.setContentDescription("camiseta3");
        pantalon01.setVisibility(View.INVISIBLE);
        pantalon02.setVisibility(View.INVISIBLE);
        pantalon03.setVisibility(View.INVISIBLE);
        sudadera01.setVisibility(View.INVISIBLE);
        sudadera02.setVisibility(View.INVISIBLE);
        sudadera03.setVisibility(View.INVISIBLE);
        zapas01.setVisibility(View.INVISIBLE);
        zapas02.setVisibility(View.INVISIBLE);
        zapas03.setVisibility(View.INVISIBLE);


    }

    public void filtrarporPantalones(){

        camiseta01.setImageResource(R.drawable.pantalon1);
        camiseta02.setImageResource(R.drawable.pantalon2);
        camiseta03.setImageResource(R.drawable.pantalon3);
        camiseta01.setContentDescription("pantalon1");
        camiseta02.setContentDescription("pantalon2");
        camiseta03.setContentDescription("pantalon3");
        pantalon01.setVisibility(View.INVISIBLE);
        pantalon02.setVisibility(View.INVISIBLE);
        pantalon03.setVisibility(View.INVISIBLE);
        sudadera01.setVisibility(View.INVISIBLE);
        sudadera02.setVisibility(View.INVISIBLE);
        sudadera03.setVisibility(View.INVISIBLE);
        zapas01.setVisibility(View.INVISIBLE);
        zapas02.setVisibility(View.INVISIBLE);
        zapas03.setVisibility(View.INVISIBLE);



    }

    public void filtrarporSudaderas(){

        camiseta01.setImageResource(R.drawable.sudadera1);
        camiseta02.setImageResource(R.drawable.sudadera2);
        camiseta03.setImageResource(R.drawable.sudadera3);
        camiseta01.setContentDescription("sudadera1");
        camiseta02.setContentDescription("sudadera2");
        camiseta03.setContentDescription("sudadera3");
        pantalon01.setVisibility(View.INVISIBLE);
        pantalon02.setVisibility(View.INVISIBLE);
        pantalon03.setVisibility(View.INVISIBLE);
        sudadera01.setVisibility(View.INVISIBLE);
        sudadera02.setVisibility(View.INVISIBLE);
        sudadera03.setVisibility(View.INVISIBLE);
        zapas01.setVisibility(View.INVISIBLE);
        zapas02.setVisibility(View.INVISIBLE);
        zapas03.setVisibility(View.INVISIBLE);


    }

    public void filtrarporZapatillas(){

        camiseta01.setImageResource(R.drawable.zapatillas1);
        camiseta02.setImageResource(R.drawable.zapatillas2);
        camiseta03.setImageResource(R.drawable.zapatillas3);
        camiseta01.setContentDescription("zapatillas1");
        camiseta02.setContentDescription("zapatillas2");
        camiseta03.setContentDescription("zapatillas3");
        pantalon01.setVisibility(View.INVISIBLE);
        pantalon02.setVisibility(View.INVISIBLE);
        pantalon03.setVisibility(View.INVISIBLE);
        sudadera01.setVisibility(View.INVISIBLE);
        sudadera02.setVisibility(View.INVISIBLE);
        sudadera03.setVisibility(View.INVISIBLE);
        zapas01.setVisibility(View.INVISIBLE);
        zapas02.setVisibility(View.INVISIBLE);
        zapas03.setVisibility(View.INVISIBLE);


    }



}