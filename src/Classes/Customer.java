package Classes;

public class Customer
{
private  String Name;
private  String Address;
private  int Age;
private  int NationalId;
private  Car_Model carModel;
    public Customer(){}
    public Customer(String N, String A, int G , int I , Car_Model CM)
    {
        Name=N;
        Address=A;
        Age=G;
        NationalId=I;
        carModel=CM;
    }

    public  String getName() {
        return Name;
    }

    public  void setName(String name) {
        Name = name;
    }

    public  String getAddress() {
        return Address;
    }

    public  void setAddress(String address) {
        Address = address;
    }

    public  int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public  int getNationalId() {
        return NationalId;
    }

    public  void setNationalId(int nationalId) {
        NationalId = nationalId;
    }

    public  String getCarModel() {
        return carModel.getModel();
    }

    public  void setCarModel(Car_Model CarModel) {
        carModel = CarModel;
    }
public String toString()
{
    return "Name : "+ Name + "Age : " + Age + " Address : " + "NationalID :" + NationalId + " Car Model :" + carModel.getModel();
}
}
