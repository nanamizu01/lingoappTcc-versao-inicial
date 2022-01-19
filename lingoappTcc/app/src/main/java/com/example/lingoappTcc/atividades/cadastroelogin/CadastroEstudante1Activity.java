package com.example.lingoappTcc.atividades.cadastroelogin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lingoappTcc.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroEstudante1Activity extends AppCompatActivity {

    private ImageButton btn_voltar;
    private Button btn_proximo;
    private EditText campo_nome_estudante;
    private EditText campo_sobrenome_estudante;
    private EditText campo_data_nascimento_estudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro_estudante1);

        campo_nome_estudante = (EditText) findViewById(R.id.campo_nome_estudante);
        campo_sobrenome_estudante = (EditText) findViewById(R.id.campo_sobrenome_estudante);
        campo_data_nascimento_estudante = (EditText) findViewById(R.id.campo_data_nascimento_estudante);
        btn_voltar = (ImageButton) findViewById(R.id.btn_voltar);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_voltarActivity();
            }
        });

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                btn_proximoActivity();
            }
        });
    }
        @RequiresApi(api = Build.VERSION_CODES.O)
        private void validaCampos() {

            boolean res = false;

            String nome = campo_nome_estudante.getText().toString();
            String sobrenome = campo_sobrenome_estudante.getText().toString();
            String dataNascimento = campo_data_nascimento_estudante.getText().toString();

            if (res = isCampoVazio(nome)) {
                campo_nome_estudante.requestFocus();
            } else if (res = isCampoVazio(sobrenome)) {
                campo_sobrenome_estudante.requestFocus();
            } else if (!isdataNascimentoValida(dataNascimento) && !dataMenorQueHoje(dataNascimento)) {
                campo_data_nascimento_estudante.requestFocus();
                res = true;
            }

            if(res){
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle(R.string.title_aviso);
                dlg.setMessage(R.string.message_campos_invalidos);
                dlg.setNeutralButton(R.string.lbl_ok,null);
                dlg.show();
            }
        }

        private boolean isCampoVazio (String valor){

            boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
            return resultado;
        }

    public boolean isdataNascimentoValida(String dataNascimento) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(dataNascimento);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean dataMenorQueHoje(String dataNascimento) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVerificada = LocalDate.parse(dataNascimento, dtf);
        LocalDate hoje = LocalDate.now();
        return dataVerificada.compareTo(hoje) <= 0;
    }


    private void btn_voltarActivity() {
        startActivity(new Intent(this, PaginaCadastroActivity.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void btn_proximoActivity() {
        validaCampos();
        startActivity(new Intent(this, CadastroEstudante2Activity.class));
    }

}