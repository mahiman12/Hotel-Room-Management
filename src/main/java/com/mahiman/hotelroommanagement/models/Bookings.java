package com.mahiman.hotelroommanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
@Entity
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(name = "roomnum")
    private Integer roomNum;

    @Column(name = "username")
    private String userName;

    @Column(name = "date")
    private Date date;

    public Bookings(Integer roomNum, String userName, Date date) {
        this(null, roomNum, userName, date);
    }
}
