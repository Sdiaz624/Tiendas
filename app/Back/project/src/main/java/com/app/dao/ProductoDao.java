package com.app.dao;
import java.util.ArrayList;
import com.app.beans.Producto;

public interface ProductoDao {

	public void Registrar(Producto producto) throws Exception; 
	
	public void Actualizar(Producto producto) throws Exception;
	
	public void Eliminar(int producto) throws Exception;
	
	public ArrayList<Producto> ListarTodas(int tienda) throws Exception;
}
