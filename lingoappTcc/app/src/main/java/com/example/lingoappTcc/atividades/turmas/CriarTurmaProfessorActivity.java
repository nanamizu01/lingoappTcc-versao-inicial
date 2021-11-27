package com.example.lingoappTcc.atividades.turmas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;

public class CriarTurmaProfessorActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_criar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_criar_turma_professor);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_criar = (Button) findViewById(R.id.btn_criar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });
        btn_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_criarActivity();
            }
        });
    }
    private void btn_voltarActivity(){
        startActivity(new Intent(this, AbaTurmasProfessorActivity.class));
    }
    private void btn_criarActivity(){
        AlertDialog.Builder criar_turma = new AlertDialog.Builder(CriarTurmaProfessorActivity.this);
        criar_turma.setTitle("Turma criada com sucesso");
        criar_turma.setCancelable(false);
        criar_turma.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                btn_voltarActivity();
            }
        });
        criar_turma.create().show();
    }
}