package com.example.lingoappTcc.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.atividades.PagTarefaAlunoActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasProfessorActivity;

public class AtividadesDisponiveisEstudanteFragment extends Fragment {

    private Button btn_atividade_mus1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmento = inflater.inflate(R.layout.fragment_atividades_disponiveis_estudante, container, false);

        btn_atividade_mus1 = fragmento.findViewById(R.id.btn_atividade_mus1);

        try {
            btn_atividade_mus1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btn_atividade_mus1Metodo();
                }
            });
        }catch(Exception exception){

        }
        return fragmento;
    }

    private void btn_atividade_mus1Metodo() {

    }
}