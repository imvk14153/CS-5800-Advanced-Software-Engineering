package VendingMachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    private Snack coke, pepsi, cheetos, doritos, kitkat, snickers;
    private VendingMachine vm;

    @BeforeEach
    void createSnacks() {
        coke = new Snack("Coke", 2.99, 9);
        pepsi = new Snack("Pepsi", 2.99, 4);
        cheetos = new Snack("Cheetos", 3.5, 3);
        doritos = new Snack("Doritos", 1.5, 4);
        kitkat = new Snack("KitKat", 2.00, 6);
        snickers = new Snack("Snickers", 2.00, 1);

        vm = new VendingMachine(Arrays.asList(coke, pepsi, cheetos, doritos, kitkat, snickers));
    }

    @Test
    void testIdleStateSelectSnack() {
        vm.selectSnack("Coke");
        assertTrue(vm.getCurrentState() instanceof WaitingForMoneyState);
    }

    @Test
    void testSnackDecreaseQuantity() {
        assertEquals(9, coke.getSnackQuantity());
        coke.decreaseSnackQuantity();
        assertEquals(8, coke.getSnackQuantity());
    }

    @Test
    void testIdleStateInsertMoneyWithoutSelection() {
        vm.insertMoney(2.99);
        assertTrue(vm.getCurrentState() instanceof IdleState);
    }

    @Test
    void testWaitingForMoneyStateSelectSnack() {
        vm.selectSnack("Coke");
        vm.selectSnack("Pepsi");
        assertTrue(vm.getCurrentState() instanceof WaitingForMoneyState);
    }

    @Test
    void testWaitingForMoneyStateInsertMoney() {
        vm.selectSnack("Coke");
        vm.insertMoney(2.99);
        assertTrue(vm.getCurrentState() instanceof DispensingSnackState);
    }

    @Test
    void testDispensingSnackWithInsufficientMoney() {
        vm.selectSnack("Cheetos");
        vm.insertMoney(3.00);
        vm.dispenseSnack();
        assertEquals(3, cheetos.getSnackQuantity());
        assertTrue(vm.getCurrentState() instanceof IdleState);
    }

    @Test
    void testDispensingSnackStateDispense() {
        vm.selectSnack("Coke");
        vm.insertMoney(2.99);
        vm.dispenseSnack();
        assertTrue(vm.getCurrentState() instanceof IdleState);
        assertEquals(8, coke.getSnackQuantity());
    }

    @Test
    void testOutOfStockSnack() {
        vm.selectSnack("Snickers");
        vm.insertMoney(2.00);
        vm.dispenseSnack();
        vm.selectSnack("Snickers");
        vm.insertMoney(2.00);
        vm.dispenseSnack();
        assertEquals(0, snickers.getSnackQuantity());
        assertTrue(vm.getCurrentState() instanceof IdleState);
    }

    @Test
    void testDispensingSnackWithChange() {
        vm.selectSnack("KitKat");
        vm.insertMoney(3.00);
        vm.dispenseSnack();
        assertEquals(5, kitkat.getSnackQuantity());
        assertTrue(vm.getCurrentState() instanceof IdleState);
    }


    @Test
    void testRefundScenarioWhenOutOfStock() {
        vm.selectSnack("Snickers");
        vm.insertMoney(2.50);
        vm.dispenseSnack();
        vm.selectSnack("Snickers");
        vm.insertMoney(2.50);
        vm.dispenseSnack();
        assertEquals(0, snickers.getSnackQuantity());
        assertTrue(vm.getCurrentState() instanceof IdleState);
    }

    @Test
    void testSnackDispenseHandlerForMultipleSnacks() {
        SnackDispenseHandler handler = vm.getSnackDispenser();
        handler.handleDispense("Pepsi", 2.99);
        assertEquals(3, pepsi.getSnackQuantity());
        handler.handleDispense("Doritos", 1.50);
        assertEquals(3, doritos.getSnackQuantity());
    }
}