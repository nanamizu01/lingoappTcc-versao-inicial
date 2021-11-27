package com.example.lingoappTcc.atividades.perfil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.atividades.AbaAtividadesEstudanteActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasEstudanteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HistoricoAtividadesEstudanteActivity extends AppCompatActivity {

    private ImageButton btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_historico_atividades_estudante);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
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
    private void btn_voltarActivity() {
        startActivity(new Intent(this, AbaPerfilEstudanteActivity.class));
    }

}
