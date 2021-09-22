package com.mahiman.hotelroommanagement.repository;

import com.mahiman.hotelroommanagement.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

    Boolean existsBookingsByDateAndRoomNum(Date date, Integer roomNum);

}
