/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SnykTest;

/**
 *
 * @author hoang
 */
import java.util.*;
public interface ContractOperations {
    public void createContract(Contract contract);
    public void updateContract(int contractID, Contract contract);
    public boolean deleteContract(int contractID);
    public List<Contract> findContractsByName(String name);
    public List<Contract> listAllContracts();
}
