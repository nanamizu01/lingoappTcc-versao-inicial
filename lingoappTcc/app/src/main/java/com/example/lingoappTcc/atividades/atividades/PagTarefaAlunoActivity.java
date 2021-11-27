package com.example.lingoappTcc.atividades.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;

public class PagTarefaAlunoActivity extends AppCompatActivity {

    private Button btn_enviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pag_tarefa_aluno);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_enviarActivity();
            }
        });

    }
    private void btn_enviarActivity() {
        startActivity(new Intent(this, EnvioTarefaActivity.class));
    }
}
