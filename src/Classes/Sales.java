package Classes;

import java.util.ArrayList;

public class Sales extends Employee {

    private static final String Username = "Sales";
    private static final String Password = "Admin";
    private Customer customer;
    private static Car_Model carModel;

    ArrayList <Customer> CustomersList = new ArrayList<Customer> ();


    public Sales() {

    }


    public Sales(String Name, int Age, String Address, double Salary, int ID) {
        this.Name = Name;
        this.Age = Age;
        this.Address = Address;
        Department = "Sales";
        this.Salary = Salary;
        this.ID = ID;
        Employees.add(this);
    }

    public ArrayList viewCars() {
        return Logistics.viewCars();
    }

    public static String getUsername(){return Username;}
    public static String getPassword(){return Password;}

    public String sellCar(String CarModel, String paymentType, double amount,String Name,String Address,int Age,int NationalId) {

        Car_Model x =  Logistics.findCar(CarModel);
        if (x.getQuantity() == 0) {
            return "not available in stock";
        } else {
            x.setQuantity(x.getQuantity() - 1);
            PaymentMethod p1 = new PaymentMethod(paymentType, amount, "Car");
            Customer c=new Customer(Name,Address,Age,NationalId,x);
            CustomersList.add(c);
            new SalesRecord(c,p1);

            return "Sold";
        }
    }

    public void storeCar(Car_Model car){
        carModel = car;
    }
    public Car_Model returnCar(){
        return carModel;
    }

}
