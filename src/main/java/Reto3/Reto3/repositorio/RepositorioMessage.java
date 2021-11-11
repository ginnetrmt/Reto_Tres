/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.repositorio;

import Reto3.Reto3.Modelo.message;
import Reto3.Reto3.interfaces.InterfaceMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandro
 */
@Repository
public class RepositorioMessage {
    @Autowired
    private InterfaceMessage crud2;
    
    public List<message> getAll(){
        return (List<message>) crud2.findAll();
    }
    
    public Optional <message> getmessage(int id){
        return crud2.findById(id);
    }
    
    public message save(message message){
        return crud2.save(message);
    }
    
    public void delete(message message){
        crud2.delete(message);
    }

}
