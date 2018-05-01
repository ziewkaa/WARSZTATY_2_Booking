package pl.coderslab.entity;

public class Status {

    private int id;
    private int reservation_id;
    private String stage;

    public Status() {}

    public Status(int reservation_id, String stage){
        this.reservation_id = reservation_id;
        this.stage = stage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationId() {
        return reservation_id;
    }

    public void setReservationId(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
