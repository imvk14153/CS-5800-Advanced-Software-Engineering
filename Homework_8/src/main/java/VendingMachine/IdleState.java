package VendingMachine;

public class IdleState implements StateOfVendingMachine {
    public void selectSnack(VendingMachine vm, String snackName) {
        System.out.println("\nSelected Snack: " + snackName);
        vm.setVendingMachineState(new WaitingForMoneyState(snackName));
    }

    public void insertMoney(VendingMachine vm, double amount) {
        System.out.println("Snack not selected!");
    }

    public void dispenseSnack(VendingMachine vm) {
        System.out.println("Snack not selected!");
    }
}