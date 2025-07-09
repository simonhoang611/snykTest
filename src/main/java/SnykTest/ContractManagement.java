package SnykTest;

import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractManagement implements ContractOperations {

    private Scanner sc = new Scanner(System.in);
    private List<Contract> contracts = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<ContractType> contractTypes = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContractManagement program = new ContractManagement();
        program.initialData();

        int choice = 0;

        do {
            System.out.println("1. Create Contract");
            System.out.println("2. Display All Contracts");
            System.out.println("3. Update Contract");
            System.out.println("4. Delete Contract");
            System.out.println("5. Find Contracts by Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }

            switch (choice) {
                case 1:
                    program.createContract(null);
                    break;
                case 2:
                    program.listAllContracts();
                    break;
                case 3:
                    try {
                    System.out.print("Enter ID to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    program.updateContract(id, null);
                } catch (NumberFormatException e1) {
                    System.out.println("Invalid input.");
                }
                break;
                case 4:
                    program.deleteContract(0);
                    break;
                case 5:
                    program.findContractsByName("");
                    break;
                default:
                    System.out.println("Invalid choice. Must be 1 to 6.");
                    break;
            }

        } while (choice != 6);
        sc.close();
    }

    public void initialData() {
        clients.add(new Client(1, "Vietcombank"));
        clients.add(new Client(2, "FPT Software"));
        clients.add(new Client(3, "Vinamilk"));
        clients.add(new Client(4, "Hoa Phat Group"));
        clients.add(new Client(5, "Mobile World"));
        clients.add(new Client(6, "Masan Group"));
        clients.add(new Client(7, "Vingroup"));
        clients.add(new Client(8, "Viettel"));
        clients.add(new Client(9, "PetroVietnam"));
        clients.add(new Client(10, "SABECO"));

        contractTypes.add(new ContractType(1, "Service"));
        contractTypes.add(new ContractType(2, "Supply"));
        contractTypes.add(new ContractType(3, "Consulting"));
        contractTypes.add(new ContractType(4, "Maintenance"));
        contractTypes.add(new ContractType(5, "Outsourcing"));
        contractTypes.add(new ContractType(6, "Leasing"));
        contractTypes.add(new ContractType(7, "Other"));
    }

    @Override
    public void createContract(Contract contract) {
        int contractID;
        int clientID;
        int typeID;
        String contractName;
        Date startDateStr = null;
        Date endDateStr = null;
        String startDate;
        String endDate;
        float totalValue;

        while (true) {
            try {
                System.out.print("Enter Contract ID: ");
                contractID = Integer.parseInt(sc.nextLine());

                boolean idExist = false;
                for (Contract ct : contracts) {
                    if (ct.getContractID() == contractID) {
                        idExist = true;
                        break;
                    }
                }
                if (idExist) {
                    System.out.println("Contract ID already exists.");
                } else {
                    break;
                }
            } catch (NumberFormatException e1) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Client ID: ");
                clientID = Integer.parseInt(sc.nextLine());

                boolean clientExist = false;
                for (Client cl : clients) {
                    if (cl.getClientID() == clientID) {
                        clientExist = true;
                        break;
                    }
                }
                if (!clientExist) {
                    System.out.println("Invalid Client ID.");
                } else {
                    break;
                }
            } catch (NumberFormatException e2) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Contract Type ID: ");
                typeID = Integer.parseInt(sc.nextLine());

                boolean contractTypeExist = false;
                for (ContractType ctype : contractTypes) {
                    if (ctype.getTypeID() == typeID) {
                        contractTypeExist = true;
                        break;
                    }
                }
                if (!contractTypeExist) {
                    System.out.println("Invalid Contract Type ID.");
                } else {
                    break;
                }
            } catch (NumberFormatException e3) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        while (true) {
            System.out.print("Enter Contract Name: ");
            contractName = sc.nextLine();
            if (contractName.length() >= 3) {
                break;
            } else {
                System.out.println("Contract name must be at least 3 characters.");
            }
        }

        dateFormat.setLenient(false);
        while (true) {
            try {
                System.out.print("Enter Start Date: ");
                startDate = sc.nextLine();
                startDateStr = dateFormat.parse(startDate);
                break;
            } catch (ParseException e1) {
                System.out.println("Invalid date format.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter End Date: ");
                endDate = sc.nextLine();
                endDateStr = dateFormat.parse(endDate);
                if (endDateStr.after(startDateStr)) {
                    break;
                } else {
                    System.out.println("End Date must be after Start Date.");
                }
                break;
            } catch (ParseException e2) {
                System.out.println("Invalid date format.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter Total Value: ");
                totalValue = Float.parseFloat(sc.nextLine());
                if (totalValue > 0) {
                    break;
                } else {
                    System.out.println("Total value must be greater than 0.");
                }
            } catch (NumberFormatException e4) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        contract = new Contract(contractID, clientID, typeID, contractName, startDate, endDate, totalValue);
        contracts.add(contract);
        System.out.println("Contract created successfully.");
    }

    @Override
    public void updateContract(int contractID, Contract contract) {
        boolean update = false;
        Contract alreadyExisted = null;

        for (Contract ct : contracts) {
            if (ct.getContractID() == contractID) {
                alreadyExisted = ct;
                break;
            }
        }
        if (alreadyExisted == null) {
            System.out.println("Contract not found.");
            return;
        }

        System.out.println("Leave blank to keep current value.");

        while (true) {
            System.out.print("Enter Contract ID: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                try {
                    int newContractID = Integer.parseInt(input);
                    boolean idExist = false;
                    for (Contract ct : contracts) {
                        if (ct.getContractID() == newContractID) {
                            idExist = true;
                            break;
                        }
                    }
                    if (idExist) {
                        System.out.println("Contract ID already exists. Update failed.");
                    } else {
                        alreadyExisted.setContractID(newContractID);
                        update = true;
                        break;
                    }
                } catch (NumberFormatException e4) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

        while (true) {
            System.out.print("Enter Client ID: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                try {
                    int newClientID = Integer.parseInt(input);

                    boolean clientExist = false;
                    for (Client cl : clients) {
                        if (cl.getClientID() == newClientID) {
                            clientExist = true;
                            break;
                        }
                    }
                    if (!clientExist) {
                        System.out.println("Update failed.");
                    } else {
                        alreadyExisted.setClientID(newClientID);
                        update = true;
                        break;
                    }
                } catch (NumberFormatException e3) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

        while (true) {
            System.out.print("Enter Contract Type ID: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                try {
                    int newTypeID = Integer.parseInt(input);
                    boolean contractTypeExist = false;
                    for (ContractType ctt : contractTypes) {
                        if (ctt.getTypeID() == newTypeID) {
                            contractTypeExist = true;
                            break;
                        }
                    }
                    if (!contractTypeExist) {
                        System.out.println("Update failed.");
                    } else {
                        alreadyExisted.setTypeID(newTypeID);
                        update = true;
                        break;
                    }
                } catch (NumberFormatException e3) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

        while (true) {
            System.out.print("Enter Contract Name: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                if (input.length() >= 3) {
                    alreadyExisted.setContractName(input);
                    update = true;
                    break;
                } else {
                    System.out.println("Update failed.");
                }
            }
        }

        Date newStartDate = null;
        Date newEndDate;
        Date blankStartDate = newStartDate;

        dateFormat.setLenient(false);

        while (true) {
            System.out.print("Enter Start Date: ");
            String std = sc.nextLine();
            if (std.isEmpty()) {
                break;
            } else {
                try {
                    newStartDate = dateFormat.parse(std);
                    alreadyExisted.setStartDate(std);
                    update = true;
                    break;
                } catch (ParseException e3) {
                    System.out.println("Invalid input. Update failed.");
                }
            }
        }

        while (true) {
            System.out.print("Enter End Date: ");
            String ed = sc.nextLine();
            if (ed.isEmpty()) {
                break;
            } else {
                try {
                    newEndDate = dateFormat.parse(ed);
                    if (blankStartDate == null) {
                        blankStartDate = dateFormat.parse(alreadyExisted.getStartDate());
                    }
                    if (newEndDate.after(blankStartDate)) {
                        alreadyExisted.setEndDate(ed);
                        update = true;
                        break;
                    } else {
                        System.out.println("End Date must be after Start Date.");
                    }
                } catch (ParseException e4) {
                    System.out.println("Invalid input. Update failed.");
                }
            }
        }

        while (true) {
            System.out.print("Enter Total Value: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                try {
                    float newValue = Float.parseFloat(input);
                    if (newValue > 0) {
                        alreadyExisted.setTotalValue(newValue);
                        update = true;
                        break;
                    } else {
                        System.out.println("Update failed..");
                    }
                } catch (NumberFormatException e7) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }

        if (update) {
            System.out.println("Update successful.");
        }
    }

    private String findClientNameByID(int id) {
        for (Client cl : clients) {
            if (cl.getClientID() == id) {
                return cl.getClientName();
            }
        }
        return "";
    }

    private String findContractTypeByID(int id) {
        for (ContractType ctype : contractTypes) {
            if (ctype.getTypeID() == id) {
                return ctype.getTypeName();
            }
        }
        return "";
    }

    @Override
    public List<Contract> listAllContracts() {
        if (contracts.isEmpty()) {
            System.out.println("0 Contract Created.");
            return new ArrayList<>();
        } else {
            contracts.sort(Comparator.comparing(Contract::getContractName, String.CASE_INSENSITIVE_ORDER)
                    .thenComparingInt(Contract::getContractID));
        }
        for (Contract c : contracts) {
            String clientName = findClientNameByID(c.getClientID());
            String typeName = findContractTypeByID(c.getTypeID());

            System.out.println(c.getContractID() + "," + clientName + "," + typeName + "," + c.getContractName() + "," + c.getStartDate() + "," + c.getEndDate() + "," + c.getTotalValue());
        }
        return contracts;
    }

    @Override
    public boolean deleteContract(int contractID) {
        try {
            System.out.print("Enter Contract ID: ");
            int deleteContractID = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < contracts.size(); i++) {
                if (contracts.get(i).getContractID() == deleteContractID) {
                    contracts.remove(i);
                    System.out.println("Deleted Contract Successfully.");
                    return true;
                }
            }
            System.out.println("Contract Not Found.");
            return false;
        } catch (NumberFormatException e1) {
            System.out.println("Invalid input. Please try again.");
            return false;
        }
    }

    @Override
    public List<Contract> findContractsByName(String name) {
        List<Contract> existList = new ArrayList<>();
        System.out.println("Enter Contract Name to find: ");
        String searchName = sc.nextLine();

        for (Contract c : contracts) {
            if (c.getContractName().toLowerCase().contains(searchName.toLowerCase())) {
                existList.add(c);
            }
        }
        if (existList.isEmpty()) {
            System.out.println("No contracts found.");
        } else {
            existList.sort(Comparator.comparing(Contract::getContractName, String.CASE_INSENSITIVE_ORDER));
            for (Contract c : existList) {
                System.out.println(c);
            }
        }
        return existList;
    }

}

