import java.util.ArrayList;
import java.util.Date;

public class Harbor {
    private static final int BoatLimit=20;

    private String name;
    private String address;
    private ArrayList<Sailboat> sailboats=new ArrayList<>();
    private ArrayList<Rental> rentals=new ArrayList<>();

    public Harbor(String name, String address) {
        this.name = name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void addShip(Sailboat boat){
        if(this.sailboats.size()>=BoatLimit){
            throw new IllegalStateException("Habor cannot contain more than "+BoatLimit+" ships");
        }
        this.sailboats.add(boat);
    }

    private boolean checkIfBoatIsFree(Sailboat boat, Date date){
        for(Rental r : this.rentals){
            if(r.getShip().equals(boat) &&
                    r.getDate().equals(date)){
                return false;
            }
        }

        return true;
    }

    public Sailboat rentSailboat(Date date, String details, int numberOfPeople){
        Date now=new Date(); //current date
        if(date.before(now)){
            throw new IllegalArgumentException("Rental date must be in the future");
        }

        Sailboat freeBoat=null;
        for(Sailboat sb : this.sailboats){
            //We check whether the boat is not too small
            if(sb.getCapacity()<numberOfPeople){
                continue;
            }

            //We check whether the boat is free at this date
            if(checkIfBoatIsFree(sb, date)){
                freeBoat=sb; //we found our boat
                break;
            }
        }

        if(freeBoat==null){
            throw new IllegalArgumentException("There are no boats for this date available");
        }

        Rental newRental=new Rental(details, date, numberOfPeople, freeBoat);
        this.rentals.add(newRental);
        return newRental.getShip();
    }

    public double calculateIncome(){
        double income=0;
        for(Rental r : this.rentals){
            income+=r.getShip().getDailyRate();
        }
        return income;
    }
}
