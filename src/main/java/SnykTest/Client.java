/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SnykTest;

/**
 *
 * @author hoang
 */
public class Client{
    private int clientID;
    private String clientName;

    public Client(int clientID, String clientName) {
        this.clientID = clientID;
        this.clientName = clientName;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return super.toString()+","+clientName;
    }

}
