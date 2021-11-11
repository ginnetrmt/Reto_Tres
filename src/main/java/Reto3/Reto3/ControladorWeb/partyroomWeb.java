/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.ControladorWeb;

import Reto3.Reto3.Modelo.partyroom;
import Reto3.Reto3.Servicios.serviciosPartyroom;
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
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class partyroomWeb {
    @Autowired
    private serviciosPartyroom servicios;
    @GetMapping("/all")
    public List <partyroom> getpartyroom(){
       return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<partyroom> getpartyroom(@PathVariable("id") int partyroomId) {
        return servicios.getpartyroom(partyroomId);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public partyroom save(@RequestBody partyroom partyroom){
        return servicios.save(partyroom);
    }
    
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public partyroom update(@RequestBody partyroom partyroom){
        return servicios.update(partyroom);
    }
    
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int partyroomId){
        return servicios.deletePartyroom(partyroomId);
    }

}