package com.mahiman.hotelroommanagement.controller;

import com.mahiman.hotelroommanagement.configs.JsonResponse;
import com.mahiman.hotelroommanagement.models.Room;
import com.mahiman.hotelroommanagement.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    RoomService roomService;

    @PostMapping(value = "/add")
    public ResponseEntity<JsonResponse> addRooms(@RequestBody List<Room> rooms) {
        try {
            roomService.addRooms(rooms);
            return new ResponseEntity(new JsonResponse(true, "Rooms Added!", null), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(new JsonResponse(false, e.getMessage(), null), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/view")
    public ResponseEntity<JsonResponse> viewRooms(){
        JsonResponse jsonResponse = new JsonResponse(true, "Rooms' list", roomService.viewRooms());
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<JsonResponse> deleteRooms(@RequestBody List<Room> rooms){
        JsonResponse jsonResponse;
        try {
            roomService.deleteRooms(rooms);
            jsonResponse = new JsonResponse(true, "Rooms deleted!", null);
        }
        catch (Exception e) {
            jsonResponse = new JsonResponse(false, e.getMessage(), null);
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/udpate")
    public ResponseEntity<JsonResponse> udpateRooms(@RequestBody List<Room> rooms) {
        try {
            roomService.updateRooms(rooms);
            return new ResponseEntity(new JsonResponse(true, "Rooms Updated!", null), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(new JsonResponse(false, e.getMessage(), null), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/available")
    public ResponseEntity<JsonResponse> availableRooms(@RequestBody Date date){
        JsonResponse jsonResponse;
        List<Room> rooms = roomService.findAvailableRooms(date, false);
        if(rooms.isEmpty()){
            jsonResponse = new JsonResponse(true, "No rooms avaiable!", null);
        }
        else{
            jsonResponse = new JsonResponse(true, "Available Rooms!", rooms);
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/booked")
    public ResponseEntity<JsonResponse> bookedRooms(@RequestBody Date date){
        JsonResponse jsonResponse;
        List<Room> rooms = roomService.findAvailableRooms(date, true);
        if(rooms.isEmpty()){
            jsonResponse = new JsonResponse(true, "No rooms avaiable!", null);
        }
        else{
            jsonResponse = new JsonResponse(true, "Available Rooms!", rooms);
        }
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/revenue")
    public ResponseEntity<JsonResponse> getTotalRevenue(){
        JsonResponse jsonResponse;
        Double revenue = roomService.getTotalRevenue();
        jsonResponse = new JsonResponse(true, "Success", "Total Revenue : " + revenue);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }





}
