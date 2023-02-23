package com.uniyaz.product.entity;

import com.uniyaz.product.common.BaseEntity;

import javax.persistence.*;

@Table(name = "role")
@Entity
public class Rol extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
