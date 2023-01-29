package Classes;

public class appointments {
    private String customerName;
    private int phoneNumber;
    private String carType;
    private String appDate;

    private String PaymentType;

    private double Amount;

    public appointments() {

    }

    public appointments(String name, String date, String cartype, int phonenumber, String PaymentType, double Amount) {
        this.customerName=name;
        this.appDate=date;
        this.carType=cartype;
        this.phoneNumber=phonenumber;
        this.Amount = Amount;
        this.PaymentType=PaymentType;

    }

    public void setName(String name) {
        this.customerName = name;
    }

    public void setDate(String date) {
        this.appDate = date;
    }

    public void setCartype(String cartype) {
        this.carType = cartype;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getAppDate() {
        return appDate;
    }

    public String getCartype() {
        return carType;
    }

    public String getName() {
        return customerName;
    }


    public String toString(){
        return "name is:"+customerName + "date is :"+ appDate +"car is:"+carType +"phone is: " +phoneNumber +"\n";
    }
}
