package com.app.serviceImplements;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.beans.Tienda;
import com.app.dao.TiendaDao;
import com.app.service.TiendaService;

@Service
public class TiendaImp implements TiendaService{
	

	public void setDaoTienda(TiendaDao daoTienda) {
		this.daoTienda = daoTienda;
	}

	private TiendaDao daoTienda;
	
	public void Registrar(String tienda) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("rt");
		try {
			daoTienda.Registrar(tienda);
		}catch(Exception e){
			throw e;
		}
		
	}

	public void Actualizar(Tienda tienda) throws Exception {
		// TODO Auto-generated method stub
		try {
			daoTienda.Actualizar(tienda);
		}catch(Exception e){
			throw e;
		}
	}

	public void Eliminar(int tienda) throws Exception {
		// TODO Auto-generated method stub
		try {
			daoTienda.Eliminar(tienda);
		}catch(Exception e){
			throw e;
		}
	}

	public ArrayList<Tienda> ListarTodas() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("entrooen listartodas");
		ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
		
		try {
			tiendas = daoTienda.ListarTodas();
		}catch(Exception e){
			throw e;
		}
		return tiendas;
	}
	
}
