package controller;

import model.BEAN.Menu;

public class PedidoApp {

    public static void main(String[] args) {

        Menu menu = new Menu("Erick", "Nunes", "145.654");

//        menu.exibirCardapio();
        menu.finalizarPedido();
//        menu.escolherBebidas();

    }
}
