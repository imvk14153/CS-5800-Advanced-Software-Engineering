package Question1;

public class HourlyEmployee extends Employee{
    private double wage;
    private double noOfHoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double noOfHoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.noOfHoursWorked = noOfHoursWorked;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getNoOfHoursWorked() {
        return noOfHoursWorked;
    }

    public void setNoOfHoursWorked(double noOfHoursWorked) {
        this.noOfHoursWorked = noOfHoursWorked;
    }

    @Override
    public String print() {
        return super.print() + String.format("Wage: $%.2f\nHours Worked: %.2f\n", wage, noOfHoursWorked);
    }
}
