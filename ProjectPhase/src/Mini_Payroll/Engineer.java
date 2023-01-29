package Mini_Payroll;

public class Engineer extends Employee{
    private int workingHours;
    private String position;
    // Create no argument for Engineer object
    public Engineer(){

    }

    // Create construction for Engineer object
    public Engineer(String N, int A, String pos, int WH)
    {
        name = N;
        age = A;
        pos = pos.toLowerCase();
        position = pos;
        workingHours = WH;
        ID = getCounter();
        incCounter();
        calcSalary();

    }

    // Setter method for the working hours
    public void setWorkingHours(int WH)
    {
        workingHours=WH; }

    // Getter method for the working hours
    public int getWorkingHours()
    {
        return workingHours; }

    // Setter method for position
    public void setPosition(String pos){
        position=pos;
    }

    // Getter method for position
    public String getPosition(){
        return position; }

    // calcSalary method for calculating the salary
    public double calcSalary() {
        double TaxRate=0;
        double PayRate=0;
        for(Grade pos:Grade.values()) {
            String tempPos = pos.getPosition().toLowerCase();
            if( position.equals(tempPos) )
            {
                PayRate= pos.getPayRate();
                TaxRate= pos.getTaxRate();
            }
        }
        double s = (workingHours * PayRate) * (1-TaxRate);  //Salary Calculation Function
        salary = s;
        return s;
    }

    //Override toString method
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %s, Salary: %.1f, Position: %s, " +
                "Working Hours: %d \n",ID , name, age, salary, position, workingHours);

    }
}
