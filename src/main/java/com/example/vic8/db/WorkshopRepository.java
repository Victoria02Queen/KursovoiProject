package com.example.vic8.db;

import com.example.vic8.entity.Contract;
import com.example.vic8.entity.Order;
import com.example.vic8.entity.Workshop;

import java.sql.*;
import java.util.ArrayList;

public class WorkshopRepository {
    private static final Connection connection;
    static {
        connection = ConnectionManager.getConnection();
    }

    public static ArrayList<Workshop> getWorkshops(){
        ArrayList<Workshop> workshops = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from workshop");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int number = resultSet.getInt("number");
                String name = resultSet.getString("name");
                String chief = resultSet.getString("chief");
                String phone = resultSet.getString("phone");

                Workshop workshop = new Workshop();
                workshop.setId(id);
                workshop.setNumber(number);
                workshop.setName(name);
                workshop.setChief(chief);
                workshop.setPhone(phone);

                workshops.add(workshop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workshops;
    }

    public static void addWorkshop(Workshop workshop){
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO workshop(number, name, chief, phone) " +
                    "VALUES ("+ workshop.getNumber() +", " +
                    "'" + workshop.getName() + "', " +
                    "'" + workshop.getChief() + "', "+
                    "'" + workshop.getPhone() + "');";
            statement.execute(sql);
            System.out.println(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteWorkshopById(int id){
        try{
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Workshop WHERE id = " + id;
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateWorkshop(Workshop workshop){
        ArrayList<UpdateSetter> updateSetters = new ArrayList<>();

        if (workshop.getNumber() != null){
            updateSetters.add(new UpdateSetter("number", workshop.getNumber().toString()));
        }
        if (workshop.getName() != null){
            updateSetters.add(new UpdateSetter("name", "'" + workshop.getName() + "'"));
        }
        if (workshop.getChief() != null){
            updateSetters.add(new UpdateSetter("chief", "'" + workshop.getChief() + "'"));
        }
        if (workshop.getPhone() != null){
            updateSetters.add(new UpdateSetter("phone", "'" + workshop.getPhone() + "'"));
        }
        if(updateSetters.size() == 0){
            System.out.println("Фильтр пустой");
            return;
        }
        try {
            Statement statement = connection.createStatement();
            UpdateHelper updateHelper = new UpdateHelper("Workshop", updateSetters, workshop.getId());
            String sql = updateHelper.buildUpdate();
            System.out.println(sql);
            statement.execute(sql);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
