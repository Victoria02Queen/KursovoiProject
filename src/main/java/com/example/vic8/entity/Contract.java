package com.example.vic8.entity;

public class Contract {
    private Integer id;
    private Integer number;
    private String customerName;
    private String customerAddress;
    private String creatingDate;
    private String finishDate;

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", number=" + number +
                ", customer_name='" + customerName + '\'' +
                ", customer_address='" + customerAddress + '\'' +
                ", creating_date='" + creatingDate + '\'' +
                ", finish_date='" + finishDate + '\'' +
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(String creatingDate) {
        this.creatingDate = creatingDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
}
