/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistence.entities.Concesionario;
import co.concesionario.backend.persistence.entities.Vehiculo;
import co.concesionarios.backend.persistence.facades.VehiculoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author camila
 */
@Named(value = "VehiculoManagedBean")
@SessionScoped
public class VehiculoManagedBean implements Serializable, InterfaceManagedBean<Vehiculo>{

    private Vehiculo vehiculo;
    private Concesionario concesionario;
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

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
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
    
    public List<Vehiculo> listaVehiculo(){
    
        return vehiculoFacadeLocal.findAll();
    
    }

     @Override
    public Vehiculo getObjetoByKey(Integer id) {
      
        return vehiculoFacadeLocal.find(id);
        
    }
       public String redireccionarVehiculo(){
       
           
        return "listarVehiculo";
    }
       
       public String redireccionarEditar(){
       
           return "editarVehiculo";
       
       }
       
       public String redirCrearTorneo(){
       
       return "crearVehiculo";
       }
}
