package com.example.lingoappTcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PaginaCadastroActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_sou_estudante, btn_sou_professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pagina_cadastro);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_sou_estudante = (Button) findViewById(R.id.btn_sou_estudante);
        btn_sou_professor = (Button) findViewById(R.id.btn_sou_professor);

        btn_voltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_sou_estudante.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_sou_estudanteActivity();
            }
        });

        btn_sou_professor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_sou_professorActivity();
            }
        });
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, PaginaInicialActivity.class));
        finish();
    }

    private void btn_sou_estudanteActivity() {
        startActivity(new Intent(this, CadastroEstudante1Activity.class));
    }

    private void btn_sou_professorActivity() {
        startActivity(new Intent(this, CadastroProfessor1Activity.class));
    }
}
