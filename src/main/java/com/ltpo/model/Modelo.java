package com.ltpo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id @GeneratedValue @Column(name = "id")
    private Integer id;
    private String nome;
    private String marca;

    @OneToOne(mappedBy = "modelo")
    private Automovel automovel;

    public Modelo(){

    }

    public Modelo(String nome, String marca){
        this.nome = nome;
        this.marca = marca;
    }

    public Integer getId(){return id;}
    public String getNome(){return nome;}
    public String marca(){return marca;}
    public Automovel getAutomovel(){return automovel;}

    public void setId(Integer id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setAutomovel(Automovel automovel){
        this.automovel = automovel;
    }


    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", automovel=" + automovel +
                '}';
    }
}