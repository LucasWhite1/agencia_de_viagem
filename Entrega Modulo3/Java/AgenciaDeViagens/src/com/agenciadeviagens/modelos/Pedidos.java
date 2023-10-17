package com.agenciadeviagens.modelos;

public class Pedidos {
	
	//atributos
	private int num_pedido;
	private String dt_pedido;
	private String forma_pgmto;
	
	
	Passageiros passageiro;

	//construtor
	
	
	public Pedidos() {
	}


	public Pedidos(int num_pedido, String dt_pedido, String forma_pgmto, Passageiros passageiro) {
		this.num_pedido = num_pedido;
		this.dt_pedido = dt_pedido;
		this.forma_pgmto = forma_pgmto;
		this.passageiro = passageiro;
	}


	public Pedidos(String dt_pedido, String forma_pgmto, Passageiros passageiro) {
		this.dt_pedido = dt_pedido;
		this.forma_pgmto = forma_pgmto;
		this.passageiro = passageiro;
	}

	
	//getters e setters

	public int getNum_pedido() {
		return num_pedido;
	}


	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}


	public String getDt_pedido() {
		return dt_pedido;
	}


	public void setDt_pedido(String dt_pedido) {
		this.dt_pedido = dt_pedido;
	}


	public String getForma_pgmto() {
		return forma_pgmto;
	}


	public void setForma_pgmto(String forma_pgmto) {
		this.forma_pgmto = forma_pgmto;
	}


	public Passageiros getPassageiro() {
		return passageiro;
	}


	public void setPassageiro(Passageiros passageiro) {
		this.passageiro = passageiro;
	}


	
	//toString
	@Override
	public String toString() {
		return "Pedidos [num_pedido=" + num_pedido + ", dt_pedido=" + dt_pedido + ", forma_pgmto=" + forma_pgmto
				+ ", passageiro=" + passageiro + "]";
	}
	
	

}
