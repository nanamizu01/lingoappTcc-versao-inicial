package com.example.lingoappTcc.atividades.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.perfil.AbaPerfilEstudanteActivity;

public class ConquistasEstudanteActivity extends AppCompatActivity {

    private ImageButton btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_conquistas_estudante);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_voltarActivity();
            }
        });
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, AbaPerfilEstudanteActivity.class));
    }


}
