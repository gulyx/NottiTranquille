package it.ispw.efco.nottitranquille.model;

import it.ispw.efco.nottitranquille.model.enumeration.Gender;

import java.util.*;

/**
 * @author Claudio Pastorini Omar Shalby Federico Vagnoni Emanuele Vannacci
 */
public class Person {

    /**
     * Default constructor
     */
    public Person() {
    }

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String lastName;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Date birthdate;

    /**
     * 
     */
    private String phoneNumber;

    private Address address;

    private Gender gender;


}