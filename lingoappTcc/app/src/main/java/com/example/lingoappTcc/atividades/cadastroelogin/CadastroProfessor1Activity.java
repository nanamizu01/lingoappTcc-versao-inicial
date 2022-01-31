package com.example.lingoappTcc.atividades.cadastroelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lingoappTcc.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CadastroProfessor1Activity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_proximo;
    private EditText campo_nome_professor;
    private EditText campo_email_professor;
    private EditText campo_senha_professor;
    private EditText campo_confirmar_senha_professor;
    String professorID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor1);

        getSupportActionBar().hide();
        IniciarComponentes();



        btn_voltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_proximo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nome = campo_nome_professor.getText().toString();
                String email = campo_email_professor.getText().toString();
                String senha = campo_senha_professor.getText().toString();
                String confirmarSenha = campo_confirmar_senha_professor.getText().toString();

                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,"Preencha todos os campos!", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                } else{
                    CadastrarUsuario(v);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            PaginaInicialActivity();
                        }
                    },2000);
                }
            }
        });
    }

    private void CadastrarUsuario(View v){
        String email = campo_email_professor.getText().toString();
        String senha = campo_senha_professor.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    SalvarDadosProfessor();
                }else{
                    String erro;
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no mínimo 6 caracteres!";
                    }catch(FirebaseAuthUserCollisionException e) {
                        erro = "Esta conta já foi cadastrada!";
                    }catch(FirebaseAuthInvalidCredentialsException e){
                        erro = "E-mail Inválido!";
                    }catch (Exception e){
                        erro = "Erro em cadastrar usuário. Tente novamente!";
                    }
                    Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                }
            }
        });
    }

    private void SalvarDadosProfessor(){
        String nome = campo_nome_professor.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String,Object> professores = new HashMap<>();
        professores.put("Nome", nome);

        professorID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Professores").document(professorID);
        documentReference.set(professores).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db","Sucesso ao salvar os dados!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_erro", "Erro ao salvar dados!"+ e.toString());
                    }
                });
    }

    private void IniciarComponentes(){
        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        campo_nome_professor = (EditText) findViewById(R.id.campo_nome_professor);
        campo_email_professor = (EditText) findViewById(R.id.campo_email_professor);
        campo_senha_professor = (EditText) findViewById(R.id.campo_senha_professor);
        campo_confirmar_senha_professor = (EditText) findViewById(R.id.campo_confirmar_senha_professor);
    }

    private void btn_voltarActivity() {
        startActivity(new Intent(this, PaginaCadastroActivity.class));
    }

    private void PaginaInicialActivity() {
        startActivity(new Intent(this, PaginaInicialActivity.class));
    }
}