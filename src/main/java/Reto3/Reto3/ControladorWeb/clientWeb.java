/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.ControladorWeb;

import Reto3.Reto3.Modelo.client;
import Reto3.Reto3.Servicios.serviciosClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class clientWeb {
    @Autowired
    private serviciosClient servicios;
    @GetMapping("/all")
    public List <client> getclient(){
       return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<client> getclient(@PathVariable("id") int idClient) {
        return servicios.getclient(idClient);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public client save(@RequestBody client client){
        return servicios.save(client);
    }
    
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public client update(@RequestBody client client){
        return servicios.update(client);
    }
    
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId){
        return servicios.deleteClient(clientId);
    }

}