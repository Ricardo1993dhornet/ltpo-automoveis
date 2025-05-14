package com.ltpo.model;

import com.ltpo.enums.Cor;
import jakarta.persistence.*;

@Entity
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;
    private int ano;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modelo", referencedColumnName = "id")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Automovel() {}

    public Automovel(String nome, int ano, Cor cor) {
        this.nome = nome;
        this.ano = ano;
        this.cor = cor;
    }


    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public int getAno() { return ano; }
    public Cor getCor() { return cor; }
    public Modelo getModelo() { return modelo; }
    public Usuario getUsuario() { return usuario; }

    public void setId(Integer id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setAno(int ano) { this.ano = ano; }
    public void setCor(Cor cor) { this.cor = cor; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public String toString() {
        return "Automovel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ano=" + ano +
                ", cor=" + cor +
                ", modelo=" + modelo +
                ", usuario=" + (usuario != null ? usuario.getNome() : "null") +
                '}';
    }
}
