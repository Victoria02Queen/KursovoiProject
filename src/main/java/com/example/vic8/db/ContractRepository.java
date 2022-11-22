package com.example.vic8.db;

import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Workshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ContractRepository {
    private static final Connection connection;
    static {
        connection = ConnectionManager.getConnection();
    }
    public static ArrayList<Contract> getContracts(){
        ArrayList<Contract> contracts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from contract");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int number = resultSet.getInt("number");
                String customerName = resultSet.getString("customer_name");
                String customerAddress = resultSet.getString("customer_address");
                String creatingDate = resultSet.getString("creating_date");
                String finishDate = resultSet.getString("finish_date");


                Contract contract = new Contract();
                contract.setId(id);
                contract.setNumber(number);
                contract.setCustomerName(customerName);
                contract.setCustomerAddress(customerAddress);
                contract.setCreatingDate(creatingDate);
                contract.setFinishDate(finishDate);

                contracts.add(contract);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }

    public static void addContract(Contract contract){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Contract(number,customer_name,customer_address,creating_date,finish_date) " +
                    "VALUES ("+ contract.getNumber() +", " +
                    "'" + contract.getCustomerName() + "', " +
                    "'" + contract.getCustomerAddress() + "', "+
                    "'" + contract.getCreatingDate() + "', " +
                    "'" + contract.getFinishDate() + "');";
            statement.execute(sql);
            System.out.println(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteContractById(int id){
        try{
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Contract WHERE id = " + id;
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateContract(Contract contract){
        ArrayList<UpdateSetter> updateSetters = new ArrayList<>();

        if (contract.getNumber() != null){
            updateSetters.add(new UpdateSetter("number",contract.getNumber().toString()));
        }
        if (contract.getCustomerName() != null){
            updateSetters.add(new UpdateSetter("customer_name", "'" + contract.getCustomerName() + "'"));
        }
        if (contract.getCustomerAddress() != null){
            updateSetters.add(new UpdateSetter("customer_address", "'" + contract.getCustomerAddress() + "'"));
        }
        if (contract.getCreatingDate() != null){
            updateSetters.add(new UpdateSetter("creating_date", "'" + contract.getCreatingDate() + "'"));
        }
        if (contract.getFinishDate() != null){
            updateSetters.add(new UpdateSetter("finish_date", "'" + contract.getFinishDate() + "'"));
        }
        if(updateSetters.size() == 0){
            System.out.println("Фильтр пустой");
            return;
        }
        try {
            Statement statement = connection.createStatement();
            UpdateHelper updateHelper = new UpdateHelper("Contract", updateSetters, contract.getId());
            String sql = updateHelper.buildUpdate();
            System.out.println(sql);
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


