package VendingMachine;

import java.util.List;

public class VendingMachine {
    private StateOfVendingMachine vendingMachineState;
    private SnackDispenseHandler snackDispenser;

    public VendingMachine(List<Snack> availableSnacks) {
        this.vendingMachineState = new IdleState();

        SnackDispenseHandler handler = null;
        for (int i = availableSnacks.size() - 1; i >= 0; i--) {
            handler = new SnackDispenseHandler(availableSnacks.get(i), handler);
        }
        this.snackDispenser = handler;
    }

    public StateOfVendingMachine getCurrentState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(StateOfVendingMachine state) { this.vendingMachineState = state; }
    public SnackDispenseHandler getSnackDispenser() { return snackDispenser; }

    public void selectSnack(String snackName) {
        vendingMachineState.selectSnack(this, snackName);
    }

    public void insertMoney(double price) {
        vendingMachineState.insertMoney(this, price);
    }

    public void dispenseSnack() {
        vendingMachineState.dispenseSnack(this);
    }
}