package com.mahiman.hotelroommanagement.controller;

import com.mahiman.hotelroommanagement.configs.JsonResponse;
import com.mahiman.hotelroommanagement.models.Room;
import com.mahiman.hotelroommanagement.services.BookingService;
import com.mahiman.hotelroommanagement.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    RoomService roomService;

    @GetMapping(value = "/view")
    public ResponseEntity<JsonResponse> viewRooms(){
        JsonResponse jsonResponse = new JsonResponse(true, "Rooms' list", roomService.viewRooms());
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/book")
    public ResponseEntity<JsonResponse> bookRooms(@RequestBody List<Room> rooms, List<Date> dates, @RequestBody String userName) {
        JsonResponse jsonResponse = new JsonResponse();
        Double cost = bookingService.book(rooms, dates, userName);
        jsonResponse = new JsonResponse(true, "All rooms booked!", "Cost : " + cost);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
