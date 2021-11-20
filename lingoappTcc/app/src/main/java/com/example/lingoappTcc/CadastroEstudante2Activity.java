package com.example.lingoappTcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CadastroEstudante2Activity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro_estudante2);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);

        btn_voltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_proximo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_proximoActivity();
            }
        });
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, CadastroEstudante1Activity.class));
    }

    private void btn_proximoActivity() {
        startActivity(new Intent(this, ConfirmarEmailActivity.class));
    }
}