package com.example.lingoappTcc.atividades.turmas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.perfil.AlterarDadosEstudanteActivity;

public class GerenciarTurmaActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_convidar_estudante, btn_editar_turma,
        btn_retirar_estudante, btn_excluir_turma;

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
        //pop up personalizada ou fragmento ?
    }
    private void btn_editar_turmaActivity() {
        //pop up personalizada ou fragmento ?
    }
    private void btn_retirar_estudanteActivity() {
        //pop up personalizada ou fragmento ?
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