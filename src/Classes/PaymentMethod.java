package Classes;

import java.util.*;
public class PaymentMethod {
    private  String paymentType;

    private  String transactionType;
    private  double amount;
    ArrayList<PaymentMethod> paymentList = new ArrayList<>(); //في ليالي الابطال لا مثيل للريال

    public PaymentMethod() {
    }

    public PaymentMethod(String paymentType, double amount, String transactionType) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.transactionType = transactionType;
        paymentList.add(this);
    }

    public  String getPaymentType() {
        return paymentType;
    }

    public  double getAmount() {return amount;}

    public  String getTransactionType() {
        return transactionType;
    }

    public ArrayList viewPaymentList(){return paymentList;}

    @Override
    public String toString() {
        return "PaymentMethod{" +
                " Payment Type: " + paymentType + '\'' +
                " Transaction Type: " + transactionType + '\'' +
                " Amount: " + amount +
                '}';
    }
}
