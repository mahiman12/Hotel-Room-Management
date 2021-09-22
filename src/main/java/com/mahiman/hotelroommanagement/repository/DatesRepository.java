package com.mahiman.hotelroommanagement.repository;

import com.mahiman.hotelroommanagement.models.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Integer> {

    @Query(value = "select date from dates where roomnum = ?0", nativeQuery = true)
    List<Date> getDatesByRoomNum(Integer roomNum);


}
