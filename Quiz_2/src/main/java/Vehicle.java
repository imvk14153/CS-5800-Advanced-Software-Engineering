import java.util.Observable;

abstract class Vehicle extends Observable{

    private String vehicle_name;
    private int vehicle_year;

    public Vehicle(String vehicle_name,  int vehicle_year) {
        this.vehicle_name = vehicle_name;
        this.vehicle_year = vehicle_year;
    }

    public abstract void go();

    public abstract void stop();

    public String getVehicle_name() {
        return vehicle_name;
    }

    public int getVehicle_year() {
        return vehicle_year;
    }

    public void printVehicleInfo() {
        System.out.println("Vehicle Name: " + vehicle_name + "\n Model Year: " + vehicle_year);
    }

    public void update(Observable o, Object arg) {
        if (o instanceof TrafficLight && arg instanceof TrafficLight.signalColor) {
            TrafficLight.signalColor color = (TrafficLight.signalColor) arg;
            System.out.println( vehicle_name + " noticed " + color + " traffic light");
            TrafficLightVehicle(color);
        }
    }

    public void TrafficLightVehicle(TrafficLight.signalColor color) {
        switch (color) {
            case Red:
                System.out.println( vehicle_name + " stops at the red light.");
                break;
            case Green:
                System.out.println( vehicle_name + " moves at the green light.");
                break;
            case Yellow:
                System.out.println( vehicle_name + " prepares to stop at the yellow light.");
                break;
        }
    }
}