package com.example.lingoappTcc.atividades.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;

public class EnvioTarefaActivity extends AppCompatActivity {

    private Button btn_ver_pontuacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_envio_tarefa);

        btn_ver_pontuacao = (Button) findViewById(R.id.btn_enviar);

        btn_ver_pontuacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_ver_pontuacaoActivity();
            }
        });

    }
    private void btn_ver_pontuacaoActivity() {

    }
}
