package pl.coderslab.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {

    private int id;
    private LocalDateTime reserved;
    private LocalDateTime from;
    private LocalDateTime to;
    private String description;
    private int user_id;
    private int room_id;
    private Status status;

    public Reservation(){};

    public Reservation(int id, LocalDateTime reserved, LocalDateTime from, LocalDateTime to, String description, int user_id, int room_id, Status status) {
        this.reserved = reserved;
        this.from = from;
        this.to = to;
        this.description = description;
        this.user_id = user_id;
        this.room_id = room_id;
        this.status = status;
    }

    public Reservation(LocalDateTime reserved, LocalDateTime from, LocalDateTime to, String description, int user_id, int room_id, Status status) {
        this.reserved = reserved;
        this.from = from;
        this.to = to;
        this.description = description;
        this.user_id = user_id;
        this.room_id = room_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getReserved() {
        return reserved;
    }

    public void setReserved(LocalDateTime reserved) {
        this.reserved = reserved;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getRoomId() {
        return room_id;
    }

    public void setRoomId(int room_id) {
        this.room_id = room_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
