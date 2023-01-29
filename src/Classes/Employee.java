package Classes;

import java.util.ArrayList;

public abstract class Employee {
    protected String Name;
    protected int Age;
    protected String Address;
    protected String Department;
    protected double Salary;
    protected int ID;
    protected static ArrayList<Employee> Employees = new ArrayList<Employee>();

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    public String getDepartment() {
        return Department;
    }

    public double getSalary() {
        return Salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString(){
        return " Name is:" + Name + " ID is:"+ ID + " Age is: "+ Age +" Address is: " + Address + " Department is: "+ Department + " Salary is: " + Salary +"\n";
    }
}
