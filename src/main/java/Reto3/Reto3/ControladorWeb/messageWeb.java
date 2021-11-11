/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.ControladorWeb;

import Reto3.Reto3.Modelo.message;
import Reto3.Reto3.Servicios.serviciosMessage;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class messageWeb {
    @Autowired
    private serviciosMessage servicios;
    @GetMapping("/all")
    public List <message> getmessage(){
       return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<message> getmessage(@PathVariable("id") int idMessage) {
        return servicios.getmessage(idMessage);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public message save(@RequestBody message message){
        return servicios.save(message);
    }
    
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public message update(@RequestBody message message){
        return servicios.update(message);
    }
    
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId){
        return servicios.deleteMessage(messageId);
    }
  
}