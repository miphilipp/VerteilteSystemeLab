package com.LabProject;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Director
 */
@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;
    Date birthDate;

    void setId(Integer id) { this.id = id; }
    Integer getId() { return id; }

    void setName(String name) { this.name = name; }
    String getName() { return name; }

    void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    Date getBirthDate() { return birthDate; }
    
}