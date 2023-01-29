package Classes;

import java.util.ArrayList;

public class HR extends Employee{

    private final static String username = "Hr";
    private final static String password = "Admin";

    public HR(){
    }

    public HR(String Name, int Age, String Address, double Salary,int ID) {
        this.Name = Name;
        this.Age = Age;
        this.Address = Address;
        Department = "HR";
        this.Salary = Salary;
        this.ID = ID;
        Employees.add(this);
    }

    public double getSalary() {
        return Salary;
    }

    public static String getUsername() { return username; }

    public static String getPassword() { return password; }


    public static ArrayList viewEmployeeList() {
        return Employees;
    }

    public void editEmployeeList(Employee emp, String choice, String value) {
        choice = choice.toLowerCase();
        if(choice.equals("name")) {
            emp.setName(value);
        }
        else if (choice.equals("age")) {
            int temp = Integer.parseInt(value);
            emp.setAge(temp);
        }
        else if (choice.equals("address")) {
            emp.setAddress(value);
        }
        else if (choice.equals("department")) {
            emp.setDepartment(value);
        }
        else if (choice.equals("salary")) {
                double temp = Double.parseDouble(value);
            emp.setSalary(temp);
        }
    }

    public Employee findEmployee(int ID) {
        for(Employee emp: Employees) {
            if(emp.getID() == ID) {
                return emp;
            }
        }
        return null; // ERROR IF NOT FOUND
    }

    public  void addEmployee(String Name, int Age, String Address, double Salary,int ID, String Department) {
        Department = Department.toLowerCase();

        if (Department.equals("hr")) {
                HR HR11 = new HR(Name, Age, Address, Salary, ID);
        }
        else if (Department.equals("logistics")) {
            Logistics log111 = new Logistics(Name, Age, Address, Salary, ID);
        }
        else if (Department.equals("service")) {
            Service ser111 = new Service(Name, Age, Address, Salary, ID);
        }
        else if (Department.equals("sales")) {
            Sales sal111 = new Sales(Name, Age, Address, Salary, ID);
        }
        else if (Department.equals("manager")) {
            Manager man111 = new Manager(Name, Age, Address, Salary, ID);
        }
    }

    public void deleteEmployee(Employee emp) {


            Employees.remove(emp);

    }

}
