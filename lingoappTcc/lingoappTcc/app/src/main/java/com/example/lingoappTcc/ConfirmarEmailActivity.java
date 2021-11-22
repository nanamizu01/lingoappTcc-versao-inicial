package com.example.lingoappTcc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarEmailActivity extends AppCompatActivity {

    private Button btn_enviar;
    private TextView text_reenviar_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_confirmar_email);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        text_reenviar_email = (TextView) findViewById(R.id.text_aqui);

        btn_enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder cadastro_concluido = new AlertDialog.Builder(ConfirmarEmailActivity.this);
                cadastro_concluido.setTitle("Usuário cadastrado com sucesso!");
                cadastro_concluido.setPositiveButton("Voltar à página de login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        voltar_pagina_inicial();
                    }
                });
                cadastro_concluido.create().show();
            }
        });

        text_reenviar_email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //text_reenviar_emailActivity();
                AlertDialog.Builder email_enviado = new AlertDialog.Builder(ConfirmarEmailActivity.this);
                email_enviado.setTitle("Um novo código foi enviado à sua caixa de mensagens");
                email_enviado.setCancelable(false);
                email_enviado.setPositiveButton("Ok",null);

                email_enviado.create().show();
            }
        });
    }

    private void voltar_pagina_inicial(){
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }

    private void text_reenviar_emailActivity() {

    }
}