package com.shophub.product.application.core.domain;

import com.shophub.product.adapters.in.controllers.dto.ProductResponse;

import java.util.Objects;

public class ProductDomain {

    private String name;
    private Double price;
    private String description;
    private Integer amount;

    public ProductDomain(String name, Double price, String description, Integer amount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDomain that = (ProductDomain) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(description, that.description) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, amount);
    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
