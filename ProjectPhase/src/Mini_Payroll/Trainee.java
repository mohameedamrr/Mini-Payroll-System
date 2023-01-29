package Mini_Payroll;

public class Trainee extends Employee {
    private float GPA;
    private String Uni;
    private String academicYear;

    //Create empty constructor for trainee
    public Trainee(){
    }

    // Create constructor with parameters for trainee
    public Trainee(String N, int A,float gpa,String uniName,String academicYear){
        name = N;
        age = A;
        this.GPA = gpa;
        Uni = uniName;
        this.academicYear = academicYear;
        ID = getCounter();
        incCounter();
        salary = 1200;

    }
    //Getter method for the GPA
    public float getGpa(){
        return GPA;
    }

    //Getter method for the GPA
    public String getUni(){
        return Uni;
    }

    //Getter method for the year
    public String getYear(){
        return academicYear;
    }

    //Setter method for the GPA
    public void setGpa(float gpa) {
        this.GPA = gpa;
    }

    //Setter method for university
    public void setUni(String Uni) {
       this.Uni = Uni;
    }

    //Setter method for year
    public void setYear(String year) {
        this.academicYear = year;
    }



    //calcSalary method to calculate salary for trainee
    public double calcSalary(){
        return 1200.0;
    }

    //Override toString method
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %s, Salary: %.1f, University: %s," +
                " Academic Year: %s, GPA: %s \n",ID , name, age, salary, Uni, academicYear, GPA);
    }
}
