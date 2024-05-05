import java.util.Date;

public class Rental {
    private String details;
    private Date date;
    private int numOfPeople;
    private Sailboat ship;

    public Rental(String details, Date date, int numOfPeople, Sailboat ship) {
        this.details = details;
        this.date = date;
        this.numOfPeople = numOfPeople;
        this.ship = ship;
    }

    public Date getDate() {
        return date;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public Sailboat getShip() {
        return ship;
    }

    public String getDetails() {
        return details;
    }
}
