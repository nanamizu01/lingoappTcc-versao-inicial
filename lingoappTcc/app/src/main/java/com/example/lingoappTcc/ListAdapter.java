package com.example.lingoappTcc;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<UsuarioEstudante> {

    public ListAdapter(Context context, ArrayList<UsuarioEstudante> usuarioEstudanteArrayList){

        super(context,R.layout.lista_item_professor,usuarioEstudanteArrayList);
    }


}
