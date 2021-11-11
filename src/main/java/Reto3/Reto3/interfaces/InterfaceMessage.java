/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3.Reto3.interfaces;

import Reto3.Reto3.Modelo.message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alejandro
 */
public interface InterfaceMessage extends CrudRepository<message, Integer>{
    
}
