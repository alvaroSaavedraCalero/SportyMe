package com.example.sportyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import models.Almacen;
import models.User;

// https://notepad.ltd/movilesmolamazo


public class LoginActivity extends AppCompatActivity {

    private Intent intent;

    private Button botonLogin;
    private Button botonRegistro;
    private EditText textoUser;
    private EditText textoPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botonLogin = findViewById(R.id.botonLogin);
        botonRegistro = findViewById(R.id.botonRegistroLogin);
        textoUser = findViewById(R.id.textoUsuarioLogin);
        textoPassword = findViewById(R.id.textoPasswordLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Almacen.comprobarCredencialesLogin(textoUser.getText().toString(),
                        textoPassword.getText().toString()) != null) {
                    User s = Almacen.comprobarCredencialesLogin(textoUser.getText().toString(),
                            textoPassword.getText().toString());
                    Toast.makeText(getApplicationContext(), "Las credenciales son correctas", Toast.LENGTH_SHORT).show();
                    intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                    intent.putExtra("usuario", s);
                }
            }
        });

    }
}