public class Sailboat {

    private String name;
    private int capacity;
    private double dailyRate;

    public Sailboat(String name, int capacity, double dailyRate) {
        this.name = name;
        this.capacity = capacity;
        this.dailyRate = dailyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null){
            throw new IllegalStateException("Ship cannot have empty name");
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity<=0){
            throw new IllegalStateException("Ship cannot have capavity less then or equal zero");
        }
        this.capacity = capacity;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if(dailyRate<0){
            throw new IllegalStateException("Ship cannot have daily rate less then zero");
        }
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object obj) {
        Sailboat sb=(Sailboat) obj;
        return sb.getName().equals(this.getName());
    }
}
