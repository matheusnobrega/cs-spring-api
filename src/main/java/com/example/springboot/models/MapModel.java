package com.example.springboot.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_MAPS")
public class MapModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMap;
    private String name;
    private String country;
    private Date dateAdded;
    private boolean activePool;

    public UUID getIdMap() {
        return idMap;
    }

    public void setIdMap(UUID idMap) {
        this.idMap = idMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isActivePool() {
        return activePool;
    }

    public void setActivePool(boolean activePool) {
        this.activePool = activePool;
    }
}
