package pl.coderslab.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {

    private LocalDateTime reservation;
    private LocalDateTime from;
    private LocalDateTime to;
    private String description;
    private User user;
    private Status status;

    public Reservation(LocalDateTime reservation, LocalDateTime from, LocalDateTime to, String description, User user, Status status) {
        this.reservation = reservation;
        this.from = from;
        this.to = to;
        this.description = description;
        this.user = user;
        this.status = status;
    }

    public LocalDateTime getReservation() {
        return reservation;
    }

    public void setReservation(LocalDateTime reservation) {
        this.reservation = reservation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setState(Status status) {
        this.status = status;
    }
}
