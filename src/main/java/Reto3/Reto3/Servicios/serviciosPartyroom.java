/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.Servicios;

import Reto3.Reto3.Modelo.partyroom;
import Reto3.Reto3.repositorio.RepositorioPartyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
public class serviciosPartyroom {
    
    @Autowired
    
    private RepositorioPartyroom metodosCrud;
    
    public List<partyroom> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<partyroom> getpartyroom(int partyroomId){
        return metodosCrud.getPartyroom(partyroomId);
    }
    
    public partyroom save(partyroom partyroom){
        if(partyroom.getId()==null){
            return metodosCrud.save(partyroom);
        }else{
            Optional<partyroom> evt=metodosCrud.getPartyroom(partyroom.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }
    
    public partyroom update(partyroom partyroom){
        if(partyroom.getId()!=null) {
            Optional<partyroom> evt=metodosCrud.getPartyroom(partyroom.getId());
            if(!evt.isEmpty()){
                if(partyroom.getName()!=null){
                    evt.get().setName(partyroom.getName());
                }
                if(partyroom.getOwner()!=null) {
                   evt.get().setOwner(partyroom.getOwner());
                }
                if(partyroom.getCapacity()!=null) {
                    evt.get().setCapacity(partyroom.getCapacity());
                }
                if(partyroom.getDescription()!=null) {
                    evt.get().setDescription(partyroom.getDescription());
                } 
                if(partyroom.getCategory()!=null){
                    evt.get().setCategory(partyroom.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return partyroom;
            }
        }else{
             return partyroom;
        }
    }

    public boolean deletePartyroom(int partyroomId){
        Boolean aBoolean = getpartyroom(partyroomId).map(partyroom -> {
            metodosCrud.delete(partyroom);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}