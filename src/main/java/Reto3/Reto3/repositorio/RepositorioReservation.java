/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.repositorio;

import Reto3.Reto3.Modelo.reservation;
import Reto3.Reto3.interfaces.InterfaceReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandro
 */
@Repository
public class RepositorioReservation {
    @Autowired
    private InterfaceReservation crud4;
    
    public List<reservation> getAll(){
        return (List<reservation>) crud4.findAll();
    }
    
    public Optional <reservation> getreservation(int id){
        return crud4.findById(id);
    }
    
    public reservation save(reservation reservation){
        return crud4.save(reservation);
    }  
    
    public void delete(reservation reservation){
        crud4.delete(reservation);
    }
}