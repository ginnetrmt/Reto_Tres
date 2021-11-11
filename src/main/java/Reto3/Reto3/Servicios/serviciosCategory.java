/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.Servicios;

import Reto3.Reto3.Modelo.category;
import Reto3.Reto3.repositorio.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
public class serviciosCategory {
       
    @Autowired
    private RepositorioCategory metodosCrud;
    
    public List<category> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<category> getcategory(int id){
        return metodosCrud.getcategory(id);
    }
    
    public category save(category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<category> evt=metodosCrud.getcategory(category.getId());
            if(evt.isEmpty()){
            return metodosCrud.save(category);
            }else{
                return category;
            }
        }
    }
    
    public category update(category category){
        if(category.getId()!=null) {
            Optional<category> evt=metodosCrud.getcategory(category.getId());
            if(!evt.isEmpty()){
                if(category.getName()!=null){
                    evt.get().setName(category.getName());
                }
                if(category.getDescription()!=null) {
                   evt.get().setDescription(category.getDescription());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return category;
            }
        }else{
             return category;
        }
    }

    public boolean deleteCategory(int categoryId){
        Boolean aBoolean = getcategory(categoryId).map(category -> {
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}