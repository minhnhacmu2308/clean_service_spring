package com.java.clean_web_spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shift_id",referencedColumnName = "id")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "ctItems_id",referencedColumnName = "id")
    private CategoryItems categoryItems;

    @Column(name = "amount")
    private int amount;

    @OneToMany(mappedBy = "booking")
    private List<BookingItems> bookingItemss;

    @Column(name = "created")
    private String createdAt;
}
