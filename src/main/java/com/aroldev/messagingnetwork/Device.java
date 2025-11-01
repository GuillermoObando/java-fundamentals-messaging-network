package com.aroldev.messagingnetwork;
/*
* la clase abstracta Device es un contrato. establece reglas*/
public abstract class Device {

    private String  name;
    private int     id;

    // Constructor
    public Device(String name, int id){
        this.name   = name;
        this.id     = id;
    }

    //getters && setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos abstractos
    // las clases que EXTIENDAN de Device diran cómo para estos métodos
    public abstract void sendMessage(Message msg);
    public abstract void receiveMessage(Message msg);


}
