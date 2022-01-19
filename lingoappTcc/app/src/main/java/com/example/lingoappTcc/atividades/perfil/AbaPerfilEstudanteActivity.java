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
import com.example.lingoappTcc.atividades.cadastroelogin.PaginaInicialActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasEstudanteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AbaPerfilEstudanteActivity extends AppCompatActivity {

    private Button btn_editar_dados;
    private Button btn_historico_atividades;
    private Button btn_sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aba_perfil_estudante);

        btn_editar_dados = (Button) findViewById(R.id.btn_editar_dados);
        btn_historico_atividades = (Button) findViewById(R.id.btn_historico_atividades);
        btn_sair = (Button) findViewById(R.id.btn_sair);

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

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sairActivity();
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

    private void btn_sairActivity() {
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }

    private void btn_historico_atividadesActivity() {
        startActivity(new Intent(this, HistoricoAtividadesEstudanteActivity.class));
    }

    private void btn_editar_dadosActivity() {
        startActivity(new Intent(this, AlterarDadosEstudanteActivity.class));
    }

}