package Mini_Payroll;

import Exceptions.*;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Locale;

public class Admin {

    private static Engineer storedEngineer;

    private static Trainee storedTrainee;
    private final static String Username = "Admin";
    private final static String Password = "Admin";

    private  static ArrayList<Engineer> Engineers = new ArrayList<Engineer>();
    private  static ArrayList<Trainee> Trainees = new ArrayList<Trainee>();

    //no argument constructor
    public Admin() {
    }
    // Get method for the manager's username
    public  static String getUsername(){
        return Username;
    }

    public static Engineer getStoredEngineer() {
        return storedEngineer;
    }

    public static void setStoredEngineer(Engineer storedEngineer) {
        Admin.storedEngineer = storedEngineer;
    }

    public static Trainee getStoredTrainee() {
        return storedTrainee;
    }

    public static void setStoredTrainee(Trainee storedTrainee) {
        Admin.storedTrainee = storedTrainee;
    }

    // Get method for the manager's password
    public static String getPassword(){
        return Password;
    }

    // addEngineer method to add a new engineer to the ArrayList
    public Engineer addEngineer(String N, int A, String pos, int WH) throws StringContainsNumberException,
            EngineerAgeException, WorkingHoursException, emptyStringException{

        try{
            checkName(N);
        }
        catch (StringContainsNumberException SCNE){
            throw SCNE;
        }
        catch (emptyStringException ESE){
            throw ESE;
        }

        if (A < 22 || A > 70)
            throw new EngineerAgeException("Engineer Age is Incorrect");

        if(WH< 10 || WH > 400)
            throw new WorkingHoursException("Working Hours is Not Correct");

         Engineer Eng = new Engineer(N, A, pos, WH);
         Engineers.add(Eng);
         return Eng;

    }

    // editEngineer method to edit an existing engineer in the ArrayList
    public void editEngineer (int ID, String Choice, String Value) throws EngineerAgeException,
            PositionNotFoundException, NumberFormatException, WorkingHoursException, StringContainsNumberException, emptyStringException{
        Engineer Eng;

        Eng = findEngineer(ID);

        Choice = Choice.toLowerCase();

        if(Choice.equals("name")) {
            try {
                checkName(Value);
            }
            catch(StringContainsNumberException SCNE){
                throw SCNE;
            }
            catch (emptyStringException ESE){
                throw ESE;
            }
            Eng.setName(Value);
        }
        else if(Choice.equals("age")){
            Integer Val;

            try {
                Val = Integer.parseInt(Value);
            }
            catch (NumberFormatException NFE){
                throw NFE;
            }
            if(Val < 22 || Val > 70)
                throw new EngineerAgeException("Engineer Age is Incorrect");
            else
                Eng.setAge(Val);

        }
        else if(Choice.equals("position")){
           try {
               checkPosition(Value);
           }
           catch(PositionNotFoundException PNFE) {
               throw PNFE;
            }
           Value = Value.toLowerCase();
            Eng.setPosition(Value);
            Eng.calcSalary();
        }
        else if(Choice.equals("working hours")){
            Integer Val;
            try {
                Val = Integer.parseInt(Value);
            }
            catch (NumberFormatException NFE) {
                throw NFE;
            }
            if(Val < 10 || Val > 400)
                throw new WorkingHoursException("Enter Correct Working Hours");
            else {
                Eng.setWorkingHours(Val);
                Eng.calcSalary();
            }
        }
    }


    // findEngineer method via ID
    public Engineer findEngineer(int ID)  {

        for(Engineer Eng: Engineers) {
            if( Eng.getID() == ID) {

                return Eng;
            }
        }
        return null;
    }

    // deleteEngineer method to delete an engineer in the ArrayList
    public void deleteEngineer(int ID) throws NullPointerException{
        Engineer Eng;
        try {
             Eng = findEngineer(ID);
        }
        catch (NullPointerException NPE){
            throw NPE;
        }
        Engineers.remove(Eng);

    }

    // calcSalary method to calculate engineer's salary
    public double calcEngineerSalary(int ID) throws NullPointerException{
        Engineer Eng;
        try{
            Eng = findEngineer(ID);
        }
        catch (NullPointerException NPE){
            throw NPE;
        }
        return Eng.calcSalary();
    }

    // viewEngineers method to return the ArrayList of engineers
    public ArrayList viewEngineers(){
        return Engineers;
    }

    // viewTrainees method to return the ArrayList of trainees
    public ArrayList viewTrainees(){
        return Trainees;
    }

