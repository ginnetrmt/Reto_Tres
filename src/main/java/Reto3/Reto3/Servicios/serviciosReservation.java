/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.Servicios;

import Reto3.Reto3.Modelo.reservation;
import Reto3.Reto3.repositorio.RepositorioReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
public class serviciosReservation {
       
    @Autowired
    private RepositorioReservation metodosCrud;
    
    public List<reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<reservation> getreservation(int idReservation){
        return metodosCrud.getreservation(idReservation);
    }
    
    public reservation save(reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<reservation> evt=metodosCrud.getreservation(reservation.getIdReservation());
            if(evt.isEmpty()){
            return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public reservation update(reservation reservation){
        if(reservation.getIdReservation()!=null) {
            Optional<reservation> evt=metodosCrud.getreservation(reservation.getIdReservation());
            if(!evt.isEmpty()){
                if(reservation.getStartDate()!=null){
                    evt.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null) {
                   evt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null) {
                   evt.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return reservation;
            }
        }else{
             return reservation;
        }
    }

    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getreservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}