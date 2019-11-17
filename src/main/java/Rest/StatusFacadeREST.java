/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Control.AbstractFacade;
import Control.StatusFacade;
import Entity.Status;
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

@Path("status")
@RequestScoped
public class StatusFacadeREST extends AbstractResource<Status> {

    @Inject
    protected StatusFacade statusFacade;
    
    @Override
    protected AbstractFacade<Status> entity(){
        return statusFacade;
    }
    
    @Override
    protected Status nuevo(){
        return new Status();
    }
    
}
