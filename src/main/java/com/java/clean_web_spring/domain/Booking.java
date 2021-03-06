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
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private User employee;

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

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "message")
    private String message;

    @Column(name = "house_size")
    private String houseSize;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "status")
    private int status;
}
