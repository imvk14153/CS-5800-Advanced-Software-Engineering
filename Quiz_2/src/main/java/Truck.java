import java.util.Observable;

public class Truck extends Vehicle {

    public Truck(String vehicle_name, int vehicle_year) {
        super(vehicle_name, vehicle_year);
    }

    @Override
    public void go() {
        System.out.println("Truck started!");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopped!");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TrafficLight && arg instanceof TrafficLight.signalColor) {
            TrafficLight.signalColor color = (TrafficLight.signalColor) arg;
            System.out.println( getVehicle_name() + " noticed " + color + " traffic light");
            TrafficLightVehicle(color);
        }
    }

    @Override
    public void TrafficLightVehicle(TrafficLight.signalColor color) {
        switch (color) {
            case Red:
                System.out.println( getVehicle_name() + " Stop");
                break;
            case Green:
                System.out.println( getVehicle_name() + " Go Slow");
                break;
            case Yellow:
                System.out.println( getVehicle_name() + " Slower");
                break;
        }
    }
}