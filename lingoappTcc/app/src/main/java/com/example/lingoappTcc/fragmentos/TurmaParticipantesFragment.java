package com.example.lingoappTcc.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lingoappTcc.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TurmaParticipantesFragment extends Fragment {

    ListView lvProfessores;
    ListView lvEstudantes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turma_participantes, container, false);
        //fazer a listview de professores funcionar

        lvProfessores= (ListView)view.findViewById(R.id.lv_professores);
        //lvEstudantes= (ListView) view.findViewById(R.id.lv_estudantes);

        ArrayList<String> nomesProfessores = new ArrayList<>();
        ArrayList<String> nomesEstudantes = new ArrayList<>();

        nomesProfessores.add("Daniel Bussolaro");
        nomesProfessores.add("Flávia Sampaio");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               getActivity(), R.layout.lista_item_professor,R.id.text_nome_professor,nomesProfessores);

        lvProfessores.setAdapter(adapter);

        return view;

    }

}