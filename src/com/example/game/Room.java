package com.example.game;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setExit(String dir, Room room) { exits.put(dir, room); }
    public Room getExit(String dir) { return exits.get(dir); }
}
