package Question2;

public class CargoShip extends Ship {
    private int cargoCapacityInTonnage;

    public CargoShip(String name, String yearBuilt, int cargoCapacityInTonnage) {
        super(name, yearBuilt);
        this.cargoCapacityInTonnage = cargoCapacityInTonnage;
    }

    public int getCargoCapacityInTonnage() {
        return cargoCapacityInTonnage;
    }

    public void setCargoCapacityInTonnage(int cargoCapacityInTonnage) {
        this.cargoCapacityInTonnage = cargoCapacityInTonnage;
    }

    @Override
    public void print() {
        System.out.println("Cargo Ship Name: " + getName());
        System.out.println("Cargo Capacity In Tonnage: " + cargoCapacityInTonnage);
    }
}