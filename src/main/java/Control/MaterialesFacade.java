/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Materiales;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class MaterialesFacade extends AbstractFacade<Materiales> {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_mantenimiento-acc_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterialesFacade() {
        super(Materiales.class);
    }
    
}
