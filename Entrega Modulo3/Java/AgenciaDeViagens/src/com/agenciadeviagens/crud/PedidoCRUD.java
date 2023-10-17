package com.agenciadeviagens.crud;

import java.util.Scanner;
import com.agenciadeviagens.dao.PassageiroDAO;
import com.agenciadeviagens.dao.PedidosDAO;
import com.agenciadeviagens.modelos.Passageiros;
import com.agenciadeviagens.modelos.Pedidos;

public class PedidoCRUD {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		PedidosDAO pedidoDAO = new PedidosDAO();
		PassageiroDAO passageiroDAO = new PassageiroDAO();

		int opcao = 0, num_pedido = 0;

		String CPF = "";
		String dt_pedido = "";
		String forma_pgmto = "";
		
		System.out.println("\n=========== BEM VINDO A PAGINA DE PEDIDOS DA AGENCIA DE VIAGENS==============\n");

		do {

			
			System.out.println("\n====================== SELECIONE UMA OPCAO ABAIXO =====================\n");
			System.out.println("1-REALIZAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:

				System.out.println("Digite a data da viagem:");
				dt_pedido = s.nextLine();
				System.out.println("Digite a forma de pagamento:");
				forma_pgmto = s.nextLine();
				System.out.println("Digite o CPF:");
				CPF = s.nextLine();
				
				System.out.println("================ PEDIDO REALIZADO ================");

				Passageiros passageiro1 = passageiroDAO.readById(CPF);

				Pedidos pedido1 = new Pedidos(dt_pedido, forma_pgmto, passageiro1);

				pedidoDAO.create(pedido1);

				break;
			case 2:

				for (Pedidos u : pedidoDAO.read()) {

					System.out.println(u.toString());

				}

				break;
			case 3:
				System.out.println("Digite o numero do pedido:");
				num_pedido = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data do pedido:");
				dt_pedido = s.nextLine();
				System.out.println("Digite a forma de pagamento:");
				forma_pgmto = s.nextLine();
				System.out.println("Digite o CPF do passageiro:");
				CPF = s.nextLine();

				Passageiros passageiro2 = passageiroDAO.readById(CPF);

				Pedidos pedido2 = new Pedidos(num_pedido, dt_pedido, forma_pgmto, passageiro2);

				pedidoDAO.update(pedido2);

				break;
			case 4:
				System.out.println("Digite o numero do pedido:");
				num_pedido = s.nextInt();
				s.nextLine();

				pedidoDAO.delete(num_pedido);
				break;
			case 5:
				System.out.println("Digite o numero do pedido:");
				num_pedido = s.nextInt();
				s.nextLine();

				Pedidos pedido3 = pedidoDAO.readById(num_pedido);

				System.out.println(pedido3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}

		} while (opcao != 0);

		System.out.println("Obrigado por utilizar a plataforma da AGENCIA DE VIAGENS");
		s.close();

	}

}
