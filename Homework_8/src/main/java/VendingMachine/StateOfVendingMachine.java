package VendingMachine;

public interface StateOfVendingMachine {
    void selectSnack(VendingMachine vm, String snackName);
    void insertMoney(VendingMachine vm, double price);
    void dispenseSnack(VendingMachine vm);
}