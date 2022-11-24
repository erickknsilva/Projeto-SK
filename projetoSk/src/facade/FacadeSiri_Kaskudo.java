package facade;

import java.util.Scanner;
import model.BEAN.Cliente;
import model.BEAN.Pagamento;
import model.BEAN.ThreadSiriCascudo;
import model.DAO.MetodosDAO;
import model.enity.Bebidas;
import model.enity.Pratos;

/**
 *
 * @author eric
 */
public class FacadeSiri_Kaskudo implements Pagamento {

    Pratos p = new Pratos();
    Bebidas b = new Bebidas();
    private MetodosDAO funcoes;
    private static int contador = 0;

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

    public int escolherBebida() {
        int numberBebida = 0;
        int i = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.print("\nVocê gostaria de adicionar alguma bebida ?\n" //
                + "1 = Sim\n" //
                + "2 = Não\n"//
                + "Numero escolhido: ");
        int opcaoBebida = entrada.nextInt();

        while (opcaoBebida != 2) {
            //pergunta quantas bebidas
//            if (opcaoBebida == 1) {
//                System.out.print("Quantas bebidas deseja adicionar: ");
//                contador = entrada.nextInt();
//            }

            if (opcaoBebida == 1)//
            {
//                for (int j = 0; j < contador; j++) {
                if (numberBebida >= 1 || opcaoBebida <= 9) {
                    System.out.print("\nPresione 0 para cancelar a bebida.\n");
                    this.funcoes.escolherBebida();

                    System.out.print("\nEscolha o numero da bebida.\nNumero escolhido: ");
                    numberBebida = entrada.nextInt();

                    //pergunta quantas bebidas
//                        while (numberBebida < 1 || numberBebida > 9) {
//
//                            if (numberBebida < 0 || numberBebida > 9) {
//                                System.out.print("\nBebida invalida.\nEscolha um numero existente: ");
//                                numberBebida = entrada.nextInt();
//                            }
//                        }
//                    }
                }
                return numberBebida;
            } else {
                System.out.println("\nBebida não encontrada.");
                System.out.print("Você gostaria de adicionar alguma bebida ?\n" //
                        + "1 = Sim\n" //
                        + "2 = Não\n"//
                        + "Numero escolhido: ");
                opcaoBebida = entrada.nextInt();
            }
        }
        entrada.close();
        return numberBebida;
    }

    public void finalizarPedidoBebida() {

        b = this.funcoes.finalizarBebida(escolherBebida());

    }

    public void finalizarPedido() {
        p = this.funcoes.finalizarPedido(escolherPrato());
        System.out.println(p.toString());
        finalizarPedidoBebida();
        notaFiscal();
    }

    @Override
    public void valorDoPrato() {
        p.setValor(p.getValor() + b.getPreco());
        System.out.print("\n\t\tValor total do prato: " + p.getValor() + "\n");
    }

    @Override
    public void calcularGramasDeComida() {
    }

    @Override
    public void baixaEstoque() {

    }

    private void notaFiscal() {
        System.out.println("________________________________________________________________________________\n");
        ThreadSiriCascudo.thredDeExecucao();

        System.out.println("\n________________________________________________________________________________");
        System.out.println("\n\t\tNota fiscal\n");
        Cliente.infoCliente();
        System.out.print("\n\t\tProduto consumido.\n");
        System.out.println(p.toString());
        System.out.println(b.toString());
        valorDoPrato();
        System.out.println("________________________________________________________________________________");

    }
}
