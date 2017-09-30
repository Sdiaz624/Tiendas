package com.app.config;
import com.app.dao.ProductoDao;
import com.app.dao.TiendaDao;
import com.app.daoImplements.ProductoDaoImpl;
import com.app.daoImplements.TiendaDaoImpl;
import com.app.service.ProductoService;
import com.app.service.TiendaService;
import com.app.serviceImplements.ProductoImp;
import com.app.serviceImplements.TiendaImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	
	
	@Bean
	public ProductoDao ProductoBeanDao() {
		return new ProductoDaoImpl();
	}
	
	@Bean
	public TiendaDao TiendaBeanDao() {
		
		return new TiendaDaoImpl();
	}
	
	@Bean
	public ProductoService ProductoBean() {
		
		ProductoImp productImpl = new ProductoImp();
		productImpl.setDaoProducto(ProductoBeanDao());
		return productImpl;
	}
	
	@Bean
	public TiendaService TiendaBean() {
		
		TiendaImp tiendaImpl = new TiendaImp();
		tiendaImpl.setDaoTienda(TiendaBeanDao());
		System.out.println("entro poraqui");
		return tiendaImpl;
	}
	
}
