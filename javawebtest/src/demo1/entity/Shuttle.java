package demo1.entity;

public class Shuttle {

    private Integer shuttleID;
    private String startTime;
    private Float ticketsPrices;
    private Integer ticketsNumber;
    private String startStation;
    private String endStation;

    public Integer getShuttleID() {
        return shuttleID;
    }

    public void setShuttleID(Integer shuttleID) {
        this.shuttleID = shuttleID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Float getTicketsPrices() {
        return ticketsPrices;
    }

    public void setTicketsPrices(Float ticketsPrices) {
        this.ticketsPrices = ticketsPrices;
    }

    public Integer getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(Integer ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Shuttle() {
    }
    public Shuttle(Integer shuttleID, String startTime, Float ticketsPrices, Integer ticketsNumber, String startStation, String endStation) {
        this.shuttleID = shuttleID;
        this.startTime = startTime;
        this.ticketsPrices = ticketsPrices;
        this.ticketsNumber = ticketsNumber;
        this.startStation = startStation;
        this.endStation = endStation;
    }
}
