/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.repositorio;

import Reto3.Reto3.Modelo.client;
import Reto3.Reto3.interfaces.InterfaceClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandro
 */
@Repository
public class RepositorioClient {
    
    @Autowired
    
    private InterfaceClient crud1;
    
    public List<client> getAll(){
        return (List<client>) crud1.findAll();
    }
    
    public Optional <client> getclient(int id){
        return crud1.findById(id);
    }
    
    public client save(client client){
        return crud1.save(client);
    }

    public void delete(client client){
        crud1.delete(client);
    }
    
}