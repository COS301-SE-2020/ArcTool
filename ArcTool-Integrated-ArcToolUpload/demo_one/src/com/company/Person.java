package com.company;
import java.io.*;

/**
 * FR: store one person's details (person's name, surname, phone number and email address)
 * @author Dynamic Ducttape
 */
public class Person {

    private String name;
    private String surname;
    private int person_id;
    private String contact_details;
    private String email_address;
    public Person next;
    public Person prev;

    /**
     * The constructor takes in parameters
     * The person's ID is auto generated
     * @param name the person's name
     * @param surname the person's surname
     * @param contact_details The person's contact details
     * @param email_address The person's email address
     */
    public Person(String name, String surname, String contact_details, String email_address ){
        this.name = name;
        this.surname = surname;
        this.contact_details = contact_details;
        this.email_address = email_address;
        this.prev = null;
        this.next = null;
    }

    /**
     * This function is used to get the person's name
     * @return String the name of the person
     */
    public String getName(){
        return  this.name;
    }

    /**
     * This function is used to get the person's contact details
     * @return String the contact details of the person
     */
    public String getContact_details(){
        return  this.contact_details;
    }

    /**
     * This function is used to get the person's surname
     * @return String the surname of the person
     */
    public String getSurname(){
        return  this.surname;
    }

    /**
     * This function is used to get the person's Id
     * @return String the Id of the person
     */
    public int getId(){
        return  this.person_id;
    }

    /**
     * This function can be used to set or modify the name of the person
     * @param s the new name
     */
    public void setName(String s){
        this.name = s;
    }

    /**
     * This function can be used to set or modify the surname of the person
     * @param s the new surname
     */
    public void setSurname(String s){
        this.surname = s;
    }

    /**
     * This function can be used to set or modify the contact details of the person
     * @param s the new phone number
     */
    public void setContact_details(String s){
        this.contact_details = s;
    }

    /**
     * This function can be used to set the name of the person
     * @param i the new ID
     */
    public void setId(int i){
        this.person_id = i;
    }
}
