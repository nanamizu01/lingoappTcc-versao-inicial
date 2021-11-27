package com.example.lingoappTcc.atividades.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.atividades.AbaAtividadesEstudanteActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasEstudanteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AbaPerfilEstudanteActivity extends AppCompatActivity {

    private Button btn_editar_dados;
    private Button btn_historico_atividades;
    private Button btn_conquistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aba_perfil_estudante);

        btn_editar_dados = (Button) findViewById(R.id.btn_editar_dados);
        btn_historico_atividades = (Button) findViewById(R.id.btn_historico_atividades);
        btn_conquistas = (Button) findViewById(R.id.btn_conquistas);

        btn_editar_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_editar_dadosActivity();
            }
        });

        btn_historico_atividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_historico_atividadesActivity();
            }
        });

        btn_conquistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_conquistasActivity();
            }
        });

        BottomNavigationView menu_inferior = findViewById(R.id.menu_inferior);
        menu_inferior.setSelectedItemId(R.id.nav_perfil);
        menu_inferior.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_turmas:
                        startActivity(new Intent(getApplicationContext()
                                , AbaTurmasEstudanteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_atividades:
                        startActivity(new Intent(getApplicationContext()
                                , AbaAtividadesEstudanteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_perfil:
                        return true;
                }
                return false;
            }
        });
    }

    private void btn_conquistasActivity() {
        startActivity(new Intent(this, ConquistasEstudanteActivity.class));
    }

    private void btn_historico_atividadesActivity() {
        startActivity(new Intent(this, HistoricoAtividadesEstudanteActivity.class));
    }

    private void btn_editar_dadosActivity() {
        startActivity(new Intent(this, AlterarDadosEstudanteActivity.class));
    }

}