package br.iff.pooa20181.trabalho02_2018_1.model;

import java.io.Serializable;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Eleitor extends RealmObject implements Serializable{

    @PrimaryKey
    private int id;
    private String nome;
    private String nome_mae;
    private String data_nascimento;
    private String numero_titulo;
    private String zona_eleitoral;
    private String secao_eleitoral;
    private String cidade;


    public Eleitor(){

    }

    public Eleitor(int id, String nome, String nome_mae, String data_nascimento, String numero_titulo, String zona_eleitoral, String secao_eleitoral, String cidade){

        this.id = id;
        this.nome = nome;
        this.nome_mae = nome_mae;
        this.data_nascimento = data_nascimento;
        this.numero_titulo = numero_titulo;
        this.zona_eleitoral = zona_eleitoral;
        this.secao_eleitoral = secao_eleitoral;
        this.cidade = cidade;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNumero_titulo() {
        return numero_titulo;
    }

    public void setNumero_titulo(String numero_titulo) {
        this.numero_titulo = numero_titulo;
    }

    public String getZona_eleitoral() {
        return zona_eleitoral;
    }

    public void setZona_eleitoral(String zona_eleitoral) {
        this.zona_eleitoral = zona_eleitoral;
    }

    public String getSecao_eleitoral() {
        return secao_eleitoral;
    }

    public void setSecao_eleitoral(String secao_eleitoral) {
        this.secao_eleitoral = secao_eleitoral;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


}
