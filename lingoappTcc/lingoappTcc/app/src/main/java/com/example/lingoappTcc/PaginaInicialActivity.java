package com.example.lingoappTcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaginaInicialActivity extends AppCompatActivity {

    private Button btn_login_estudante, btn_login_professor;
    private TextView text_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pagina_inicial);

        btn_login_estudante = (Button) findViewById(R.id.btn_login_estudante);
        btn_login_professor = (Button) findViewById(R.id.btn_login_professor);
        text_cadastrar = (TextView) findViewById(R.id.text_cadastrar);

        btn_login_estudante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login_estudanteActivity();
            }
        });

        btn_login_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_login_professorActivity();
            }
        });

        text_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_cadastrarActivity();
            }
        });
    }

    private void btn_login_estudanteActivity() {
        startActivity(new Intent(this, LoginEstudanteActivity.class));
    }

    private void btn_login_professorActivity() {
        startActivity(new Intent(this, LoginProfessorActivity.class));
    }

    private void text_cadastrarActivity() {
        startActivity(new Intent(this, PaginaCadastroActivity.class));
    }
}