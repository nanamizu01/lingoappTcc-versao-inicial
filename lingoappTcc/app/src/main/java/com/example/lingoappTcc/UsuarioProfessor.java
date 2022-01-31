package com.example.lingoappTcc;

public class UsuarioProfessor {

    String nome, sobrenome, nome_completo;
    int imageId;


    public UsuarioProfessor(String nome, String sobrenome, int imageId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.imageId = imageId;

        this.nome_completo=nome.concat(" ");
        this.nome_completo=nome_completo.concat(sobrenome);

    }
}
