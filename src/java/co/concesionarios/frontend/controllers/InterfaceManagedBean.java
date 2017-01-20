/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.concesionarios.frontend.controllers;

import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface InterfaceManagedBean<T> {
    
   T getObjetoByKey (Integer id);
    
}