    // findTrainee method a trainee from the ArrayList of trainees
    public Trainee findTrainee(int ID) {
        for(Trainee tra: Trainees) {
            if( tra.getID() == ID) {
                return tra;
            }
        }
        return null;
    }


    // addTrainee method to add a trainee to the ArrayList of trainees
    public Trainee addTrainee(String N, int A,float gpa,String uniName,String academicYear) throws StringContainsNumberException,
            TraineeAgeException, GPAOutOfRangeException, YearNotFoundException, emptyStringException{

        try{
            checkName(N);
            checkName(uniName);
            checkYear(academicYear);
        }
        catch (StringContainsNumberException SCNE){
            throw SCNE;
        }
        catch (YearNotFoundException YNFE){
            throw YNFE;
        }

        if(A < 16 || A > 40)
            throw new TraineeAgeException("Trainee Age is Incorrect");

        if( gpa < 0.01 || gpa > 4)
            throw new GPAOutOfRangeException("GPA is Incorrect");

         Trainee tra = new Trainee(N, A, gpa, uniName, academicYear);
        Trainees.add(tra);
        return tra;

    }
    // editTrainee method to edit an existing trainee in the ArrayList of trainees
    public void editTrainee(int ID, String Choice, String Value) throws NumberFormatException, YearNotFoundException,
            TraineeAgeException, GPAOutOfRangeException, StringContainsNumberException, emptyStringException {
        Trainee tra = findTrainee(ID);

        Choice = Choice.toLowerCase();
        if(Choice.equals("name")) {
            try{
                checkName(Value);
                tra.setName(Value);
            }
            catch (StringContainsNumberException SCNE){
                throw SCNE;
            }
            catch (emptyStringException ESE){
                throw ESE;
            }

        }
        else if(Choice.equals("age")){
            Integer Val;
            try {
                Val = Integer.parseInt(Value);

            }
            catch (NumberFormatException NFE){
                throw NFE;
            }
            if(Val < 16 || Val > 40)
                throw new TraineeAgeException("Trainee Age is Incorrect");
            else
                tra.setAge(Val);
        }
        else if(Choice.equals("gpa")){
            Float Val;
            try {
                Val = Float.parseFloat(Value);
            }
            catch(NumberFormatException NFE){
                throw NFE;
            }
            if( Val < 0.01 || Val > 4)
                throw new GPAOutOfRangeException("GPA is Incorrect");
            else
                tra.setGpa(Val);
        }
        else if(Choice.equals("university name")){
            try {
                checkName(Value);
            }
            catch (StringContainsNumberException SCNE){
                throw SCNE;
            }
            catch (emptyStringException ESE){
                throw ESE;
            }
            tra.setUni(Value);
        }
        else if(Choice.equals("academic year")) {
            try{
                checkYear(Value);
            }
            catch (YearNotFoundException YNFE){
                throw YNFE;
            }
            tra.setYear(Value);
        }

    }


    // deleteTrainee method to delete a trainee from the ArrayList of trainees
    public  void deleteTrainee(int ID) throws NullPointerException{
        Trainee tra;
        try {
            tra = findTrainee(ID);
        }
        catch(NullPointerException NPE){
            throw NPE;
        }
        Trainees.remove(tra);

    }

    public double calcTraineeSalary() {
        Trainee tra= new Trainee();
        return tra.calcSalary();
    }

    private void checkName(String name) throws StringContainsNumberException, emptyStringException{
        char[] charArray = name.toCharArray();
        boolean isNumber = false;
        boolean isEmpty = false;

        if(charArray.length == 0){
            isEmpty = true;
            throw new emptyStringException("Empty String!");
        }

        for(char c: charArray){
            if(Character.isDigit(c)){
                isNumber = true;
            }
        }
        if(isNumber == true){
            throw new StringContainsNumberException("String Contains Number!");
        }
    }

    private void checkYear(String Year) throws YearNotFoundException{
        Year = Year.toLowerCase();
        boolean correctYear = false;
        if(Year.equals("freshman") || Year.equals("sophomore") || Year.equals("junior") || Year.equals("senior 1") || Year.equals("senior 2")) {
            correctYear = true;
        }
        if(correctYear == false){
            throw new YearNotFoundException("Incorrect Academic Year");
        }

    }

    private void checkPosition(String Value) throws PositionNotFoundException{
        boolean found = false;

        for(Grade pos: Grade.values()) {
            if( Value.equalsIgnoreCase(pos.getPosition()) )
            {
                found = true;
            }
        }
        if(found == false) {
            throw new PositionNotFoundException("Position is Not Available");
        }
    }


}


