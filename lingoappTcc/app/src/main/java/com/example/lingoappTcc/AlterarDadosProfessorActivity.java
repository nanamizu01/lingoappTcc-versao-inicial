package com.example.lingoappTcc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlterarDadosProfessorActivity extends AppCompatActivity {
    private ImageButton btn_voltar;
    private Button btn_cancelar;
    private Button btn_salvar;
    private TextView text_excluirConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_alterardados_professor);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
        btn_salvar = (Button) findViewById(R.id.btn_salvar);
        text_excluirConta = (TextView) findViewById(R.id.text_excluir_conta);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_cancelarActivity();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_salvarActivity();
            }
        });

        text_excluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder confirmar_exclusao_conta = new AlertDialog.Builder(AlterarDadosProfessorActivity.this);
                confirmar_exclusao_conta.setTitle("TEM CERTEZA QUE DESEJA EXCLUIR SUA CONTA?");
                confirmar_exclusao_conta.setNegativeButton("Cancelar", null);
                confirmar_exclusao_conta.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder conta_excluida = new AlertDialog.Builder(AlterarDadosProfessorActivity.this);
                        conta_excluida.setTitle("CONTA EXCLUÍDA");
                        conta_excluida.setCancelable(false);
                        conta_excluida.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                voltar_pagina_inicial();
                            }
                        });

                        conta_excluida.create().show();
                    }
                });
                confirmar_exclusao_conta.setCancelable(false);
                confirmar_exclusao_conta.create().show();
            }
        });
    }

    private void voltar_pagina_inicial() {
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }

    private void text_excluirContaActivity() {

    }

    private void btn_salvarActivity() {
        startActivity(new Intent(this, PerfilEstudanteActivity.class));
    }

    private void btn_cancelarActivity() {
        startActivity(new Intent(this, PerfilEstudanteActivity.class));
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, PerfilEstudanteActivity.class));
    }
}
