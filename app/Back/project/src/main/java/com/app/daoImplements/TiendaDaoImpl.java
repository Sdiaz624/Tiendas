package com.app.daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.app.beans.Tienda;
import com.app.dao.TiendaDao;

@Repository
public class TiendaDaoImpl implements TiendaDao{

	
	
	@Autowired
	private DataSource dataSource;	
	
	public void Registrar(String tienda) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Insert INTO tienda(Nombre) values (?)";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,tienda);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}
	}

	public void Actualizar(Tienda tienda) throws Exception {

		String sql = "UPDATE tienda SET nombre = ? WHERE id = ? ";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,tienda.getNombre());
			ps.setInt(2,tienda.getId());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}

		
	}

	public void Eliminar(int tienda) throws Exception {
		
		//ProductoDaoImpl a = new ProductoDaoImpl();
		this.EliminarProductoPorTienda(tienda);
		System.out.println("aja");
		String sql = "DELETE FROM tienda WHERE id = ? ";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,tienda);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		
	}
	
	public void EliminarProductoPorTienda(int tienda) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM producto WHERE tienda = ? ";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,tienda);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}	
	}

	public ArrayList<Tienda> ListarTodas() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
		
		String sql = "SELECT * FROM tienda";
		Connection con= null;
                ResultSet r;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			r = ps.executeQuery();
					
			while (r.next()) {
				
				Tienda tienda = new Tienda();
				
				tienda.setId(r.getInt("ID"));
				tienda.setNombre(r.getString("Nombre"));
				
				tiendas.add(tienda);
			}
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}
				
		return tiendas;

	}
	

}
