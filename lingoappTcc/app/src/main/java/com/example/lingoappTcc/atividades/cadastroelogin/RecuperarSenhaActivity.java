package com.example.lingoappTcc.atividades.cadastroelogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lingoappTcc.R;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_recuperar_senha);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_enviarActivity();
            }
        });
    }

    private void btn_enviarActivity() {
        AlertDialog.Builder email_enviado = new AlertDialog.Builder(RecuperarSenhaActivity.this);
        email_enviado.setTitle("Email de recuperação de senha enviado com sucesso");
        email_enviado.setCancelable(false);
        email_enviado.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                voltar_pagina_inicial();
            }
        });

        email_enviado.create().show();
    }

    private void voltar_pagina_inicial(){
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }
}