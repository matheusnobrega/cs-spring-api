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
}
