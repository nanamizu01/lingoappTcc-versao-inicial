package com.example.lingoappTcc.atividades.atividades;

import androidx.appcompat.app.AppCompatActivity;

public class VizuTarefaProfActivity extends AppCompatActivity {
private ImageButton btn_voltar;
    private Button btn_atribuir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vizu_tarefa_prof);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_atribuir = (Button) findViewById(R.id.btn_atribuir);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_atribuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tarefa_concluida = new AlertDialog.Builder(VizuTarefaProfActivity.this);
                tarefa_concluida.setTitle("Atividade atribuida com sucesso!");
                tarefa_concluida.setPositiveButton("Voltar para as disponíveis", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn_voltarActivity();
                    }
                });
                tarefa_concluida.create().show();
            }
        });
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, PagTarefaAlunoActivity.class));
    }
}

