package com.app.service;
import java.util.ArrayList; 
import com.app.beans.Tienda;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

@Path("/Tienda")
public interface TiendaService {

        @GET
        @Path("/Tienda/registrar/{tienda}")
        @Consumes("text/plain")
        public void Registrar(@PathParam("tienda") String tienda) throws Exception; 
	
        @POST
        @Path("/Tienda/actualizar")
        @Consumes({"application/json;charset=UTF-8"})
	public void Actualizar(Tienda tienda) throws Exception;
	
        @GET
        @Path("/Tienda/eliminar/{tienda}")
        public void Eliminar(@PathParam("tienda") int tienda) throws Exception;
	        
        @GET
        @Path("/Tienda/consulta")
        @Produces({"application/json;charset=UTF-8"})
        public ArrayList<Tienda> ListarTodas()throws Exception;
				
}
