package com.example.lingoappTcc.atividades.atividades;

import androidx.appcompat.app.AppCompatActivity;

public class PagTarefaAlunoActivity extends AppCompatActivity {
 private Button btn_proximo;
    private Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_tarefa_aluno);

        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);

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
}

