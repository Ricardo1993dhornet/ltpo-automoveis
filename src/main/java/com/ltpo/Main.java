package com.ltpo;

import java.util.List;

import com.ltpo.DAO.AutomovelDAO;
import com.ltpo.DAO.ModeloDAO;
import com.ltpo.model.Automovel;
import com.ltpo.model.Modelo;

public class Main {
    public static void main(String[] args){
        AutomovelDAO automovelDAO = new AutomovelDAO();
        ModeloDAO modeloDAO = new ModeloDAO();

// Inserir um novo usuário.
        Modelo modelo = new Modelo("Argo", "Fiat");
        Automovel automovel = new Automovel("Fiat Argo", 2023, "Vermelho");

        automovelDAO.salvar(automovel);
        modeloDAO.salvar(modelo);


        System.out.println("Automóvel inserido: " + automovel);
        System.out.println("Modelo inserido: " + modelo);

// Buscar todos os automóveis

        List<Automovel> automoveis = automovelDAO.buscarTodos();
        List<Modelo> modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os automóveis:");
        for (Automovel a : automoveis) {
            System.out.println(a);
// Buscar um usuário por ID
            Automovel automovelBuscado = automovelDAO.buscarPorId(1);
            System.out.println("\nAutomóvel com ID 1: " + automovelBuscado);
        }
        System.out.println("\nTodos os modelos: ");
        for (Modelo m : modelos){
            System.out.println(m);
            Modelo modeloBuscado = modeloDAO.buscarPorId(1);
            System.out.println("\nModelo com ID 1: " + modeloBuscado);
        }
    }
}