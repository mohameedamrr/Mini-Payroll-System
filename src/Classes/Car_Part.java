package Classes;
public class Car_Part {

    private String Description;
    private double Price;

    private int NumberOfParts;

    private static int Doors;
    private static int Headlights;
    private static int Bumpers;


    public Car_Part(String description, double price, int numberOfparts) {
        Description = description;
        Price = price;
        NumberOfParts = numberOfparts;

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setNumberOfParts(int numberOfParts) {
        NumberOfParts = numberOfParts;
    }

    public int getNumberOfParts() {
        return NumberOfParts;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void CountDoors(){
        Doors++;
    }
    public void CountHeadlights(){
        Headlights++;
    }
    public void CountBumpers(){
        Bumpers++;
    }

    public String toString(){
        return "Description: " + Description +" Price: " + Price +" Quantity: " +NumberOfParts;

    }
}
