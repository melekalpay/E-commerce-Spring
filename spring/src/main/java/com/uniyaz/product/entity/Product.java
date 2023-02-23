package com.uniyaz.product.entity;

import com.uniyaz.product.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "product")
@Entity
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "image", length=65555)
    private String image;

    @Column(name = "amount")
    private int amount;

    @Column(name = "stok")
    private int stok;

    public Product() {
    }

    public Product(String name,String description,Double price,String image,int amount, int stok) {
        this.name =name;
        this.description=description;
        this.amount=amount;
        this.image=image;
        this.price=price;
        this.stok=stok;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", amount=" + amount +
                ", stok=" + stok +
                '}';
    }
}
