/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.utilities.converter;

import javax.faces.convert.FacesConverter;
import co.concesionario.backend.persistence.entities.Concesionario;

/**
 *
 * @author camila
 */
@FacesConverter(forClass = Concesionario.class)

public class ConcesionarioConverter extends AbstractConverter {
    
     public ConcesionarioConverter() {
        
        this.nameManagedBean="ConcesionarioManagedBean";
    
    }
    
}
