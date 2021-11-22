package com.example.lingoappTcc.atividades.turmas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.atividades.AbaAtividadesEstudanteActivity;
import com.example.lingoappTcc.atividades.perfil.AbaPerfilEstudanteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AbaTurmasEstudanteActivity extends AppCompatActivity {

    private ImageButton btn_participar_turma;
    private Button btn_turma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aba_turmas_estudante);

        btn_participar_turma = (ImageButton) findViewById(R.id.btn_criar_turma);
        btn_turma = (Button) findViewById(R.id.btn_turma);

        btn_participar_turma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_participar_turmaActivity();
            }
        });

        btn_turma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_turmaActivity();
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
                                , AbaAtividadesEstudanteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_perfil:
                        startActivity(new Intent(getApplicationContext()
                                , AbaPerfilEstudanteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void btn_participar_turmaActivity() {
        startActivity(new Intent (this,ParticiparTurmaEstudanteActivity.class));
    }

    private void btn_turmaActivity() {
        startActivity(new Intent(this, TurmaSelecionadaActivity.class));
    }

}