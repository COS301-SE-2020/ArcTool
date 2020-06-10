package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Database database = new Database();
        database.addPerson(new Person("Mxolisi", "Mkanzi", "0763402426", "u18059326@tuks.co.za"));
        database.addPerson(new Person("NQ", "Maseko", "073456789", "u13258965@tuks.co.za"));
        database.addPerson(new Person("Person3", "Surname", "0789456123", "jnieif@gmail.com"));
        database.addPerson(new Person("frerer0", "rfefre", "2354789401", "effreer@gmail.com"));
        database.addPerson(new Person("Person4", "Surnamehhj", "0789456123", "jnieif@gmail.com"));

        System.out.println("*********************Before sorting***************");
        Person person = database.getPeople();

        while (person != null){
            System.out.println( "Person " + person.getId() + " : " + person.getName() + " , " + person.getSurname());
            person = person.next;
        }

        System.out.println("******************** Sorting by name***************");
        Person person2 = database.sortByName();

        while (person2 != null){
            System.out.println( "Person " + person2.getId() + " : " + person2.getName() + " , " + person2.getSurname());
            person2 = person2.next;
        }

        System.out.println("*********************Sorting by surname***************");
        Person person3 = database.sortBySurname();

        while (person3 != null){
            System.out.println( "Person " + person3.getId() + " : " + person3.getName() + " , " + person3.getSurname());
            person3 = person3.next;
        }

        System.out.println("*********************Sorting by ID***************");
        Person person4 = database.sortByID();

        while (person4 != null){
            System.out.println( "Person " + person4.getId() + " : " + person4.getName() + " , " + person4.getSurname());
            person4 = person4.next;
        }
    }
}
