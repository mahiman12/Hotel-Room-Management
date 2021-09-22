package com.mahiman.hotelroommanagement.repository;

import com.mahiman.hotelroommanagement.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "select price from rooms where roomnum = ?0", nativeQuery = true)
    Double getPriceByRoomNum(Integer roomNum);

}
