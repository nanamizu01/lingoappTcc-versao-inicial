package com.example.lingoappTcc.atividades.turmas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.perfil.AlterarDadosEstudanteActivity;

public class GerenciarTurmaActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_convidar_estudante, btn_editar_turma,
        btn_retirar_estudante, btn_excluir_turma;
    private Dialog d_convidar_estudante, d_editar_turma,
            d_retirar_estudante, d_excluir_turma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_gerenciar_turma);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_convidar_estudante = (Button) findViewById(R.id.btn_convidar_estudante);
        btn_editar_turma = (Button) findViewById(R.id.btn_editar_turma);
        btn_retirar_estudante = (Button) findViewById(R.id.btn_retirar_estudante);
        btn_excluir_turma = (Button) findViewById(R.id.btn_excluir_turma);

        d_convidar_estudante = new Dialog(this);
        d_editar_turma = new Dialog(this);
        d_retirar_estudante = new Dialog(this);
        d_excluir_turma = new Dialog(this);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
            }
        });
        btn_convidar_estudante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_convidar_estudanteActivity();
            }
        });
        btn_editar_turma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_editar_turmaActivity();
            }
        });
        btn_retirar_estudante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_retirar_estudanteActivity();
            }
        });
        btn_excluir_turma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_excluir_turmaActivity();
            }
        });
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, TurmaSelecionadaPActivity.class));
    }
    private void btn_convidar_estudanteActivity() {
        d_convidar_estudante.setContentView(R.layout.dialog_convidar_estudante);
        d_convidar_estudante.setCancelable(false);

        ImageButton btn_fechar;
        EditText pt_email_input;
        Button btn_convidar;

        btn_fechar=(ImageButton) d_convidar_estudante.findViewById(R.id.btn_fechar);
        pt_email_input=(EditText) d_convidar_estudante.findViewById(R.id.plain_text_email_input);
        btn_convidar=(Button) d_convidar_estudante.findViewById(R.id.btn_convidar);

        btn_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d_convidar_estudante.dismiss();
            }
        });
        btn_convidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // é enviado um email de convite para a turma para o estudante
            }
        });
        d_convidar_estudante.show();
    }

    private void btn_editar_turmaActivity() {
        d_editar_turma.setContentView(R.layout.dialog_editar_turma);
        d_editar_turma.setCancelable(false);

        ImageButton btn_fechar;
        EditText pt_nome_turma_input, pt_senha_turma_input;
        Button btn_salvar;

        btn_fechar=(ImageButton) d_editar_turma.findViewById(R.id.btn_fechar);
        pt_nome_turma_input=(EditText) d_editar_turma.findViewById(R.id.plain_text_nome_turma_input);
        pt_senha_turma_input=(EditText) d_editar_turma.findViewById(R.id.plain_text_senha_input);
        btn_salvar=(Button) d_editar_turma.findViewById(R.id.btn_salvar);

        btn_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d_editar_turma.dismiss();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //salvar alterações
            }
        });
        d_editar_turma.show();
    }

    private void btn_retirar_estudanteActivity() {
        d_retirar_estudante.setContentView(R.layout.dialog_retirar_estudante);
        d_retirar_estudante.setCancelable(false);

        ImageButton btn_fechar;
        EditText pt_nome_estudante_input;
        Button btn_retirar;

        btn_fechar=(ImageButton) d_retirar_estudante.findViewById(R.id.btn_fechar);
        pt_nome_estudante_input=(EditText) d_retirar_estudante.findViewById(R.id.plain_text_nome_estudante_input);
        btn_retirar=(Button) d_retirar_estudante.findViewById(R.id.btn_retirar);

        btn_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d_retirar_estudante.dismiss();
            }
        });

        btn_retirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //retirar estudante da turma
            }
        });
        d_retirar_estudante.show();
    }

    private void btn_excluir_turmaActivity() {
        AlertDialog.Builder confirmar_exclusao_turma = new AlertDialog.Builder(GerenciarTurmaActivity.this);
        confirmar_exclusao_turma.setTitle("Tem certeza que deseja excluir essa turma?");
        confirmar_exclusao_turma.setCancelable(false);
        confirmar_exclusao_turma.setNegativeButton("Cancelar", null);
        confirmar_exclusao_turma.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder turma_excluida = new AlertDialog.Builder(GerenciarTurmaActivity.this);
                turma_excluida.setTitle("TURMA EXCLUÍDA");
                turma_excluida.setCancelable(false);
                turma_excluida.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        voltar_aba_turmas();
                    }

                });
                turma_excluida.create().show();
            }
        });
        confirmar_exclusao_turma.create().show();
    }

    private void voltar_aba_turmas(){
        startActivity(new Intent(this, AbaTurmasProfessorActivity.class));
    }
}