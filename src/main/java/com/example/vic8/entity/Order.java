package com.example.vic8.entity;

public class Order {
    private Integer id;
    private Integer productId;
    private Integer contId;
    private Integer productCount;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product_id=" + productId +
                ", cont_id=" + contId +
                ", product_count=" + productCount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProduct_id(int product_id) {
        this.productId = product_id;
    }

    public Integer getContId() {
        return contId;
    }

    public void setCont_id(int cont_id) {
        this.contId = cont_id;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProduct_count(int product_count) {
        this.productCount = product_count;
    }
}
