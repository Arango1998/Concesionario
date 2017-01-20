
package co.concesionarios.frontend.controllers;

import co.concesionario.backend.persistence.entities.Concesionario;
import co.concesionarios.backend.persistence.facades.ConcesionarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author camila
 */
@Named
@ViewScoped
public class IndexController implements Serializable {
    
   @EJB 
    private ConcesionarioFacadeLocal EJBconcesionario;
    private Concesionario concesionario;
    
    @PostConstruct
    public void init(){
    
        concesionario = new Concesionario();
    
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    
    public String iniciarSesion(){
        Concesionario con;
        String redireccion = null;
        
        try {
           con = EJBconcesionario.iniciarSesion(concesionario);
            if (con != null){
            redireccion = "welcomePrimefaces";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Valores Incorrectos"));

            }
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error"));
        }
    return redireccion;
    }
}
