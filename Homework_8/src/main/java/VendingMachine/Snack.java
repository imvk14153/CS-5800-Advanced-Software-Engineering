package VendingMachine;

public class Snack {
    private String snackName;
    private double snackPrice;
    private int snackQuantity;

    public Snack(String snackName, double snackPrice, int snackQuantity) {
        this.snackName = snackName;
        this.snackPrice = snackPrice;
        this.snackQuantity = snackQuantity;
    }

    public String getSnackName() { return snackName; }
    public double getSnackPrice() { return snackPrice; }
    public int getSnackQuantity() { return snackQuantity; }

    public void decreaseSnackQuantity() {
        if (snackQuantity > 0) snackQuantity--;
    }
}