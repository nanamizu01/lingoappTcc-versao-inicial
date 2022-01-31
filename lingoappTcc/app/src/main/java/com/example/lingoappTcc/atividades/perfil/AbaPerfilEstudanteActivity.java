package com.example.lingoappTcc.atividades.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lingoappTcc.R;
import com.example.lingoappTcc.atividades.atividades.AbaAtividadesEstudanteActivity;
import com.example.lingoappTcc.atividades.cadastroelogin.PaginaInicialActivity;
import com.example.lingoappTcc.atividades.turmas.AbaTurmasEstudanteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class AbaPerfilEstudanteActivity extends AppCompatActivity {

    private Button btn_editar_dados;
    private Button btn_historico_atividades;
    private Button btn_sair;
    private TextView nomeEstudante;
    private TextView emailEstudante;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String estudanteID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aba_perfil_estudante);

        getSupportActionBar().hide();
        IniciarComponentes();

        btn_editar_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_editar_dadosActivity();
            }
        });

        btn_historico_atividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_historico_atividadesActivity();
            }
        });

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(AbaPerfilEstudanteActivity.this, PaginaInicialActivity.class);
                startActivity(intent);
                finish();
            }
        });

        BottomNavigationView menu_inferior = findViewById(R.id.menu_inferior);
        menu_inferior.setSelectedItemId(R.id.nav_perfil);
        menu_inferior.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_turmas:
                        startActivity(new Intent(getApplicationContext()
                                , AbaTurmasEstudanteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_atividades:
                        startActivity(new Intent(getApplicationContext()
                                , AbaAtividadesEstudanteActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_perfil:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        estudanteID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Estudantes").document(estudanteID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                if(documentSnapshot != null){
                    nomeEstudante.setText(documentSnapshot.getString("Nome"));
                    emailEstudante.setText(email);
                }
            }
        });
    }

    private void IniciarComponentes(){
        btn_editar_dados = (Button) findViewById(R.id.btn_editar_dados);
        btn_historico_atividades = (Button) findViewById(R.id.btn_historico_atividades);
        btn_sair = (Button) findViewById(R.id.btn_sair);
        nomeEstudante = (TextView) findViewById(R.id.campo_nome_estudante);
        emailEstudante = (TextView) findViewById(R.id.campo_email_estudante);
    }

    private void btn_sairActivity() {
    }

    private void btn_historico_atividadesActivity() {
        startActivity(new Intent(AbaPerfilEstudanteActivity.this, HistoricoAtividadesEstudanteActivity.class));
    }

    private void btn_editar_dadosActivity() {
        startActivity(new Intent(AbaPerfilEstudanteActivity.this, AlterarDadosEstudanteActivity.class));
    }

}