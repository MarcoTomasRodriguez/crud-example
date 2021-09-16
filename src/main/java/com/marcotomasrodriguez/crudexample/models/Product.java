package com.marcotomasrodriguez.crudexample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET active = false WHERE product_id=?")
@Where(clause = "active = true")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "price", nullable = false)
    private Double price;

    @JsonIgnore
    @Column(name = "active", nullable = false)
    private Boolean active = Boolean.TRUE;
}
