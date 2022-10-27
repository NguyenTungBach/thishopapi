package com.example.thishopapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private int price;
    private int quantity;


}
