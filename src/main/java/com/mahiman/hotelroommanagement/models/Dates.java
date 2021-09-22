package com.mahiman.hotelroommanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(name = "roomnum")
    private Integer roomNum;

    @Column(name = "date")
    private Date date;

    public Dates(Integer roomNum, Date date) {
        this(null, roomNum, date);
    }

}
