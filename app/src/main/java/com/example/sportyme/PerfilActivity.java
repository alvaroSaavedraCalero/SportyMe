package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import models.Almacen;
import models.User;

public class PerfilActivity extends AppCompatActivity {

    private Intent intent;
    private TextView nombreUsuario;
    private TextView apellidoUsuario;
    private TextView nickUsuario;
    private TextView mailUsuario;
    private Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        intent=getIntent();

        User s = (User) intent.getSerializableExtra("usuario");

        Toast.makeText(getApplicationContext(), "Estoy en el perfil con el usuario " +
                s.getUsername() , Toast.LENGTH_SHORT).show();

        Almacen almacen = (Almacen) intent.getSerializableExtra("almacen");

        nombreUsuario=findViewById(R.id.nameUsuario);
        apellidoUsuario=findViewById(R.id.apeUsuario);
        nickUsuario=findViewById(R.id.userUsuario);
        mailUsuario=findViewById(R.id.mailUsuario);

        nombreUsuario.setText(s.getNombre());
        apellidoUsuario.setText(s.getApellidos());
        nickUsuario.setText(s.getUsername());
        mailUsuario.setText(s.getCorreo());

        botonVolver=findViewById(R.id.btnVolver);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentNuevo=new Intent(PerfilActivity.this,PrincipalActivity.class);

                intentNuevo.putExtra("usuario",s);
                intentNuevo.putExtra("almacen",almacen);
                intentNuevo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentNuevo);



            }
        });






    }
}