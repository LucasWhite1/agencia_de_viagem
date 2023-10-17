package com.agenciadeviagens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenciadeviagens.connection.ConnectionMySQL;
import com.agenciadeviagens.modelos.Passageiros;
import com.agenciadeviagens.modelos.Pedidos;

public class PedidosDAO {

	// create
	public void create(Pedidos pedido) {

		String sql = "insert into pedido (dt_pedido, forma_pgmto, CPF) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pedido.getDt_pedido());
			pstm.setString(2, pedido.getForma_pgmto());
			pstm.setString(3, pedido.getPassageiro().getCPF());

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
	public List<Pedidos> read() {
		List<Pedidos> Pedido = new ArrayList<Pedidos>();
		String sql = "select * from pedido";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Pedidos pedido = new Pedidos();
				Passageiros passageiro = new Passageiros();

				pedido.setNum_pedido(rset.getInt("num_pedido"));
				pedido.setDt_pedido(rset.getString("dt_pedido"));
				pedido.setForma_pgmto(rset.getString("forma_pgmto"));

				passageiro.setCPF(rset.getString("CPF"));

				pedido.setPassageiro(passageiro);

				Pedido.add(pedido);
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

		return Pedido;
	}

	// update
	public void update(Pedidos pedido) {
		String sql = "UPDATE pedido SET dt_pedido = ?, forma_pgmto = ?, CPF = ? WHERE num_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pedido.getDt_pedido());
			pstm.setString(2, pedido.getForma_pgmto());
			pstm.setString(3, pedido.getPassageiro().getCPF());
			pstm.setInt(4, pedido.getNum_pedido());

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
	public void delete(int num_pedido) {
		String sql = "DELETE FROM pedido WHERE num_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, num_pedido);

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
	public Pedidos readById(int num_pedido) {
		Pedidos pedido = new Pedidos();
		Passageiros passageiro = new Passageiros();

		String sql = "select * from pedido WHERE num_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, num_pedido);

			rset = pstm.executeQuery();

			rset.next();

			pedido.setNum_pedido(rset.getInt("num_pedido"));
			pedido.setDt_pedido(rset.getString("dt_pedido"));
			pedido.setForma_pgmto(rset.getString("forma_pgmto"));

			passageiro.setCPF(rset.getString("CPF"));

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
		return pedido;
	}

}
