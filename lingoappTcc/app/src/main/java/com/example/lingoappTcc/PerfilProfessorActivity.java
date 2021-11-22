package com.example.lingoappTcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilProfessorActivity extends AppCompatActivity {
    private Button btn_editar_dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_perfil_professor);

        btn_editar_dados = (Button) findViewById(R.id.btn_editar_dados);

        btn_editar_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_editar_dadosActivity();
            }
        });

    }

    private void btn_editar_dadosActivity() {
        startActivity(new Intent(this, AlterarDadosProfessorActivity.class));
    }
}
