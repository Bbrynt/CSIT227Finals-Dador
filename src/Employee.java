abstract class Employee extends Person {
    int months_worked;
    double salary;

    public Employee(int age, String name, int months_worked, double salary)
    {
        super(age, name);
        this.months_worked = months_worked;
        this.salary = salary;
    }

    public int getMonths_worked() {
        return months_worked;
    }

    public void setMonths_worked(int months_worked)
    {
        this.months_worked = months_worked;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public double thirteenthmonth()
    {
        return salary / (double) (12.0 / months_worked);
    }
}