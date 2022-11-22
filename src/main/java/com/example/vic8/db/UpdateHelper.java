package com.example.vic8.db;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UpdateHelper {
    private String tableName;
    private int idForUpdate;
    private ArrayList<UpdateSetter> updateSetters;

    public UpdateHelper(String tableName, ArrayList<UpdateSetter> updateSetters, int idForUpdate) {
        this.tableName = tableName;
        this.updateSetters = updateSetters;
        this.idForUpdate = idForUpdate;
    }

    private String buildSetters(){
        return updateSetters.stream().map(UpdateSetter::toString).collect(Collectors.joining(", "));
    }
    public String buildUpdate(){
        return "UPDATE " + tableName + " SET " + buildSetters() + " WHERE id = " + idForUpdate;
    }
}
