package Classes;

public class Car_Model {
    private String Name;
    private double price;
    private int Year;
    private String Model;
    private String Description;
    private String Type;

    private String Color;
    private int quantity;

    private static int NumOfCars;


    public Car_Model() {
    }
    public Car_Model(String name, double price, int year, String model, String description, String type, String Color, int Quantity) {
        Name = name;
        this.price = price;
        Year = year;
        Model = model;
        Description = description;
        Type = type;
        this.Color = Color;
        this.quantity = Quantity;
        NumOfCars++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return Type;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setNumOfCars(int numOfCars) {
        NumOfCars = numOfCars;
    }

    public  int getNumOfCars() {
        return NumOfCars;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String toString() {
        return "Car_Model{" +
                " Name: " + Name +
                " price: " + price +
                " Year: " + Year +
                " Model: " + Model +
                " Description: " + Description +
                " Type: " + Type +
                " Color: " + Color +
                " Quantity: " + quantity +
                '}';
    }
}
