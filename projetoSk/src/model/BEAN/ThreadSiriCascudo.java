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
				thread.sleep(5000);
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

}
