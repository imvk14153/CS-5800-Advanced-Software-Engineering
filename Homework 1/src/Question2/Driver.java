package Question2;

public class Driver {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];

        ships[0] = new Ship("Titanic", "1909");
        ships[1] = new CruiseShip("Disney Cruise Line", "1995", 4000);
        ships[2] = new CargoShip("COSCO Shipping Universe", "2018", 212370);

        System.out.println("\nShip Information\n");
        for (int i = 0; i < ships.length; i++) {
            ships[i].print();
            System.out.println();
        }
    }
}