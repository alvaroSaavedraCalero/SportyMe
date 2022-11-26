package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MostrarArticuloActivity extends AppCompatActivity {

    private Intent intent;

    private ImageView foto;
    private TextView descripción;
    private Button disminuir;
    private Button aumentar;
    private TextView cantidad;
    private Spinner tallaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_articulo);

        intent = getIntent();






    }
}