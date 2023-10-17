package com.agenciadeviagens.crud;

import java.util.Scanner;

import com.agenciadeviagens.dao.PassageiroDAO;
import com.agenciadeviagens.modelos.Passageiros;

public class PassageirosCRUD {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		PassageiroDAO passageiroDAO = new PassageiroDAO();

		int opcao = 0;

		String nome_passageiro = "", CPF = "", passaporte = "", email = "", telefone = "";

		do {

			System.out.println("\n=========== BEM VINDO A PAGINA DE PASSAGEIROS DA AGENCIA DE VIAGENS ==============\n");
			System.out.println("\n====================== SELECIONE UMA OPCAO ABAIXO =====================\n");
			System.out.println("(1)CADASTRAR   (2)CONSULTAR   (3)ATUALIZAR   (4)DELETAR   (5)CONSULTAR POR CPF  (0)SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o Nome:");
				nome_passageiro = s.nextLine();
				System.out.println("Digite o CPF:");
				CPF = s.nextLine();
				System.out.println("Digite o Passaporte:");
				passaporte = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite a telefone:");
				telefone = s.nextLine();

				System.out.println("================ PASSAGEIRO CADASTRADO ================");

				Passageiros passageiro1 = new Passageiros(nome_passageiro, CPF, passaporte, email, telefone);

				passageiroDAO.create(passageiro1);
				break;

			case 2:

				for (Passageiros u : passageiroDAO.read()) {
					System.out.println(u.toString());
				}

				break;
			case 3:

				System.out.println("Digite o CPF:");
				CPF = s.nextLine();
				System.out.println("Digite o nome:");
				nome_passageiro = s.nextLine();
				System.out.println("Digite o Passaporte:");
				passaporte = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite a telefone:");
				telefone = s.nextLine();

				Passageiros passageiro2 = new Passageiros(CPF, nome_passageiro, passaporte, email, telefone);

				passageiroDAO.update(passageiro2);
				break;

			case 4:
				System.out.println("Digite um CPF:");
				CPF = s.nextLine();
				s.nextLine();

				passageiroDAO.delete(CPF);
				break;
			case 5:
				System.out.println("Digite um CPF:");
				CPF = s.nextLine();
				s.nextLine();

				Passageiros passageiro3 = passageiroDAO.readById(CPF);

				System.out.println(passageiro3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Obrigado por utilizar a plataforma da Agencia de Viagens");
		s.close();

	}

}
