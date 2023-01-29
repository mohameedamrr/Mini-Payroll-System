package Classes;

import java.util.ArrayList;
public class Service extends Employee {
    private final static String Username = "Service";
    private final static String Password = "Admin";

    public Service() {

    }

    public Service(String Name, int Age, String Address, double Salary, int ID) {
        this.Name = Name;
        this.Age = Age;
        this.Address = Address;
        Department = "Service";
        this.Salary = Salary;
        this.ID = ID;
        Employees.add(this);
    }

    public static String getUsername() {
        return Username;
    }

    public static String getPassword() {
        return Password;
    }

    public static ArrayList<appointments> appointment = new ArrayList<appointments>();

    public static ArrayList viewAppointments() {
        return (appointment);
    }

    public static void addAppointment(String customerName, String date, String carType, int phoneNumber, String paymentType, double amount) {
        appointments a = new appointments(customerName, date, carType, phoneNumber, paymentType, amount);
        PaymentMethod p2 = new PaymentMethod(paymentType, amount, "Appointment");
        appointment.add(a);


    }

    public static boolean checkDate(String date) {
        for (appointments app : appointment) {
            if (app.getAppDate().equals(date)) {
                return true;
            }
        }
        return false;
    }
}