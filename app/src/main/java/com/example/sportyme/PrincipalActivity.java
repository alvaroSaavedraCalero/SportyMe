package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import models.User;

public class PrincipalActivity extends AppCompatActivity {

    private Intent intent;
    private User usuarioConectado;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Obtenemos el usuario que se ha conectado
        intent = getIntent();
        usuarioConectado = (User) intent.getSerializableExtra("usuario");
        Toast.makeText(getApplicationContext(), "Estoy en la vista principal con el usuario " +
                usuarioConectado.getUsername(), Toast.LENGTH_SHORT).show();
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
                // llamamos a una funcion para mostar solamente las camisetas
                mostrarPorFiltrado("Camisetas");
                return true;

            case R.id.FiltradoXPantalones:
                // llamamos a una funcion para mostrar solamente los pantalones
                mostrarPorFiltrado("Pantalones");
                return true;

            case R.id.FiltradoXSudaderas:
                // llamamos a una funcion para mostrar solamente las sudaderas
                mostrarPorFiltrado("Sudaderas");
                return true;

            case R.id.FiltradoXZapatillas:
                // llamamos a una funcion para mostrar solamente las zapatillas
                mostrarPorFiltrado("Zapatillas");
                return true;

            case R.id.Perfil:
                // nos vamos a la vista del perfil
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


    public void mostrarPorFiltrado(String filtrado) {

        tabla = findViewById(R.id.tableLayoutPrincipal);
        TableRow filaCamisetas = findViewById(R.id.fila1Camisetas);
        TableRow filaPantalones = findViewById(R.id.fila2Pantalones);
        TableRow filaSudaderas = findViewById(R.id.fila3Sudaderas);
        TableRow filaZapatillas = findViewById(R.id.fila4Zapatillas);

        TableRow[] arrayFilas = {filaCamisetas, filaPantalones, filaSudaderas, filaZapatillas};

        switch (filtrado) {
            case "Camisetas":
                if (tabla.getChildCount() <= 1) {
                    for (TableRow t : arrayFilas) {
                        tabla.addView(t);
                    }
                }
                filaPantalones.removeAllViewsInLayout();
                filaSudaderas.removeAllViewsInLayout();
                filaZapatillas.removeAllViewsInLayout();

                break;

            case "Pantalones":
                if (tabla.getChildCount() <= 1) {
                    for (TableRow t : arrayFilas) {
                        tabla.addView(t);
                    }

                }
                filaCamisetas.removeAllViewsInLayout();
                filaSudaderas.removeAllViewsInLayout();
                filaZapatillas.removeAllViewsInLayout();

                break;

            case "Sudaderas":
                if (tabla.getChildCount() <= 1) {
                    for (TableRow t : arrayFilas) {
                        tabla.addView(t);
                    }
                }
                filaPantalones.removeAllViewsInLayout();
                filaCamisetas.removeAllViewsInLayout();
                filaZapatillas.removeAllViewsInLayout();

                break;

            case "Zapatillas":
                if (tabla.getChildCount() <= 1) {
                    for (TableRow t : arrayFilas) {
                        tabla.addView(t);
                    }
                }
                filaCamisetas.removeAllViewsInLayout();
                filaSudaderas.removeAllViewsInLayout();
                filaPantalones.removeAllViewsInLayout();

                break;
        }


    }
}