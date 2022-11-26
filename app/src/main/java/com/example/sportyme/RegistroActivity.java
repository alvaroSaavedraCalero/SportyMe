package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import models.Almacen;
import models.Direccion;
import models.Pedido;
import models.User;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombreRegistro;
    private EditText userRegistro;
    private EditText apellidosRegistro;
    private EditText emailRegistro;
    private EditText passRegistro;
    private EditText passRepiteRegistro;
    private EditText calleRegistro;
    private EditText CPRegistro;
    private EditText localidadRegistro;
    private EditText comunidadRegistro;
    private Button btnRegistro;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        intent=getIntent();

        nombreRegistro=(EditText) findViewById(R.id.campoNombreRegistro);
        userRegistro=(EditText) findViewById(R.id.campoUsernameRegistro);
        apellidosRegistro=(EditText) findViewById(R.id.campoApellidosRegistro);
        emailRegistro=(EditText) findViewById(R.id.campoEmailRegistro);
        passRegistro=(EditText) findViewById(R.id.campoPasswordRegistro);
        passRepiteRegistro=(EditText) findViewById(R.id.campoRepeatPasswordRegistro);
        calleRegistro=(EditText) findViewById(R.id.campoCalleRegistro);
        CPRegistro=(EditText) findViewById(R.id.campoCPRegistro);
        localidadRegistro=(EditText) findViewById(R.id.campoPoblacionRegistro);
        comunidadRegistro=(EditText) findViewById(R.id.campoComunidadRegistro);
        btnRegistro=(Button) findViewById(R.id.botonRegistrarseRegistro);
        Bundle bundle=intent.getExtras();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(passRegistro.getText().toString().equals(passRepiteRegistro.getText().toString())){

                   crearUsuario();
                   Toast.makeText(getApplicationContext(), "Usuario creado correctamente", Toast.LENGTH_SHORT).show();

                   Intent nuevoIntent= new Intent(RegistroActivity.this,LoginActivity.class);
                   startActivity(nuevoIntent);


               }else{

                   Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();

               }

            }
        });


    }

    public void crearUsuario(){

        //Creamos el usuario. Para ello primero creamos la direccion

        Direccion direccionUsuario= new Direccion(calleRegistro.getText().toString(),CPRegistro.getText().toString(),
                comunidadRegistro.getText().toString(),localidadRegistro.getText().toString());

        User nuevoUser= new User(userRegistro.getText().toString(),passRegistro.getText().toString(),
                nombreRegistro.getText().toString(),apellidosRegistro.getText().toString(),
                emailRegistro.getText().toString(),direccionUsuario);


        //Agregamos el usuario a la base de datos

        Almacen.getAlmacenUsuarios().add(nuevoUser);

    }

}