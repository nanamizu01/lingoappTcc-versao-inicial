package com.example.lingoappTcc.atividades.turmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.VPAdapter;
import com.example.lingoappTcc.fragmentos.AtividadesCorrigidasFragment;
import com.example.lingoappTcc.fragmentos.AtividadesPendentesFragment;
import com.google.android.material.tabs.TabLayout;

public class AtividadesTurmaSelecionadaActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private TabLayout tab_atividade_selecionada;
    private ViewPager vp_atividade_selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_atividades_turma_selecionada);

        btn_voltar = findViewById(R.id.btn_voltar);
        tab_atividade_selecionada = findViewById(R.id.tab_atividade_selecionada);
        vp_atividade_selecionada = findViewById(R.id.vp_atividade_selecionada);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
            }
        });

        tab_atividade_selecionada.setupWithViewPager(vp_atividade_selecionada);

        /*VPAdapter vpAAtividadeSelecionada = new VPAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAAtividadeSelecionada.adicionarFragmento(new AtividadesPendentesFragment(),"Atividades");
        vpAAtividadeSelecionada.adicionarFragmento(new AtividadesCorrigidasFragment(),"Participantes");
        vp_atividade_selecionada.setAdapter(vpAAtividadeSelecionada);*/

    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, TurmaSelecionadaPActivity.class));
    }
}