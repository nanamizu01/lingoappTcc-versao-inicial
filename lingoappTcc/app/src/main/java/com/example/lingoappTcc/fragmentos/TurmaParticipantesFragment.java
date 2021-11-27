package com.example.lingoappTcc.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.databinding.FragmentTurmaParticipantesBinding;

public class TurmaParticipantesFragment extends Fragment {

    //FragmentTurmaParticipantesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding = FragmentTurmaParticipantesBinding.inflate(getLayoutInflater());
        return inflater.inflate(R.layout.fragment_turma_participantes,container,false);
        //fazer a listview de professores funcionar

    }

}