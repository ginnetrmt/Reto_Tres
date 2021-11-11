/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.repositorio;

import Reto3.Reto3.Modelo.partyroom;
import Reto3.Reto3.interfaces.InterfacePartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Alejandro
 */
@Repository
public class RepositorioPartyroom {
    
    @Autowired
    
    private InterfacePartyroom crud;
    
    public List<partyroom> getAll(){
        return (List<partyroom>) crud.findAll();
    }
    
    public Optional <partyroom> getPartyroom(int id){
        return crud.findById(id);
    }
    
    public partyroom save(partyroom partyroom){
        return crud.save(partyroom);
    }
    
    public void delete(partyroom partyroom){
        crud.delete(partyroom);
    }
    
}
