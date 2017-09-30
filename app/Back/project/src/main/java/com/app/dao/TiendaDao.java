package com.app.dao;
import java.util.ArrayList;
import com.app.beans.Tienda;

public interface TiendaDao {
	
	public void Registrar(String tienda) throws Exception; 
	
	public void Actualizar(Tienda tienda) throws Exception;
	
	public void Eliminar(int tienda) throws Exception;
	
	public ArrayList<Tienda> ListarTodas()throws Exception;
	
	
}
