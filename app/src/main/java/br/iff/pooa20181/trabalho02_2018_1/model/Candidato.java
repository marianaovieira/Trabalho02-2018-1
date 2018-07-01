package br.iff.pooa20181.trabalho02_2018_1.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Candidato extends RealmObject implements Serializable {

    @PrimaryKey
    int id;
    private String nome;
    private String partido;
    private String numero_urna;
    private String cargo;
    private String numero_votos;
    private String cidade;
    private String estado;

    public Candidato(){

    }

    public Candidato(int id, String nome,String partido, String numero_urna, String cargo, String numero_votos, String cidade, String estado){


        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numero_urna = numero_urna;
        this.cargo = cargo;
        this.numero_votos = numero_votos;
        this.cidade = cidade;
        this.estado = estado;

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

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
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
