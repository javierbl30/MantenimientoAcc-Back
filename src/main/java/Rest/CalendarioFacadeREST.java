/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Control.AbstractFacade;
import Control.CalendarioFacade;
import Entity.Calendario;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


/**
 *
 * @author pedrojv
 */

@Path("calendario")
@RequestScoped

public class CalendarioFacadeREST extends AbstractResource<Calendario> {
    
    @Inject
    protected CalendarioFacade calendarioFacade;
    
    @Override
    protected AbstractFacade<Calendario> entity(){
        return calendarioFacade;
    }
    
    @Override
    protected Calendario nuevo(){
        return new Calendario();
    }
    
    
}
