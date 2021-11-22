package com.example.lingoappTcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilEstudanteActivity extends AppCompatActivity {

    private Button btn_editar_dados;
    private Button btn_historico_atividades;
    private Button btn_conquistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_perfil_estudante);

        btn_editar_dados = (Button) findViewById(R.id.btn_editar_dados);
        btn_historico_atividades = (Button) findViewById(R.id.btn_historico_atividades);
        btn_conquistas = (Button) findViewById(R.id.btn_conquistas);

        btn_editar_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_editar_dadosActivity();
            }
        });
        
        btn_historico_atividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_historico_atividadesActivity();
            }
        });

        btn_conquistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_conquistasActivity();
            }
        });
    }

    private void btn_conquistasActivity() {
        startActivity(new Intent(this, ConquistasEstudanteActivity.class));
    }

    private void btn_historico_atividadesActivity() {
        startActivity(new Intent(this,HistoricoAtividadesEstudanteActivity.class));
    }

    private void btn_editar_dadosActivity() {
        startActivity(new Intent(this, AlterarDadosEstudanteActivity.class));
    }
}
