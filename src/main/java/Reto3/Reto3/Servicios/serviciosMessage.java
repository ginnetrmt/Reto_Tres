/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.Servicios;

import Reto3.Reto3.Modelo.message;
import Reto3.Reto3.repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
public class serviciosMessage {
          
    @Autowired
    private RepositorioMessage metodosCrud;
    
    public List<message> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<message> getmessage(int id){
        return metodosCrud.getmessage(id);
    }
    
    public message save(message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<message> evt=metodosCrud.getmessage(message.getIdMessage());
            if(evt.isEmpty()){
            return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    
    public message update(message message){
        if(message.getIdMessage()!=null) {
            Optional<message> evt=metodosCrud.getmessage(message.getIdMessage());
            if(!evt.isEmpty()){
                if(message.getMessageText()!=null){
                    evt.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return message;
            }
        }else{
             return message;
        }
    }

    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getmessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}