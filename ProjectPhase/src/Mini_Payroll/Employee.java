package Mini_Payroll;

public abstract class Employee {
    protected static  int counter=1;    //to calculate ID
    protected int ID;
    protected String name;
    protected int age;       //String as it would not go into any calculations
    protected double salary;


    public Employee(){
    }

    public abstract double calcSalary();
    public void setName(String N)
    {
        name=N;
    }
    public void setAge(int A)
    {
        age = A;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public void setSalary(double S) { salary=S; }

    public double getSalary()
    {
        return salary;
    }

    public void setID(int c) {
         ID=c;
    }
    public void incCounter(){counter++;}

    public int getID() {
        return ID;
    }

    public static int getCounter() {
        return counter;
    }
}
