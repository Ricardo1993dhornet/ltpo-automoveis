package com.ltpo.model;

import com.ltpo.enums.Tipo;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Automovel> automoveis = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nome, String telefone, Tipo tipo) {
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public Tipo getTipo() { return tipo; }
    public List<Automovel> getAutomoveis() { return automoveis; }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }
    public void setAutomoveis(List<Automovel> automoveis) { this.automoveis = automoveis; }

    public void adicionarAutomovel(Automovel automovel) {
        automoveis.add(automovel);
        automovel.setUsuario(this);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", automoveis=" + automoveis +
                '}';
    }
}