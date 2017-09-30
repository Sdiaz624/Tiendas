package com.app.service;
import java.util.ArrayList;
import com.app.beans.Producto;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/Producto")
public interface ProductoService {

        @POST
        @Path("/Producto/registrar")
        @Consumes({"application/json;charset=UTF-8"})
	public void Registrar(Producto producto) throws Exception; 
	
        @POST
        @Path("/Producto/actualizar")
        @Consumes({"application/json;charset=UTF-8"})
	public void Actualizar(Producto producto) throws Exception;
	
        @GET
        @Path("/Producto/eliminar/{producto}")
	public void Eliminar(@PathParam("producto") int producto) throws Exception;
	        	
        @GET
        @Path("/Producto/consulta/{tienda}")
        @Produces({"application/json;charset=UTF-8"})
   	public ArrayList<Producto> ListarTodas(@PathParam("tienda") int tienda) throws Exception;
	
}
