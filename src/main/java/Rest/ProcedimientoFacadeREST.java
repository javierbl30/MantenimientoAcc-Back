/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Control.AbstractFacade;
import Control.ProcedimientoFacade;
import Entity.Procedimiento;
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

@Path("procedimiento")
@RequestScoped
public class ProcedimientoFacadeREST extends AbstractResource<Procedimiento> {

    @Inject
    protected ProcedimientoFacade procedimientoFacade;
    
    @Override
    protected AbstractFacade<Procedimiento> entity(){
        return procedimientoFacade;
    }
    
    @Override
    protected Procedimiento nuevo(){
        return new Procedimiento();
    }
    
}
