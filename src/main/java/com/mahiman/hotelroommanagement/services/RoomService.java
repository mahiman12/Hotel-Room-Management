package com.mahiman.hotelroommanagement.services;

import com.mahiman.hotelroommanagement.models.Bookings;
import com.mahiman.hotelroommanagement.models.Room;
import com.mahiman.hotelroommanagement.repository.BookingRepository;
import com.mahiman.hotelroommanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingRepository bookingRepository;

    public void addRooms(List<Room> rooms) {
        roomRepository.saveAll(rooms);
    }

    public List<Room> viewRooms(){
        List<Room> allRooms = roomRepository.findAll();
        return allRooms;
    }

    public void deleteRooms(List<Room> rooms) {
        roomRepository.deleteAll(rooms);
    }

    public void updateRooms(List<Room> rooms){
        for(Room room : rooms){
            Integer roomId = room.getRoomNum();
            Room row = roomRepository.getById(roomId);
            row.setPrice(room.getPrice());
            roomRepository.save(row);
        }
    }

    public List<Room> findAvailableRooms(Date date, Boolean booked) {
        List<Room> rooms = new ArrayList<>();
        List<Room> allRooms = roomRepository.findAll();
        for(Room room : allRooms) {
            if(booked){
                if(bookingRepository.existsBookingsByDateAndRoomNum(date, room.getRoomNum())){
                    rooms.add(room);
                }
            }
            else{
                if(!bookingRepository.existsBookingsByDateAndRoomNum(date, room.getRoomNum())){
                    rooms.add(room);
                }
            }
        }
        return rooms;
    }

    public Double getTotalRevenue() {
        Double revenue = 0.0;
        List<Bookings> bookings = bookingRepository.findAll();
        for(Bookings booking : bookings) {
            revenue += roomRepository.getPriceByRoomNum(booking.getRoomNum());
        }
        return revenue;
    }


}
