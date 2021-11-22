package com.example.lingoappTcc.atividades.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.perfil.AbaPerfilEstudanteActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasEstudanteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AbaAtividadesEstudanteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aba_atividades_estudante);

        BottomNavigationView menu_inferior = findViewById(R.id.menu_inferior);
        menu_inferior.setSelectedItemId(R.id.nav_atividades);
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

}