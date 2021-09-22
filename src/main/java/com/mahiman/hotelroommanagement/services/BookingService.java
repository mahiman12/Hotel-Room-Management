package com.mahiman.hotelroommanagement.services;

import com.mahiman.hotelroommanagement.models.Bookings;
import com.mahiman.hotelroommanagement.models.Dates;
import com.mahiman.hotelroommanagement.models.Room;
import com.mahiman.hotelroommanagement.repository.BookingRepository;
import com.mahiman.hotelroommanagement.repository.DatesRepository;
import com.mahiman.hotelroommanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    DatesRepository datesRepository;
    @Autowired
    BookingRepository bookingRepository;

    public Double book(List<Room>rooms, List<Date> dates, String userName) {
        Double cost = 0.0;
        for(Room room : rooms) {
            Integer roomNum = room.getRoomNum();
            List<Date> datesTaken = datesRepository.getDatesByRoomNum(roomNum);
            for(Date d : dates){
                if(!datesTaken.contains(d)){
                    datesRepository.save(new Dates(roomNum, d));
                    bookingRepository.save(new Bookings(roomNum, userName, d));
                    cost += roomRepository.getPriceByRoomNum(roomNum);
                }
            }
        }
        return cost;
    }

}
