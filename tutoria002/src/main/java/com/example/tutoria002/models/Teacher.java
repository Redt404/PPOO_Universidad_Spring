package com.example.tutoria002.models;


public class Teacher {

    private int id;
    private String names;
    private String lastNames;
    private String email;


    // metodos accesores
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return this.lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
