package Classes;

import java.util.ArrayList;

public class SalesRecord {



    private  Customer cus1;
    private  PaymentMethod p1;

    private static ArrayList<SalesRecord> SRecords = new ArrayList<SalesRecord>();

    public SalesRecord(){
    }

    public SalesRecord(Customer cus1, PaymentMethod p1) {
        this.cus1 = cus1;
        this.p1 = p1;
        SRecords.add(this);
    }

    public static ArrayList viewSalesRecords() {
        return SRecords;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                " cus1: " + cus1 +
                " Payment Method: " + p1 +
                '}';
    }

    public Customer getCus1() {
        return cus1;
    }

    public void setCus1(Customer cus1) {
        this.cus1 = cus1;
    }

    public  PaymentMethod getP1() {
        return p1;
    }

    public void setP1(PaymentMethod p1) {
        this.p1 = p1;
    }

    public static ArrayList<SalesRecord> getSRecords() {
        return SRecords;
    }

    public void setSRecords(ArrayList<SalesRecord> SRecords) {
        SalesRecord.SRecords = SRecords;
    }

    public String getName(){
        return cus1.getName();
    }

    public String getAddress() {
        return cus1.getAddress();
    }

    public int getAge(){
        return cus1.getAge();
    }

    public int getNationalID(){
        return cus1.getNationalId();
    }

    public String getCarModel(){
        return cus1.getCarModel();
    }

    public String getPaymentType(){
        return p1.getPaymentType();
    }

    public String getTransactionType(){
        return p1.getTransactionType();
    }

    public double getAmount(){
        return p1.getAmount();
    }


}
