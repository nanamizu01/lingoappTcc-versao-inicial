package com.example.lingoappTcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginProfessorActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_entrar;
    private TextView text_aqui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_professor);

        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);
        text_aqui = (TextView) findViewById(R.id.text_aqui);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_entrarActivity();
            }
        });

        text_aqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_aquiActivity();
            }
        });
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }

    private void btn_entrarActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void text_aquiActivity() {
        startActivity(new Intent(this, RecuperarSenhaActivity.class));
    }
}