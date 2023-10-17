package com.agenciadeviagens.modelos;

public class Passageiros {
	
	//atributos
	private String nome_passageiro;
	private String CPF;
	private String passaporte;
	private String email;
	private String telefone;
	
	
	//construtor
	public Passageiros() {
	}


	public Passageiros(String nome_passageiro, String cPF, String passaporte,String email, String telefone) {
		this.nome_passageiro = nome_passageiro;
		CPF = cPF;
		this.passaporte = passaporte;
		this.email = email;
		this.telefone = telefone;
	}


	public Passageiros(String nome_passageiro, String passaporte,String email, String telefone) {
		this.nome_passageiro = nome_passageiro;
		this.passaporte = passaporte;
		this.email = email;
		this.telefone = telefone;
	}

	
	
	//getters e setters
	public String getnome_passageiro() {
		return nome_passageiro;
	}


	public void setnome_passageiro(String nome_passageiro) {
		this.nome_passageiro = nome_passageiro;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getPassaporte() {
		return passaporte;
	}


	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	
	public String getemail() {
		return email;
	}


	public void setemail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	//tostring
	
	@Override
	public String toString() {
		return "Passageiros [nome_passageiro=" + nome_passageiro + ", CPF=" + CPF + ", passaporte=" + passaporte + ", email=\" + email + \", telefone=" + telefone
				+ "]";
	}
	
	

}
