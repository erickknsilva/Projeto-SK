/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enity;

/**
 *
 * @author eric
 */
public class Bebidas {

    private int idBebida, quantidade;

    private String nome = "Nenhum";
    private double preco;

    public Bebidas() {
    }

    public Bebidas(int idBebida, String nome, double preco) {
        this.idBebida = idBebida;
        this.nome = nome;
        this.preco = preco;
    }

    public Bebidas(int id) {
        this.idBebida = id;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        String formata = String.format("ID: %d, nome: %s, preco: %.2f", idBebida, nome, preco);
        return formata;
    }

}
