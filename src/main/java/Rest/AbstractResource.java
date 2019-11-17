/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Control.AbstractFacade;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pedrojv
 * @param<T>
 */
public abstract class AbstractResource<T> implements Serializable {

    protected abstract AbstractFacade<T> entity();

    protected abstract T nuevo();
    
    /**
     * metodo Post para crear un registro
     *
     * @param entity datos que recibe de la entidad json
     * @return estado CREATED // NOT FOUND error
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(T entity) {

        if (entity != null) {

            try {
                if (entity() != null) {
                    T respuesta = entity().crear(entity);
                    if (respuesta != null) {
                        return Response.status(Response.Status.CREATED).entity(entity).build();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo crear el objeto ", entity).build();
    }

    /**
     * metodo PUT para modificar un registro
     *
     * @param entity datos que recibe de la entidad json
     * @return estado OK // NOT FOUND error
     */
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(T entity) {

        if (entity != null) {

            try {
                if (entity() != null) {
                    T respuesta = entity().editar(entity);
                    if (respuesta != null) {
                        return Response.status(Response.Status.OK).entity(entity).build();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo modificar el objeto ", entity).build();
    }

    /**
     * metodo DELETE para eliminar un registro
     *
     * @param id filtro de busqueda del objeto a eliminar
     * @return estado OK // NOT FOUND error
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id) {
        if (id > 0) {
            try {
                if (entity() != null) {
                    T respuesta = entity().borrar(entity().find(id));
                    if (respuesta != null) {
                        return Response.status(Response.Status.OK).entity(entity().find(id)).build();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("No se pudo eliminar el objeto ", entity().find(id)).build();
    }

    /**
     * metodo para buscar un registro espefico por el id
     *
     * @param id filtro de busqueda
     * @return un registro especifico, estado OK // error NOT FOUND lista vacia
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findById(@QueryParam("id") Integer id) {
        if (id != null) {
            try {
                T salida = entity().find(id);
                if (salida != null) {
                    return Response.status(Response.Status.OK).entity(salida).build();
                } else {
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", Collections.EMPTY_LIST).build();
    }

    /**
     * metodo para contar el total de registro
     *
     * @return total de registro estado OK // error NOT FOUND datos 0
     */
    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Count() {
        if (entity() != null) {
            return Response.ok(entity().count()).header("Total-Registro", entity().count()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", 0).build();
    }

    /**
     * metodo que retorna cantidad de datos
     *
     * @param first inicio de la busqueda
     * @param pagesize cantidad de datos de busqueda
     * @return lista filtrada por rango, estado OK // error NOT FOUND lista
     * vacia
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByRange(@QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("pagesize") @DefaultValue("10") int pagesize) {
        if (first >= 0 && first < pagesize) {
            try {
                List<T> lista = entity().findRange(first, pagesize);
                if (lista != null) {
                    return Response.ok(lista).header("Access-Control-Allow-Origin","*").header("Total-Registros", entity().count()).build();
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", Collections.EMPTY_LIST).build();
    }
}