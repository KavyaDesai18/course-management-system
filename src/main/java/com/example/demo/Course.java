package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Name;

@Entity
@Table(name = "course")
public class Course {

    @Id
    private String id;
    private String name;
    private String author;

    public Course() {                //one no argument constructor is mandatory for JSON getting data

    }

    public Course(String id,String name ,String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }


    //why getters are required? --> Spring uses jackson library to convert object into jason
    //we cannot directly send object to the server we always need jason data that's why we need to convert object into jason using jackson.
    //But jackson library has one RULE:
    //"I will call getters methods to read values"
    //No getters = Values not shown in jason

    //this all methods are called as getters .
    public String getId(){
        return id;           //this id is object or you can say raw data
    }

    public String getName(){
        return name;            //same with this and author also
    }

    public String getAuthor(){
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
