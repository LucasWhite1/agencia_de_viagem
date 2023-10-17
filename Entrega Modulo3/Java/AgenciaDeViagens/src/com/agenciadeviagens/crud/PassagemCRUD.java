package com.agenciadeviagens.crud;

import java.util.Scanner;

import com.agenciadeviagens.dao.PedidosDAO;
import com.agenciadeviagens.dao.PassagemDAO;
import com.agenciadeviagens.modelos.Passagem;
import com.agenciadeviagens.modelos.Pedidos;


public class PassagemCRUD {

	public static void main(String[] args) {
			
			Scanner s = new Scanner(System.in);
			PassagemDAO passagemDAO = new PassagemDAO();
			PedidosDAO pedidoDAO = new PedidosDAO();
			
			int opcao = 0, id_passagem = 0, num_pedido = 0, quantidade = 0; 
			
			String origem = "", destino = "";
			
			double valor_passagem = 0;
			
			System.out.println("\n=========== BEM VINDO A PAGINA DE PASSAGENS DA AGENCIA DE VIAGENS ==============\n");
			
			do {
				
				System.out.println("\n====================== SELECIONE UMA OPCAO ABAIXO =====================\n");
				System.out.println("(1)RESERVAR   (2)CONSULTAR   (3)ATUALIZAR   (4)CANCELAR   (5)CONSULTAR POR ID  (0)SAIR");
				opcao = s.nextInt();
				s.nextLine();
				
				switch (opcao) {
				case 1:
					System.out.println("Digite a quantidade de passagens:");
					quantidade = s.nextInt();
					s.nextLine();
					System.out.println("Digite a cidade de origem:");
					origem = s.nextLine();
					System.out.println("Digite o destino desejado:");
					destino = s.nextLine();
					
					System.out.println("Digite o valor unitario da passagem:");
					valor_passagem = s.nextDouble();
					s.nextLine();
					System.out.println("Digite o numero do pedido:");
					num_pedido = s.nextInt();
					s.nextLine();
					
					System.out.println("================ PASSAGEM RESERVADA ================");
					
					Pedidos pedido1 = pedidoDAO.readById(num_pedido);
					
					Passagem passagem1 = new Passagem(quantidade, origem, destino, valor_passagem, pedido1);
					
					passagemDAO.create(passagem1);
					
					break;
					
				case 2:
					
					for (Passagem u : passagemDAO.read()) {
						System.out.println(u.toString());
					}
					
					break;
				case 3:
					
					System.out.println("Digite o id da passagem:");
					id_passagem = s.nextInt();
					s.nextLine();
					System.out.println("Digite a quantidade de passagens:");
					quantidade = s.nextInt();
					s.nextLine();
					System.out.println("Digite a origem de troca:");
					origem = s.nextLine();
					System.out.println("Digite o destino de troca:");
					destino = s.nextLine();
					System.out.println("Digite o valor unitario da passagem:");
					valor_passagem = s.nextDouble();
					s.nextLine();
					System.out.println("Digite o numero do pedido:");
					num_pedido = s.nextInt();
					s.nextLine();
					
					Pedidos pedido2 = pedidoDAO.readById(num_pedido);
					 	
					Passagem passagem2 = new Passagem(id_passagem, quantidade, origem, destino, valor_passagem, pedido2);
					
					passagemDAO.update(passagem2);
					break;
					
					
				case 4:
					System.out.println("Digite o ID da passagem:");
					id_passagem = s.nextInt();
					s.nextLine();
					
					passagemDAO.delete(id_passagem);
					break;
				case 5:
					System.out.println("Digite o ID:");
					id_passagem = s.nextInt();
					s.nextLine();
					
					Passagem passagem3 = passagemDAO.readById(id_passagem);
					
					System.out.println(passagem3.toString());
					break;
				default:
					
					break;
				}
				
			} while (opcao != 0);
			
			System.out.println("Obrigado por utilizar a plataforma da AGENCIA DE VIAGENS");
			s.close();

	

	}

}
