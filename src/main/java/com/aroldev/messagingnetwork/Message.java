package com.aroldev.messagingnetwork;

import com.aroldev.messagingnetwork.Enum.MessageType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    // atributos
    private String content;
    private long timestamp;
    private MessageType type;
    private String sender;

    // Constructor
    public Message(String content, MessageType type, String sender) {
        this.content = content;
        this.type = type;
        this.sender = sender;

        // generamos timestamp automáticamente
        // con el valor actual del sistema. Devuelve long
        this.timestamp = System.currentTimeMillis();
    }

    // Getters && Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    // Métodos
    //obtenemos el long de timestamp.currentMilis() y cambiamos a String
    public String formatDate(){
        Date fecha = new Date(this.timestamp);
        // formateamos según especificaciones de la tarea
        SimpleDateFormat formateo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // devolvemos fecha formateada
        return formateo.format(fecha);
    }
}
