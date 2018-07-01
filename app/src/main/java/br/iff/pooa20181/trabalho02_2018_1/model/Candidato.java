package br.iff.pooa20181.trabalho02_2018_1.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Candidato extends RealmObject implements Serializable {

    @PrimaryKey
    private String nome;
    private String nome_mae;
    private String numero_urna;
    private String cargo;
    private String numero_votos;
    private String cidade;
    private String estado;

    public Candidato(){

    }

    public Candidato(String nome,String nome_mae, String numero_urna, String cargo, String numero_votos, String cidade, String estado){

        this.nome = nome;
        this.nome_mae = nome_mae;
        this.numero_urna = numero_urna;
        this.cargo = cargo;
        this.numero_votos = numero_votos;
        this.cidade = cidade;
        this.estado = estado;

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

    public String getNumero_urna() {
        return numero_urna;
    }

    public void setNumero_urna(String numero_urna) {
        this.numero_urna = numero_urna;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNumero_votos() {
        return numero_votos;
    }

    public void setNumero_votos(String numero_votos) {
        this.numero_votos = numero_votos;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
