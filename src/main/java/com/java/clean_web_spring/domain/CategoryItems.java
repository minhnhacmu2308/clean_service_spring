package com.java.clean_web_spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryItems {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "categoryItems")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "categoryItems")
    private List<Items> itemsList;

    @OneToMany(mappedBy = "categoryItems")
    private List<Review> reviews;
}
