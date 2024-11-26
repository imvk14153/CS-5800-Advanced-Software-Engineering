package VendingMachine;

public class DispensingSnackState implements StateOfVendingMachine {
    private String selectedSnack;
    private double price;

    public DispensingSnackState(String selectedSnack, double price) {
        this.selectedSnack = selectedSnack;
        this.price = price;
    }

    public void selectSnack(VendingMachine vm, String snackName) {
        System.out.println("Dispensing Snack!");
    }

    public void insertMoney(VendingMachine vm, double price) {
        System.out.println("Dispensing Snack!");
    }

    public void dispenseSnack(VendingMachine vm) {
        vm.getSnackDispenser().handleDispense(selectedSnack, price);
        vm.setVendingMachineState(new IdleState());
    }
}