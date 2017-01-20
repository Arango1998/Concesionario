/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.utilities.converter;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import co.concesionarios.frontend.controllers.InterfaceManagedBean;
import co.concesionario.backend.persistence.entities.DTO;

/**
 *
 * @author camila
 */
public class AbstractConverter implements Converter{
    protected String nameManagedBean;

   @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer k = Integer.valueOf(value);
        InterfaceManagedBean omb = (InterfaceManagedBean) context.getApplication().getELResolver().getValue(
                context.getELContext(), null, nameManagedBean);
        
        return omb.getObjetoByKey(k);
        }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if( value instanceof DTO){
            DTO to = (DTO) value;
            return to.getPrimaryKey();
        }
        context.addMessage(null, new FacesMessage("Error al convertir el objeto"));
        return null;
    }

  
    
}
