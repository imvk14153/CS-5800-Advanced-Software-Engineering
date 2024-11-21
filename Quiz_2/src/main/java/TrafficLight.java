import java.util.Random;
import java.util.Observable;

public class TrafficLight extends Observable{

    public enum signalColor {
        Red, Green, Yellow
    }

    private signalColor Color;
    private Random random;

    public TrafficLight() {
        this.Color = signalColor.Red;
        this.random = new Random();
    }

    public signalColor getCurrentColor() {
        return Color;
    }

    public void changeLight() {
        int waitTime = random.nextInt(4000);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        switch (Color) {
            case Red:
                Color = signalColor.Green;
                break;
            case Green:
                Color = signalColor.Yellow;
                break;
            case Yellow:
                Color = signalColor.Red;
                break;
        }
        setChanged();
        notifyObservers(Color);
        System.out.println("Traffic Light turned " + Color);
    }
}