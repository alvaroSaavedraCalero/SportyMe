package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import models.Almacen;
import models.User;

// https://notepad.ltd/movilesmolamazo


public class LoginActivity extends AppCompatActivity {


    // atributos de la clase
    private Intent intent;

    private Button botonLogin;
    private Button botonRegistro;
    private EditText textoUser;
    private EditText textoPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Creamos un nuevo almacen
        Almacen almacen = new Almacen();

        botonLogin = findViewById(R.id.botonLogin);
        botonRegistro = findViewById(R.id.botonRegistroLogin);
        textoUser = findViewById(R.id.textoUsuarioLogin);
        textoPassword = findViewById(R.id.textoPasswordLogin);

        // Cuando pulsemos el boton Login, comprobara las credenciales y nos llevara a la vista principal
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // En caso de que las credenciales las encontremos, mandamos a la vista activity_principal
                if (Almacen.comprobarCredencialesLogin(textoUser.getText().toString(),
                        textoPassword.getText().toString()) != null) {
                    User s = Almacen.comprobarCredencialesLogin(textoUser.getText().toString(),
                            textoPassword.getText().toString());
                    Toast.makeText(getApplicationContext(), "Las credenciales son correctas", Toast.LENGTH_SHORT).show();
                    intent = new Intent(getApplicationContext(), PrincipalActivity.class);

                    intent.putExtra("usuario", s);
                    intent.putExtra("almacen", almacen);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                // En caso contrario, avisamos con un Toast
                } else {
                    Toast.makeText(getApplicationContext(), "Registrese si no lo ha hecho", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Al pulsar el boton Registro te redirige el registro para crear un nuevo usuario
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent= new Intent(LoginActivity.this,RegistroActivity.class);
                intent.putExtra("almacen", almacen);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });

        // Para que al pulsar fuera del teclado, este desaparezca
        ArrayList<EditText> textos=new ArrayList<>();
        textos.add(textoUser);
        textos.add(textoPassword);

        for(EditText t:textos){
            t.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    InputMethodManager im=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(view.getWindowToken(),0);
                }
            });

        }

    }
}