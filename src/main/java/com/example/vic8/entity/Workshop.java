package com.example.vic8.entity;

public class Workshop {
    private Integer id;
    private Integer number;
    private String name;
    private String chief;
    private String phone;

    @Override
    public String toString() {
        return "Workshop{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", chief='" + chief + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
