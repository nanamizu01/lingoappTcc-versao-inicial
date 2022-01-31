package com.example.lingoappTcc.atividades.cadastroelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.atividades.AbaAtividadesEstudanteActivity;
import com.example.lingoappTcc.atividades.perfil.AbaPerfilEstudanteActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;

public class LoginEstudanteActivity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_entrar;
    private TextView text_aqui;
    private EditText campo_email_estudante;
    private EditText campo_senha_estudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_estudante);

        getSupportActionBar().hide();
        IniciarComponentes();

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String email = campo_email_estudante.getText().toString();
            String senha = campo_senha_estudante.getText().toString();

            if(email.isEmpty() || senha.isEmpty()){
                Snackbar snackbar = Snackbar.make(v,"Preencha todos os campos!", Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.WHITE);
                snackbar.setTextColor(Color.BLACK);
                snackbar.show();
            }else{
                AutenticarEstudante(v);
            }
            }
        });

        text_aqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_aquiActivity();
            }
        });
    }

    private void AutenticarEstudante(View v){
        String email = campo_email_estudante.getText().toString();
        String senha = campo_senha_estudante.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AbaPerfilEstudanteActivity();
                        }
                    },2000);
                }else{
                    String erro;

                    try{
                        throw task.getException();
                    }catch(FirebaseAuthInvalidCredentialsException e){
                        erro = "E-mail Inválido!";
                    }catch(Exception e){
                    erro = "Erro ao logar usuário, tente novamente";
                    }
                    Snackbar snackbar = Snackbar.make(v,erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();

        if(usuarioAtual != null){
            AbaPerfilEstudanteActivity();
        }
    }

    private void IniciarComponentes(){
        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);
        text_aqui = (TextView) findViewById(R.id.text_aqui);
        campo_email_estudante = (EditText) findViewById(R.id.campo_email_estudante);
        campo_senha_estudante = (EditText) findViewById(R.id.campo_senha_estudante);
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }

    private void AbaPerfilEstudanteActivity() {
        startActivity(new Intent(this, AbaPerfilEstudanteActivity.class));
    }

    private void text_aquiActivity() {
        startActivity(new Intent(this, RecuperarSenhaActivity.class));
    }
}