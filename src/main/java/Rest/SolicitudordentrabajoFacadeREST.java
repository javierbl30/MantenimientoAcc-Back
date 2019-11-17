/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Control.AbstractFacade;
import Control.SolicitudordentrabajoFacade;
import Entity.Solicitudordentrabajo;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pedrojv
 */

@Path("solicitudordentrabajo")
@RequestScoped
public class SolicitudordentrabajoFacadeREST extends AbstractResource<Solicitudordentrabajo> {

    @Inject
    protected SolicitudordentrabajoFacade solictraFacade;
    
    @Override
    protected AbstractFacade<Solicitudordentrabajo> entity(){
        return solictraFacade;
    }
    
    @Override
    protected Solicitudordentrabajo nuevo(){
        return new Solicitudordentrabajo();
    }
    
}
