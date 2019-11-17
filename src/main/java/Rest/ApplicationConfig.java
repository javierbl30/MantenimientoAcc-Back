/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author pedrojv
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Rest.CalendarioFacadeREST.class);
        resources.add(Rest.CorsFilter.class);
        resources.add(Rest.HerramientasFacadeREST.class);
        resources.add(Rest.InventarioFacadeREST.class);
        resources.add(Rest.MaterialesFacadeREST.class);
        resources.add(Rest.OrdencompraFacadeREST.class);
        resources.add(Rest.OrdentrabajoFacadeREST.class);
        resources.add(Rest.PasosFacadeREST.class);
        resources.add(Rest.PemFacadeREST.class);
        resources.add(Rest.ProcedimientoFacadeREST.class);
        resources.add(Rest.ProcedimientosmantenimientoFacadeREST.class);
        resources.add(Rest.ProveedoresFacadeREST.class);
        resources.add(Rest.RolFacadeREST.class);
        resources.add(Rest.SolicitudordentrabajoFacadeREST.class);
        resources.add(Rest.StatusFacadeREST.class);
        resources.add(Rest.UsuariosFacadeREST.class);
    }
    
}
