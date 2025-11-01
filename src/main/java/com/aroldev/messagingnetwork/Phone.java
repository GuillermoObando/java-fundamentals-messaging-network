package com.aroldev.messagingnetwork;

import com.aroldev.messagingnetwork.Enum.MessageType;

public class Phone extends Device {

    private int capacity;
    private Message[] msgHistory; //array que almacenara los mensajes
    private int indexMsg = 0; //variable que indica el indice del array donde guardaremos el proximo mensaje

    public Phone(String name, int id, int capacity) {
        super(name, id);
        this.capacity = capacity;
        this.msgHistory = new Message[capacity]; // Aquí creamos el array con el tamaño correcto
    }

    @Override
    public void receiveMessage(Message msg) {
        // 1ra validación
        if (msg.getContent() == null || msg.getContent().isEmpty()) {
            return;
        }
        // 2da validación
        // El tipo es System?
        if (msg.getType() == MessageType.SYSTEM) {
            //el remitente NO es "SYSTEM" ?
            if (!msg.getSender().equals("SYSTEM")) {
                return;
            }
        }
        // Guardamos el mensaje en la posición que indica nuestro marcador
        this.msgHistory[this.indexMsg] = msg;
        // Aquí movemos el marcador para el proximo mensaje
        // usamos la lógica del % para hacerlo cíclico
        this.indexMsg = (this.indexMsg + 1) % this.capacity;
    }

    @Override
    public void sendMessage(Message msg) {
        System.out.println("Enviando: " + msg.getContent());
        this.msgHistory[this.indexMsg] = msg;
        this.indexMsg = (this.indexMsg + 1) % this.capacity;
    }

    public Message[] getMessages() {
        return this.msgHistory;
    }
}
