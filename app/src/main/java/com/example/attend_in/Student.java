package com.example.attend_in;

public class Student {

   private String name,id,classId;


    public Student(){}

    public Student(String name, String id,String classId) {
        this.name = name;
        this.id = id;
        this.classId=classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
