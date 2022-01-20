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
import com.example.lingoappTcc.fragmentos.TurmaAtividadesFragment;
import com.example.lingoappTcc.fragmentos.TurmaParticipantesFragment;
import com.google.android.material.tabs.TabLayout;

public class TurmaSelecionadaPActivity extends AppCompatActivity {

    private ImageButton btn_voltar, btn_gerenciar;
    private TabLayout tab_turma_selecionadaP;
    private ViewPager vp_turma_selecionadaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_turma_selecionada_p);

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_gerenciar = findViewById(R.id.btn_gerenciar);
        tab_turma_selecionadaP = findViewById(R.id.tab_turma_selecionada_p);
        vp_turma_selecionadaP = findViewById(R.id.vp_turma_selecionada_p);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
            }
        });

        btn_gerenciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_gerenciarActivity();
            }
        });

        tab_turma_selecionadaP.setupWithViewPager(vp_turma_selecionadaP);

        VPAdapter vpAturmaselecionadaP = new VPAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAturmaselecionadaP.adicionarFragmento(new TurmaAtividadesFragment(),"Atividades");
        vpAturmaselecionadaP.adicionarFragmento(new TurmaParticipantesFragment(),"Desempenho");
        vp_turma_selecionadaP.setAdapter(vpAturmaselecionadaP);
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, AbaTurmasProfessorActivity.class));
    }

    private void btn_gerenciarActivity() {
        startActivity(new Intent (this,GerenciarTurmaActivity.class));
    }
}