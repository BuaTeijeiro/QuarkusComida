package edu.badpals;

import edu.badpals.domain.Encargo;
import edu.badpals.domain.Item;
import edu.badpals.domain.Mago;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.validation.Valid;
import java.util.List;

@Path("/")
public class Resource {

    @Inject
    Service service;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from the store";
    }

    @GET
    @Path("item/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showItem(@PathParam("nombre") String nombre){
        Item item = service.cargaItem(nombre);
        return item.getNombre() == null  ? 
                Response.status(Response.Status.NOT_FOUND).entity("No existe el objeto").build() :
                Response.status(Response.Status.OK).entity(item).build();
    }

    @GET
    @Path("/item/{nombre}/quality")
    @Produces(MediaType.TEXT_PLAIN)
    public Response showQuality(@PathParam("nombre") String nombre){
        Item item = service.cargaItem(nombre);
        return item.getNombre() == null  ? 
                Response.status(Response.Status.NOT_FOUND).entity("No existe el objeto").build() :
                Response.status(Response.Status.OK).entity(item.quality).build();
    }

    @GET
    @Path("mago/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showMago(@PathParam("nombre") String nombre){
        Mago mago = service.cargaMago(nombre);
        return mago.getNombre() == null  ? 
                Response.status(Response.Status.NOT_FOUND).entity("No existe el mago").build() :
                Response.status(Response.Status.OK).entity(mago).build();
    }

    @GET
    @Path("pedidos/{mago}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showEncargos(@PathParam("mago") String nombre){
        List<Encargo> encargos = service.encargos(nombre);
        return encargos.isEmpty() ?
            Response.status(Response.Status.NOT_FOUND).entity("El mago no tiene encargos").build() :
            Response.status(Response.Status.OK).entity(encargos).build();
    }
        
    //curl -d '{"codigo":"3","mago":"Harry Potter", "item":"Arroz"}' -H "Content-Type: application/json" -X POST http://localhost:8080/pedidos/nuevo -v
    @POST
    @Path("pedidos/nuevo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response post(@Valid Encargo encargo){
        Encargo newEncargo = service.registrarEncargo(encargo);
        return newEncargo == null ?
            Response.status(Response.Status.NOT_FOUND).entity("No se pudo realizar el encargo").build() :
            Response.status(Response.Status.OK).entity(newEncargo).build();

    }
    



}
