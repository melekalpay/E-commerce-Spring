package com.uniyaz.product.entity;

import com.uniyaz.product.common.BaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Table(name = "basket")
@Entity
public class Basket extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "basket_product"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
//    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "basket_user"))
//    private User user;


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
