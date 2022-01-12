package com.example.lingoappTcc.atividades.turmas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.fragmentos.TurmaAtividadesFragment;
import com.example.lingoappTcc.fragmentos.TurmaParticipantesFragment;
import com.google.android.material.tabs.TabLayout;

public class TurmaSelecionadaEActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private TabLayout tab_turma_selecionadaE;
    private ViewPager vp_turma_selecionadaE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_turma_selecionada_e);

        btn_voltar = findViewById(R.id.btn_voltar);
        tab_turma_selecionadaE = findViewById(R.id.tab_turma_selecionada_e);
        vp_turma_selecionadaE = findViewById(R.id.vp_turma_selecionada_e);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
            }
        });

        tab_turma_selecionadaE.setupWithViewPager(vp_turma_selecionadaE);

        VPAdapter vpAturmaselecionadaE = new VPAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAturmaselecionadaE.adicionarFragmento(new TurmaAtividadesFragment(),"Atividades");
        vpAturmaselecionadaE.adicionarFragmento(new TurmaParticipantesFragment(),"Participantes");
        vp_turma_selecionadaE.setAdapter(vpAturmaselecionadaE);
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, AbaTurmasEstudanteActivity.class));
    }
}