package com.example.lingoappTcc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<UsuarioProfessor> {

    public ListAdapter(Context context, ArrayList<UsuarioProfessor> usuarioEstudanteArrayList){

        super(context,R.layout.lista_item_professor,usuarioEstudanteArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        UsuarioProfessor professor = getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.lista_item_professor,parent,false);

        }

        ImageView avatar_professor=convertView.findViewById(R.id.cim_avatar_professor);
        TextView nome_professor=convertView.findViewById(R.id.text_nome_professor);

        avatar_professor.setImageResource(professor.imageId);
        nome_professor.setText(professor.nome_completo);

        return super.getView(position, convertView, parent);
    }
}
