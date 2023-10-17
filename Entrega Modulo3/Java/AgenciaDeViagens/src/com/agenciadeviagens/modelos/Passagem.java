package com.agenciadeviagens.modelos;

public class Passagem {
	
	//atributos
		private int id_passagem;
		private int quantidade;
		private String origem;
		private String destino;
		private double valor_passagem;
		
		Pedidos pedido;

		
		
		//construtor
		public Passagem() {
		}

		public Passagem(int id_passagem, int quantidade, String origem, String destino, double valor_passagem, Pedidos pedido) {
			this.id_passagem = id_passagem;
			this.quantidade = quantidade;
			this.origem = origem;
			this.destino = destino;
			this.valor_passagem = valor_passagem;
			this.pedido = pedido;
		}

		public Passagem(int quantidade, String origem, String destino, double valor_passagem,Pedidos pedido) {
			this.quantidade = quantidade;
			this.origem = origem;
			this.destino = destino;
			this.valor_passagem = valor_passagem;
			this.pedido = pedido;
		}

		
		//getters e setters
		public int getId_passagem() {
			return id_passagem;
		}

		public void setId_passagem(int id_passagem) {
			this.id_passagem = id_passagem;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public String getOrigem() {
			return origem;
		}

		public void setOrigem(String origem) {
			this.origem = origem;
		}

		public String getDestino() {
			return destino;
		}

		public void setDestino(String destino) {
			this.destino = destino;
		}

		public double getValor_passagem() {
			return valor_passagem;
		}

		public void setValor_passagem(double valor_passagem) {
			this.valor_passagem = valor_passagem;
		}

		public Pedidos getPedido() {
			return pedido;
		}

		public void setPedido(Pedidos pedido) {
			this.pedido = pedido;
		}

		@Override
		public String toString() {
			return "Passagem [id_passagem=" + id_passagem + ", quantidade=" + quantidade + ", origem=" + origem
					+ ", destino=" + destino + ", valor_passagem=" + valor_passagem + ", pedido=" + pedido + "]";
		}
	
			
		//toString
		
		

}
