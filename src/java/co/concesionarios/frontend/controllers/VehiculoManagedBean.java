/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistence.entities.Vehiculo;
import co.concesionarios.backend.persistence.facades.VehiculoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author camila
 */
@Named(value = "VehiculoManagedBean")
@Dependent
public class VehiculoManagedBean {

    private Vehiculo vehiculo;
    @EJB
    private VehiculoFacadeLocal vehiculoFacadeLocal;
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public VehiculoManagedBean() {
        
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    @PostConstruct
    
    public void init(){
        
        vehiculo = new Vehiculo();
    }
    
    public void registrarVehiculo(){
    
        vehiculoFacadeLocal.create(vehiculo);
        
    }
    
    public void eliminarVehiculo(){
    
        vehiculoFacadeLocal.remove(vehiculo);
    }
    
    public List<Vehiculo> listarVehiculo(){
    
        return vehiculoFacadeLocal.findAll();
    
    }
}
