class Clerk extends Employee {

    public Clerk(int age, String name, int months_worked, double salary)
    {
        super(age, name, months_worked, salary);
    }

    @Override
    public String toString() {
        return super.toString() + " How may I help you?";
    }
}