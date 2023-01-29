package Classes;

import java.util.ArrayList;

public class Manager extends Employee{

    private final static String username = "Manager";
    private final static String password = "Admin";

    public Manager() {
    }

    public Manager(String Name, int Age, String Address, double Salary,int ID) {
        this.Name = Name;
        this.Age = Age;
        this.Address = Address;
        Department = "Manager";
        this.Salary = Salary;
        this.ID = ID;
        Employees.add(this);
    }

    public ArrayList ViewSalesRecords() {
            return SalesRecord.viewSalesRecords();
    }

    public ArrayList viewStock(String choice) {
        choice.toLowerCase();
        if(choice.equals("cars"))
            return Logistics.viewCars();
        else if(choice.equals("car parts"))
            return Logistics.viewParts();
        else
            return null;
    }

    public ArrayList viewMaintenance(){
            return Service.viewAppointments();
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public ArrayList viewEmployees(){
        return HR.viewEmployeeList();
    }


}
