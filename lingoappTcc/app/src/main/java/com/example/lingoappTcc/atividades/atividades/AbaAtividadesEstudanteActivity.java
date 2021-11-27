package com.example.lingoappTcc.atividades.atividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lingoappTcc.fragmentos.AtividadesDisponiveisEstudanteFragment;
import com.example.lingoappTcc.R;
import com.example.lingoappTcc.VPAdapter;
import com.example.lingoappTcc.atividades.perfil.AbaPerfilEstudanteActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasEstudanteActivity;
import com.example.lingoappTcc.fragmentos.AtividadesPendentesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class AbaAtividadesEstudanteActivity extends AppCompatActivity {

    private TabLayout tab_aba_atividades_estudante;
    private ViewPager vp_aba_atividades_estudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aba_atividades_estudante);

        tab_aba_atividades_estudante = findViewById(R.id.tab_aba_atividades_estudante);
        vp_aba_atividades_estudante = findViewById(R.id.vp_aba_atividades_estudante);

        tab_aba_atividades_estudante.setupWithViewPager(vp_aba_atividades_estudante);

        VPAdapter vpAAbaAtividadesE = new VPAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAAbaAtividadesE.adicionarFragmento(new AtividadesPendentesFragment(),"Pendentes");
        vpAAbaAtividadesE.adicionarFragmento(new AtividadesDisponiveisEstudanteFragment(),"Disponíveis");
        vp_aba_atividades_estudante.setAdapter(vpAAbaAtividadesE);

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