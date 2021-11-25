package com.example.lingoappTcc.atividades.atividades;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.perfil.AbaPerfilProfessorActivity;
import com.example.lingoappTcc.atividades.turmas.CriarTurmaProfessorActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AtividadesProfessorActivity extends AppCompatActivity {
    private ImageButton btn_criar;
    private ImageButton btn_cancelar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aba_atividades_professor);

        btn_criar = (ImageButton) findViewById(R.id.btn_criar_turma);


        btn_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_criarActivity();
            }
        });
        BottomNavigationView menu_inferior = findViewById(R.id.menu_inferior);
        menu_inferior.setSelectedItemId(R.id.nav_turmas);
        menu_inferior.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_turmas:
                        return true;
                    case R.id.nav_atividades:
                        startActivity(new Intent(getApplicationContext()
                                , AbaAtividadesProfessorActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_perfil:
                        startActivity(new Intent(getApplicationContext()
                                , AbaPerfilProfessorActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void btn_criarActivity(){
        AlertDialog.Builder criar_turma = new AlertDialog.Builder(AtividadesProfessorActivity.this);
        criar_turma.setTitle("Turma criada com sucesso");
        criar_turma.setCancelable(false);
        criar_turma.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                btn_cancelarActivity();
            }
        });
        criar_turma.create().show();
    }

    private void btn_cancelarActivity() {
    }
}



