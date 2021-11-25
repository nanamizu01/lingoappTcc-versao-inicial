package com.example.lingoappTcc.atividades.turmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.TurmaAtividadesFragment;
import com.example.lingoappTcc.TurmaParticipantesFragment;
import com.example.lingoappTcc.VPAdapter;
import com.google.android.material.tabs.TabLayout;

public class TurmaSelecionadaActivity extends AppCompatActivity {

    private TabLayout tab_turma_selecionada;
    private ViewPager vp_turma_selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_turma_selecionada);

        tab_turma_selecionada = findViewById(R.id.tab_turma_selecionada);
        vp_turma_selecionada = findViewById(R.id.vp_turma_selecionada);

        tab_turma_selecionada.setupWithViewPager(vp_turma_selecionada);

        VPAdapter vpAturmaselecionada = new VPAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAturmaselecionada.adicionarFragmento(new TurmaAtividadesFragment(),"Atividades");
        vpAturmaselecionada.adicionarFragmento(new TurmaParticipantesFragment(),"Participantes");
        vp_turma_selecionada.setAdapter(vpAturmaselecionada);
    }
}