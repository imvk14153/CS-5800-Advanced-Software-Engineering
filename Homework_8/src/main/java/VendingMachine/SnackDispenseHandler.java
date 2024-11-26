package VendingMachine;

public class SnackDispenseHandler {
    private Snack selectedSnack;
    private SnackDispenseHandler nextHandler;

    public SnackDispenseHandler(Snack selectedSnack, SnackDispenseHandler nextHandler) {
        this.selectedSnack = selectedSnack;
        this.nextHandler = nextHandler;
    }

    public void handleDispense(String snackName, double price) {
        if (selectedSnack.getSnackName().equals(snackName)) {
            if (selectedSnack.getSnackQuantity() <= 0) {
                System.out.println("Sorry, " + snackName + " is currently out of stock!");
                System.out.println("$" + price + " Refund Processed!");
            } else if (price < selectedSnack.getSnackPrice()) {
                System.out.println("$" + selectedSnack.getSnackPrice() + " required!");
                System.out.println("$" + price + " Refund Processed!");
            } else {
                selectedSnack.decreaseSnackQuantity();
                System.out.println("Dispensed Snack!");
                if (price > selectedSnack.getSnackPrice()) {
                    System.out.println("Here is your Change: $" + (price - selectedSnack.getSnackPrice()));
                }
            }
        } else if (nextHandler != null) {
            nextHandler.handleDispense(snackName, price);
        }
    }
}