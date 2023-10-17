package com.agenciadeviagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagens.connection.ConnectionMySQL;
import com.agenciadeviagens.modelos.Passagem;
import com.agenciadeviagens.modelos.Pedidos;

public class PassagemDAO {

	// create
	public void create(Passagem passagem) {

		String sql = "insert into passagem (id_passagem, quantidade, origem, destino,num_pedido, valor_passagem) values (?, ?, ? , ? , ? , ? )";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, passagem.getId_passagem());
			pstm.setInt(2, passagem.getQuantidade());
			pstm.setString(3, passagem.getOrigem());
			pstm.setString(4, passagem.getDestino());
			pstm.setInt(5, passagem.getPedido().getNum_pedido());
			pstm.setDouble(6, passagem.getValor_passagem());

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
	public List<Passagem> read() {
		List<Passagem> Passagem = new ArrayList<Passagem>();
		String sql = "select * from passagem";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagem passagem = new Passagem();
				Pedidos pedido = new Pedidos();

				passagem.setId_passagem(rset.getInt("id_passagem"));
				passagem.setQuantidade(rset.getInt("quantidade"));
				passagem.setOrigem(rset.getString("origem"));
				passagem.setDestino(rset.getString("destino"));
				passagem.setValor_passagem(rset.getDouble("valor_passagem"));
				
				pedido.setNum_pedido(rset.getInt("num_pedido"));
				
				passagem.setPedido(pedido);

				Passagem.add(passagem);
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

		return Passagem;
	}

	// update
	public void update(Passagem passagem) {
		String sql = "UPDATE passagem SET quantidade = ?, origem = ?, destino = ?, valor_passagem = ?, num_pedido = ? WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			
			pstm.setInt(1, passagem.getQuantidade());
			pstm.setString(2, passagem.getOrigem());
			pstm.setString(3, passagem.getDestino());
			pstm.setDouble(4, passagem.getValor_passagem());
			pstm.setInt(5, passagem.getPedido().getNum_pedido());
			pstm.setInt(6, passagem.getId_passagem());

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
	public void delete(int id_passagem) {
		String sql = "DELETE FROM passagem WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_passagem);

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
	public Passagem readById(int id_passagem) {
		Passagem passagem = new Passagem();
		Pedidos pedido = new Pedidos();
		String sql = "select * from passagem WHERE id_passagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_passagem);

			rset = pstm.executeQuery();

			rset.next();

			passagem.setId_passagem(rset.getInt("id_passagem"));
			passagem.setQuantidade(rset.getInt("quantidade"));
			passagem.setOrigem(rset.getString("origem"));
			passagem.setDestino(rset.getString("destino"));
			passagem.setValor_passagem(rset.getDouble("valor_passagem"));
			
			pedido.setNum_pedido(rset.getInt("num_pedido"));

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
		return passagem;
	}

}
