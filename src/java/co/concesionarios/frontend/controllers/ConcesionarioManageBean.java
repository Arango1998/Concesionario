/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistence.entities.Concesionario;
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
@Named(value = "concesionarioManageBean")
@SessionScoped
public class ConcesionarioManageBean implements Serializable {

    
    private Concesionario concesionario;
    @EJB
    private ConcesionarioFacadeLocal concesionarioFacadeLocal;
    /**
     * Creates a new instance of ConcesionarioManageBean
     */
    public ConcesionarioManageBean() {
    
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    @PostConstruct
    
    public void init(){
        
        concesionario = new Concesionario();
    
    }
    
    public void registrarConcesionario(){
    
        concesionarioFacadeLocal.create(concesionario);
    }
    
    public List<Concesionario> listarConcesionario(){
        
        return concesionarioFacadeLocal.findAll();
        
}
    
}
