package com.ltpo;

import java.util.List;

import com.ltpo.DAO.AutomovelDAO;
import com.ltpo.DAO.ModeloDAO;
import com.ltpo.DAO.UsuarioDAO;
import com.ltpo.enums.Cor;
import com.ltpo.enums.Tipo;
import com.ltpo.model.*;

public class Main {
    public static void main(String[] args) {
        AutomovelDAO automovelDAO = new AutomovelDAO();
        ModeloDAO modeloDAO = new ModeloDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Modelo modelo = new Modelo("Argo", "Fiat");
        Usuario usuario = new Usuario("João da Silva", "11999999999", Tipo.CLIENTE);
        Automovel automovel = new Automovel("Fiat Argo", 2023, Cor.VERMELHO);

        automovel.setModelo(modelo);
        automovel.setUsuario(usuario);
        usuario.adicionarAutomovel(automovel);

        usuarioDAO.salvar(usuario); // Salva tudo em cascata

        System.out.println("Usuário inserido: " + usuario);
        System.out.println("Automóvel inserido: " + automovel);
        System.out.println("Modelo inserido: " + modelo);

        List<Automovel> automoveis = automovelDAO.buscarTodos();
        System.out.println("\nTodos os automóveis:");
        for (Automovel a : automoveis) {
            System.out.println(a);
        }

        List<Modelo> modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os modelos:");
        for (Modelo m : modelos) {
            System.out.println(m);
        }

        Automovel automovelBuscado = automovelDAO.buscarPorId(1);
        System.out.println("\nAutomóvel com ID 1: " + automovelBuscado);

        Modelo modeloBuscado = modeloDAO.buscarPorId(1);
        System.out.println("\nModelo com ID 1: " + modeloBuscado);
    }
}
