package com.example.vic8.entity;

public class Product {
    private int id;
    private Integer code;
    private String name;
    private Integer cost;
    private Integer workshopId;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", workshop_id=" + workshopId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer getWorkshop_id() {
        return workshopId;
    }

    public void setWorkshop_id(int workshop_id) {
        this.workshopId = workshop_id;
    }
}
