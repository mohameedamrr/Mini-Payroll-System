package Classes;

import java.util.ArrayList;

import java.util.ArrayList;
public class Logistics extends Employee
{

    private static ArrayList<Car_Model> Car =  new ArrayList<Car_Model>();
    private static ArrayList<Car_Part> Car_Part =  new ArrayList<Car_Part>();
    private final static String Username="Logistics";
    private final static String Password="Admin";

    public static ArrayList viewCars()
    {
        return Car;
    }
    public static ArrayList viewParts()
    {
        return Car_Part;
    }
    public Logistics(){}

    public Logistics(String Name, int Age, String Address, double Salary,int ID) {
        this.Name = Name;
        this.Age = Age;
        this.Address = Address;
        Department = "Logistics";
        this.Salary = Salary;
        this.ID = ID;
        Employees.add(this);

    }
    public static String getUsername(){return Username;}
    public static String getPassword(){return Password;}
    public void addCar(String name, double price, int year, String model, String description, String type,String Color, int Quantity)
    {
        boolean check=false;
        for (Car_Model ez : Car)
        {
           if (ez.getModel().equals(model) && ez.getYear()==year && ez.getDescription().toLowerCase().equals(description.toLowerCase()) && ez.getType().equals(type) && ez.getColor().equals(Color) && ez.getPrice()==price)
           {
               ez.setQuantity(ez.getQuantity()+Quantity);
               check = true;
           }
        }
        if(check == false) {
            Car_Model carModel = new Car_Model(name,price,year,model,description,type,Color,Quantity);
            Car.add(carModel);
        }





    }

    public void addPart(String description, double price,int numberOfParts)
    {
        boolean check=false;
        for (Car_Part ez : Car_Part)
            {
                if (ez.getDescription().equals(description) && ez.getPrice()==price)
                {
                    ez.setNumberOfParts(ez.getNumberOfParts()+numberOfParts);
                    check = true;
                }
            }
        if (check == false) {
            Car_Part parts = new Car_Part(description, price, numberOfParts);
            Car_Part.add(parts);
        }
    }
    public void changePrice(Car_Model carModel,double price) {
                carModel.setPrice(price);
    }
    public static Car_Model findCar(String CarModel) {
        for(Car_Model ez: Car) {
            if (ez.getModel().equals(CarModel)) {
                return ez;
            }
        }
        return null;
    }

   /* public static Car_Model findCar(Car_Model CarModel) {
        for(Car_Model ez: Car) {
            if (ez.getModel().equals(CarModel)) {
                return ez;
            }
        }
        return null;
    }*/

    public static Car_Part findPart(String CarPart) {
        for(Car_Part ez: Car_Part) {
            if (ez.getDescription().equals(CarPart)) {
                return ez;
            }
        }
        return null;
    }
   /*public void deleteCar(String CarModel)
    {
        Car_Model ez = findCar(CarModel);
        if (ez.getQuantity()==1) {
            Car.remove(ez);
        }
        else {
            ez.setQuantity(ez.getQuantity() - 1);
        }
    }*/
}
