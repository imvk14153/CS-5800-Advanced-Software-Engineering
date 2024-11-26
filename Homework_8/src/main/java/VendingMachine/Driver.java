package VendingMachine;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Snack coke = new Snack("Coke", 2.99, 9);
        Snack pepsi = new Snack("Pepsi", 2.99, 4);
        Snack cheetos = new Snack("Cheetos", 3.5, 3);
        Snack doritos = new Snack("Doritos", 1.5, 4);
        Snack kitkat = new Snack("KitKat", 2.00, 6);
        Snack snickers = new Snack("Snickers", 2.00, 1);

        VendingMachine vm = new VendingMachine(Arrays.asList(coke, pepsi, cheetos, doritos, kitkat, snickers));

        // Getting snack by paying exact price
        vm.selectSnack("Coke");
        vm.insertMoney(2.99);
        vm.dispenseSnack();

        // Getting snack by paying less than selling price
        vm.selectSnack("Doritos");
        vm.insertMoney(1.00);
        vm.dispenseSnack();

        // Getting snack by paying more than selling price
        vm.selectSnack("Snickers");
        vm.insertMoney(2.50);
        vm.dispenseSnack();

        // Getting snack which is out of stock
        vm.selectSnack("Snickers");
        vm.insertMoney(2.00);
        vm.dispenseSnack();
    }
}