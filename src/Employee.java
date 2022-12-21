public class Employee extends Person{
    private int months_worked;
    private double salary;

    Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;
    }
    public int getMonths_worked(){
        return months_worked;
    }

    public void setMonths_worked(int months_worked) {
        this.months_worked = months_worked;
    }
    public double getSalary() {
        return salary;
    }
    public double thirteenthmonth() {
         return salary / (12/ months_worked);
    }
}
