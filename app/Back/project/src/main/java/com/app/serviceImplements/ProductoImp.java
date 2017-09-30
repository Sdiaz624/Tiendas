package com.app.serviceImplements;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.beans.Producto;
import com.app.dao.ProductoDao;
import com.app.service.ProductoService;

public class ProductoImp implements ProductoService  {

	
	public void setDaoProducto(ProductoDao daoProducto) {
		this.daoProducto = daoProducto;
	}

	private ProductoDao daoProducto;
	
	public void Registrar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
	    try {
	    	daoProducto.Registrar(producto);
		}catch(Exception e){
			throw e;
		}
	}

	public void Actualizar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		try {
	    	daoProducto.Actualizar(producto);
		}catch(Exception e){
			throw e;
		}
	}

	public void Eliminar(int producto) throws Exception {
		// TODO Auto-generated method stub
		try {
	    	daoProducto.Eliminar(producto);
		}catch(Exception e){
			throw e;
		}
	}

		

	public ArrayList<Producto> ListarTodas(int tienda) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		try {
			productos = daoProducto.ListarTodas(tienda);
		}catch(Exception e){
			throw e;
		}
		return productos;
		
	}

}
