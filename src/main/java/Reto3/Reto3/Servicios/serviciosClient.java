/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.Servicios;

import Reto3.Reto3.Modelo.client;
import Reto3.Reto3.repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
public class serviciosClient {
          
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<client> getclient(int id){
        return metodosCrud.getclient(id);
    }
    
    public client save(client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<client> evt=metodosCrud.getclient(client.getIdClient());
            if(evt.isEmpty()){
            return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    
    public client update(client client){
        if(client.getIdClient()!=null) {
            Optional<client> evt=metodosCrud.getclient(client.getIdClient());
            if(!evt.isEmpty()){
                if(client.getEmail()!=null){
                    evt.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null) {
                   evt.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null) {
                   evt.get().setName(client.getName());
                }
                if(client.getAge()!=null) {
                   evt.get().setAge(client.getAge());
                }                
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return client;
            }
        }else{
             return client;
        }
    }

    public boolean deleteClient(int clientId){
        Boolean aBoolean = getclient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}