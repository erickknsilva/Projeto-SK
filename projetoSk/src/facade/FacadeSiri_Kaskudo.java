/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import java.util.Scanner;
import model.DAO.MetodosDAO;
import model.enity.Bebidas;
import model.enity.Pratos;

/**
 *
 * @author eric
 */
public class FacadeSiri_Kaskudo {

    private MetodosDAO funcoes;

    //essa classe faz a ponte com as funcoes do banco de dados
    public FacadeSiri_Kaskudo() {
        this.funcoes = new MetodosDAO();
    }

    public void exibirCardapio() {
        this.funcoes.exibirCardapaio();
    }

    public int escolherPrato() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escolha seu pedido.");
        this.funcoes.escolherPrato();

        System.out.print("Numero escolhido: ");
        int prato = entrada.nextInt();

        return prato;
    }

    public void finalizarPedido() {
        Pratos prato = this.funcoes.finalizarPedido(escolherPrato());
        System.out.println(prato.toString());
    }

    public int escolherBebida() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nVocê gostaria de adicionar alguma bebida ?\n" //
                + "1 = Sim\n" //
                + "2 = Não\n"//
                + "Numero escolhido: ");
        int opcaoBebida = entrada.nextInt();

        int numberBebida = 0;

        for (;;) {
            while (opcaoBebida != 2) {
                if (opcaoBebida > 0 || opcaoBebida <= 9) {
                    if (opcaoBebida == 1)//
                    {
                        System.out.print("\nPresione 0 para cancelar a bebida.");
                        this.funcoes.escolherBebida();

                        System.out.println("\nEscolha o numero da bebida!");
                        numberBebida = entrada.nextInt();
                        return numberBebida;
                    }//fim do if interno
                    else {
                        System.out.println("\nBebida não encontrada.");
                        System.out.print("Você gostaria de adicionar alguma bebida ?\n" //
                                + "1 = Sim\n" //
                                + "2 = Não\n"//
                                + "Numero escolhido: ");
                        opcaoBebida = entrada.nextInt();
                    }
                }//fim do if externo
            }//fim do while
            break;
        }//fim do for infinito
        entrada.close();
        return numberBebida;
    }

    public void finalizarPedidoBebida() {
        Bebidas b = this.funcoes.finalizarBebida(escolherBebida());
        System.out.println(b.toString());
    }
}
