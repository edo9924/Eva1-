package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Comunicacion {
    private ProgressBar pgbEjecutar;
    private Button btnLogin;
    private TextView txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgbEjecutar = findViewById(R.id.pgbEjecutar);
        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Async( MainActivity.this).execute(txtEmail.getText().toString(),
                        txtPassword.getText().toString(), 3000);

            }
        });


    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status){
            pgbEjecutar.setVisibility(View.VISIBLE);
        }else{
            pgbEjecutar.setVisibility(View.GONE);
        }

    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}