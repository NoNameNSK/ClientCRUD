package com.berezin.model;

import java.io.Serializable;

/**
 * Created by a.berezin on 27.02.2015.
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1L; //Непонял пока зачем этот серийник
    private int clientId;
    private String firstName;
    private String secondName;
    private String lastName;

    public int getClientId() {
        return clientId;
    }

    public Client() {
    }

    public Client(int clientId, String firstName, String secondName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Client setAll(Client client){
        client.setFirstName(this.getFirstName());
        client.setSecondName(this.secondName);
        client.setLastName(this.getLastName());
        return client;
    }
}
