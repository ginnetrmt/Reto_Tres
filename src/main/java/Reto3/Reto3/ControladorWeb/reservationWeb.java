/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.ControladorWeb;

import Reto3.Reto3.Modelo.reservation;
import Reto3.Reto3.Servicios.serviciosReservation;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class reservationWeb {
    @Autowired
    private serviciosReservation servicios;
    @GetMapping("/all")
    public List <reservation> getreservation(){
       return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<reservation> getcategory(@PathVariable("id") int idReservation) {
        return servicios.getreservation(idReservation);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation save(@RequestBody reservation reservation){
        return servicios.save(reservation);
    }
    
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation update(@RequestBody reservation reservation){
        return servicios.update(reservation);
    }
    
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return servicios.deleteReservation(reservationId);
    }
   
}