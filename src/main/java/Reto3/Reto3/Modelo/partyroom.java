/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "partyroom")
public class partyroom implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @javax.persistence.Id
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categryId")
    @JsonIgnoreProperties("partyrooms")
    private category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    private List<message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    private List<reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public List<message> getMessages() {
        return messages;
    }

    public void setMessages(List<message> messages) {
        this.messages = messages;
    }

    public List<reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<reservation> reservations) {
        this.reservations = reservations;
    }
    
    
}