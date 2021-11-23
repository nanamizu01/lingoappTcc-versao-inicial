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

public class ParticiparTurmaEstudanteActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_participar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_participar_turma_estudante);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_participar = (Button) findViewById(R.id.btn_participar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });
        btn_participar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_participarActivity();
            }
        });
    }
    private void btn_voltarActivity(){
        startActivity(new Intent(this, AbaTurmasEstudanteActivity.class));
    }
    private void btn_participarActivity(){
        AlertDialog.Builder participar_turma = new AlertDialog.Builder(ParticiparTurmaEstudanteActivity.this);
        participar_turma.setTitle("Você agora faz parte dessa turma!");
        participar_turma.setCancelable(false);
        participar_turma.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 btn_voltarActivity();
            }
        });
        participar_turma.create().show();
    }
}