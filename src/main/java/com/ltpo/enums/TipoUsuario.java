package com.ltpo.enums;

public enum TipoUsuario {
    CLIENTE("Cliente"),
    MECANICO("Mecânico");

    private final String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}