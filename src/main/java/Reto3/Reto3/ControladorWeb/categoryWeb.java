/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.ControladorWeb;

import Reto3.Reto3.Modelo.category;
import Reto3.Reto3.Servicios.serviciosCategory;
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
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class categoryWeb {
    @Autowired
    private serviciosCategory servicios;
    @GetMapping("/all")
    public List <category> getcategory(){
       return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<category> getcategory(@PathVariable("id") int categoryId) {
        return servicios.getcategory(categoryId);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public category save(@RequestBody category category){
        return servicios.save(category);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public category update(@RequestBody category category){
        return servicios.update(category);
    }
    
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId){
        return servicios.deleteCategory(categoryId);
    }

}