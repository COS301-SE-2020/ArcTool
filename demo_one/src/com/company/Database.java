package com.company;
import java.io.*;
/**
 *FR: store a list of people
 * @author Dynamic Ducttape.
 * */
public class Database {
    public Person head;

    public Database(){
        this.head = null;
    }

    /**
     * This function return the root node/head
     * @return person returns the root node
     */
    public Person getPeople(){
        return  this.head;
    }

    /**
     * This function adds a new person to the list
     * @param person The person object that must be added to the list
     */
    public void addPerson(Person person){
        int id=1;
        if (head == null){
            person.setId(0);
            head = person;
            return;
        }

        Person current = head;

        while (current.next != null){
            id++;
            current = current.next;
        }

        person.setId(id);
        current.next = person;
        person.prev = current;
    }

    /**
     * This function sorts the list of people according to the parameter passed.
     * @param s specify the criteria that must be used to sort the list, The paramenter can be name, surname or id(the function is not case sensitive).
     * @return Person returns the sorted list
     */

    public Person sortBy(String s){
        switch (s.toUpperCase()){
            case "NAME":
                return sortByName();

            case "SURNAME":
                return sortBySurname();

            case "ID":
                return sortByID();

            default:
                return head;
        }
    }

    /**
     * This function sorts the list by name
     * @return Person returns the soretd list
     */
    public Person sortByName(){

        Person current = head;
        boolean sorted = false;
        Person prev = head;

        while(true){
            if(current.next != null && current.getName().compareTo(current.next.getName()) > 0){
                //System.out.println("Swapping " + current.getName() + " & " + current.next.getName());
                Person temp = current.next.next;
                sorted = false;

                if (current == head){
                    head = current.next;
                    head.next = current;
                    current.next = temp;
                }
                else {
                    prev.next = current.next;
                    current.next.next = current;
                    current.next = temp;

                }
            }

            if (current.next== null ){
                if (sorted)
                    return  head;
                else{
                    sorted = true;
                    current = head;
                }
            }
            else{
                prev = current;
                current = current.next;
            }
        }
    }

    /**
     * This function sorts the list by surname
     * @return Person returns the soretd list
     */
    public Person sortBySurname(){
        Person current = head;
        boolean sorted = false;
        Person prev = null;

        while(true){
            if(current.next != null && current.getSurname().compareTo(current.next.getSurname()) > 0){
                //System.out.println("Swapping " + current.getName() + " & " + current.next.getName());
                Person temp = current.next.next;
                sorted = false;

                if (current == head){
                    head = current.next;
                    head.next = current;
                    current.next = temp;
                }
                else {
                    prev.next = current.next;
                    current.next.next = current;
                    current.next = temp;

                }
            }

            if (current.next== null ){
                if (sorted)
                    return  head;
                else{
                    sorted = true;
                    current = head;
                }
            }
            else{
                prev = current;
                current = current.next;
            }
        }
    }

    /**
     * This function sorts the list by Users' IDs
     * @return Person returns the soretd list
     */
    public Person sortByID(){
        //Descending
        Person current = head;
        boolean sorted = false;
        Person prev = null;

        while(true){
            if(current.next != null && current.getId()>current.next.getId()){
                //System.out.println("Swapping " + current.getName() + " & " + current.next.getName());
                Person temp = current.next.next;
                sorted = false;

                if (current == head){
                    head = current.next;
                    head.next = current;
                    current.next = temp;
                }
                else {
                    prev.next = current.next;
                    current.next.next = current;
                    current.next = temp;

                }
            }

            if (current.next== null ){
                if (sorted)
                    return  head;
                else{
                    sorted = true;
                    current = head;
                }
            }
            else{
                prev = current;
                current = current.next;
            }
        }
    }
}
