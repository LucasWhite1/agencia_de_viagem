package com.agenciadeviagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagens.connection.ConnectionMySQL;
import com.agenciadeviagens.modelos.Passageiros;

public class PassageiroDAO {

	// create
	public void create(Passageiros passageiro) {

		String sql = "insert into passageiro (nome_passageiro, CPF, passaporte, email, telefone) values (?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passageiro.getnome_passageiro());
			pstm.setString(2, passageiro.getCPF());
			pstm.setString(3, passageiro.getPassaporte());
			pstm.setString(4, passageiro.getemail());
			pstm.setString(5, passageiro.getTelefone());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Passageiros> read() {
		List<Passageiros> passageiros = new ArrayList<Passageiros>();
		String sql = "select * from passageiro";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Passageiros passageiro = new Passageiros();

				passageiro.setnome_passageiro(rset.getString("nome_passageiro"));
				passageiro.setCPF(rset.getString("CPF"));
				passageiro.setPassaporte(rset.getString("passaporte"));
				passageiro.setemail(rset.getString("email"));
				passageiro.setTelefone(rset.getString("telefone"));

				passageiros.add(passageiro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return passageiros;
	}

	// update
	public void update(Passageiros passageiro) {
		String sql = "update passageiro set nome_passageiro = ?, passaporte = ?, email = ?, telefone = ? where CPF = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passageiro.getnome_passageiro());
			pstm.setString(2, passageiro.getPassaporte());
			pstm.setString(3, passageiro.getemail());
			pstm.setString(4, passageiro.getTelefone());
			pstm.setString(5, passageiro.getCPF());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(String CPF) {
		String sql = "DELETE FROM Usuarios WHERE CPF = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, CPF);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Passageiros readById(String CPF) {
		Passageiros passageiro = new Passageiros();
		String sql = "select * from passageiro WHERE CPF = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, CPF);

			rset = pstm.executeQuery();

			rset.next();

			passageiro.setCPF(rset.getString("CPF"));
			passageiro.setnome_passageiro(rset.getString("nome_passageiro"));
			passageiro.setPassaporte(rset.getString("passaporte"));
			passageiro.setemail(rset.getString("email"));
			passageiro.setTelefone(rset.getString("telefone"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return passageiro;
	}

}
