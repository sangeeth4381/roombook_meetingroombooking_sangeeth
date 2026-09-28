package com.example.javasem.controller;

import com.example.javasem.entity.Room;
import com.example.javasem.repository.RoomRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return repository.save(room);
    }

    @GetMapping
    public List<Room> getRooms() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Room not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long id) {
        repository.deleteById(id);
        return "Room deleted successfully";
    }
    @DeleteMapping("/{id}")
    public String deletesan(@PathVariable Long id) {
        repository.deleteById(id);
        return "Room deleted successfully";
    }
}