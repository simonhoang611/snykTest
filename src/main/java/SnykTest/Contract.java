/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SnykTest;

/**
 *
 * @author hoang
 */
public class Contract {
    private int contractID;
    private int clientID;
    private int typeID;
    private String contractName;
    private String startDate;
    private String endDate;
    private float totalValue;

    public Contract(int contractID, int clientID, int typeID, String contractName, String startDate, String endDate, float totalValue) {
        this.contractID = contractID;
        this.clientID = clientID;
        this.typeID = typeID;
        this.contractName = contractName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalValue = totalValue;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }
    
    @Override
    public String toString(){
        return contractID+","+clientID+","+typeID+","+contractName+","+startDate+","+endDate+","+totalValue;
    }
}
