package com.example.lingoappTcc.atividades.atividades;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.PagTarefaAluno2Activity;
import com.example.lingoappTcc.R;

public class PagTarefaAlunoActivity extends AppCompatActivity {

    private Button btn_proximo;
    private Button btn_enviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pag_tarefa_aluno);

        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_proximoActivity();
            }
        });
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tarefa_concluida = new AlertDialog.Builder(PagTarefaAlunoActivity.this);
                tarefa_concluida.setTitle("Atividade enviada com sucesso!");
                tarefa_concluida.setPositiveButton("Voltar à questão um", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn_proximoActivity();
                    }
                });
                tarefa_concluida.create().show();
            }
        });

    }

    private void btn_proximoActivity() {
        startActivity(new Intent(this, PagTarefaAluno2Activity.class));

    }

    private void btn_enviarActivity() {
        startActivity(new Intent(this, EnvioTarefaActivity.class));
    }
}
