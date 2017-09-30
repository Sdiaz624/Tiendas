package com.app.daoImplements;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.beans.Producto;
import com.app.dao.ProductoDao;

@Repository
public class ProductoDaoImpl implements ProductoDao{

	@Autowired
	private DataSource dataSource;	
	
	public void Registrar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Insert INTO Producto(Nombre,Descripcion,Precio,Tienda) values (?,?,?,?)";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,producto.getNombre());
			ps.setString(2,producto.getDescripcion());
			ps.setInt(3,producto.getPrecio());
			ps.setInt(4,producto.getTienda());
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

	public void Actualizar(Producto producto) throws Exception {

		String sql = "UPDATE Producto SET Nombre = ?, Descripcion = ?, Precio = ?, Tienda = ? WHERE ID = ?";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,producto.getNombre());
			ps.setString(2,producto.getDescripcion());
			ps.setInt(3,producto.getPrecio());
			ps.setInt(4,producto.getTienda());
			ps.setInt(5,producto.getId());
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

	public void Eliminar(int producto) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM producto WHERE id = ? ";
		Connection con= null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,producto);
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

	public ArrayList<Producto> ListarTodas(int tienda) throws Exception {

		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		String sql = "SELECT * FROM producto WHERE tienda = ?";
		Connection con= null;
        ResultSet r;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,tienda);
            r = ps.executeQuery();
						
			while (r.next()) {
				
				Producto producto = new Producto();
								
				producto.setId(r.getInt("ID"));
				producto.setNombre(r.getString("Nombre"));
				producto.setDescripcion(r.getString("Descripcion"));
				producto.setPrecio(r.getInt("Precio"));
				producto.setTienda(r.getInt("tienda"));
				
				productos.add(producto);
			}
			ps.close();
		}catch(Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}
				
		return productos;
	}



	
}
