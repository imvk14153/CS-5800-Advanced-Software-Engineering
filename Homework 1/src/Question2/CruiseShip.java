package Question2;

public class CruiseShip extends Ship {
    private int maxNoOfPassengers;

    public CruiseShip(String name, String yearBuilt, int maxNoOfPassengers) {
        super(name, yearBuilt);
        this.maxNoOfPassengers = maxNoOfPassengers;
    }

    public int getMaxNoOfPassengers() {
        return maxNoOfPassengers;
    }

    public void setMaxNoOfPassengers(int maxNoOfPassengers) {
        this.maxNoOfPassengers = maxNoOfPassengers;
    }

    @Override
    public void print() {
        System.out.println("Cruise Ship Name: " + getName());
        System.out.println("Maximum Number Of Passengers: " + maxNoOfPassengers);
    }
}