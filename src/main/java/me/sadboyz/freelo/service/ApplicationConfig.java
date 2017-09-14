/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sadboyz.freelo.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Usuario
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
        resources.add(me.sadboyz.freelo.service.ApplicationsFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.ClaimFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.ComplainFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.ProfileFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.RewardFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.TransactionFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.UserFacadeREST.class);
        resources.add(me.sadboyz.freelo.service.WorkFacadeREST.class);
    }
    
}
