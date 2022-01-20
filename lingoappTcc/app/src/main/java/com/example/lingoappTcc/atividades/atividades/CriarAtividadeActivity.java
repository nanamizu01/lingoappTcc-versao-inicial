package com.example.lingoappTcc.atividades.atividades;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;

public class CriarAtividadeActivity extends AppCompatActivity {

    private Button btn_enviar;
    private Button btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_criar_atividade);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tarefa_criada = new AlertDialog.Builder(CriarAtividadeActivity.this);
                tarefa_criada.setTitle("Atividade enviada com sucesso!");
                tarefa_criada.setPositiveButton("Voltar à questão um", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn_cancelarActivity();
                    }
                });
                tarefa_criada.create().show();
            }
        });
    }

    private void btn_cancelarActivity() {
    }
}
