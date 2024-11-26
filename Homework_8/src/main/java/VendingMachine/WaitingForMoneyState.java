package VendingMachine;

public class WaitingForMoneyState implements StateOfVendingMachine {
    private String selectedSnack;

    public WaitingForMoneyState(String selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public void selectSnack(VendingMachine vm, String snackName) {
        System.out.println("Proceed to insert money!");
    }

    public void insertMoney(VendingMachine vm, double price) {
        System.out.println("$" + price + " Inserted");
        vm.setVendingMachineState(new DispensingSnackState(selectedSnack, price));
    }

    public void dispenseSnack(VendingMachine vm) {
        System.out.println("Proceed to insert money!");
    }
}