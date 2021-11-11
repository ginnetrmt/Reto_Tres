/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.repositorio;

import Reto3.Reto3.Modelo.category;
import Reto3.Reto3.interfaces.InterfaceCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandro
 */
@Repository
public class RepositorioCategory {
    
    @Autowired
    
    private InterfaceCategory crud;
    
    public List<category> getAll(){
        return (List<category>) crud.findAll();
    }
    
    public Optional <category> getcategory(int id){
        return crud.findById(id);
    }
    
    public category save(category category){
        return crud.save(category);
    }
    
    public void delete(category category){
        crud.delete(category);
    }
}