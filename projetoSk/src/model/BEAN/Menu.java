package model.BEAN;

import facade.FacadeSiri_Kaskudo;

public class Menu extends Cliente {

    String nome, sobrenome, cpf;
    private FacadeSiri_Kaskudo ponte = new FacadeSiri_Kaskudo();

    public Menu() {
    }

    public Menu(String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
    }

    public void exibirCardapio() {
        ponte.exibirCardapio();
    }

    public void escolherPrato() {
        System.out.println(this.ponte.escolherPrato());
    }

    public void finalizarPedido() {
        this.ponte.finalizarPedido();
    }

    public void escolherBebidas() {
        this.ponte.escolherBebida();
    }
    
     public void finalizarPedidoBebida() {
        this.ponte.finalizarPedidoBebida();
    }
}
