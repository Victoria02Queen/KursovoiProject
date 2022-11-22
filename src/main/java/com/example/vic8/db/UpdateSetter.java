package com.example.vic8.db;

public class UpdateSetter {
    private final String columName;
    private final String value;

    @Override
    public String toString() {
        return  columName + " = " + value;
    }

    public UpdateSetter(String columName, String value) {
        this.columName = columName;
        this.value = value;
    }

    public String getColumName() {
        return columName;
    }

    public String getValue() {
        return value;
    }

}
