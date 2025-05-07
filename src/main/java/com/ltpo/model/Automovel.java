package com.ltpo.model;


import com.ltpo.model.Modelo;
import jakarta.persistence.*;

@Entity
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private Integer id;

    private String nome;
    private int ano;
    private String cor;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modelo", referencedColumnName = "id")
    private Modelo modelo;


    public Automovel(){

    }

    public Automovel(String nome, int ano, String cor){
        this.nome = nome;
        this.ano = ano;
        this.cor = cor;
    }



    public Integer getId(){return id;}
    public String getNome(){return nome;}
    public int getAno(){return ano;}
    public String getCor(){return cor;}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Automovel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", modelo=" + modelo +
                '}';
    }
}