/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.BEAN;

/**
 *
 * @author eric
 */
public class ThreadSiriCascudo implements Runnable {

    private String nome;

    Thread thread;

    public ThreadSiriCascudo() {
        thread = new Thread(this, "Pedido confirmado.");
        this.nome = nome;
        thread.start();
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 3; i++) {
                thread.sleep(800);
                System.out.println("preparando pedido.");
            }
        } catch (InterruptedException thrd) {
            System.out.println("Pedido interrompido.");
        }
        System.out.println("\nPreprando pedido aguarde!");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void thredDeExecucao() {

        System.out.println("Esperando confirmação do pedido...\nPedido confirmado...");
        System.out.println("Iniciando a preparação do pedido...\n");

        ThreadSiriCascudo thread = new ThreadSiriCascudo();

        for (int i = 0; i < 20; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException thred) {
                System.out.println("Pedido interrompido.");
            }
        }
        System.out.println("\n\nPedido finalizado.\nBom apetite.");
    }

}
