/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistence.entities.Concesionario;
import co.concesionario.backend.persistence.entities.Vehiculo;
import co.concesionarios.backend.persistence.facades.ConcesionarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author camila
 */
@Named(value = "ConcesionarioManagedBean")
@SessionScoped
public class ConcesionarioManagedBean implements Serializable {

    
    private Concesionario concesionario;
    private Vehiculo vehiculo;
    @EJB private ConcesionarioFacadeLocal concesionarioFacadeLocal;
    /**
     * Creates a new instance of ConcesionarioManageBean
     */
    public ConcesionarioManagedBean() {
    
    }

    @PostConstruct
    
    public void init(){
        
        concesionario = new Concesionario();
        vehiculo = new Vehiculo();
    
    }
    
      public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
   
     public void registrarConcesionario(){       
        concesionarioFacadeLocal.create(concesionario);
    }
    
    public void eliminarConcesionario(Concesionario c){
        concesionarioFacadeLocal.remove(c);
    }
    
    public List<Concesionario> listaConcesionario(){
        return concesionarioFacadeLocal.findAll();
    }
    
    public void editarConcesionario(Concesionario c){
        concesionarioFacadeLocal.edit(c);
    }

}
