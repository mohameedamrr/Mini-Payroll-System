package Mini_Payroll;

public enum Grade {
    A("Manager",0.4,100),
    B("Department Manager",0.35, 85),
    C("Project Manager", 0.3, 75),
    D("Team Leader",0.25,50),
    E("Team Member",0.2,35);
    private final double TaxRate;
    private final double PayRate;
    private final String Position;
    Grade(String pos ,double TR, double PR)
    {
        TaxRate=TR;
        PayRate=PR;
        Position=pos;
    }
    public double getTaxRate()
    {
     return TaxRate;
    }
    public double getPayRate()
    {
        return PayRate;
    }

    public String getPosition()
    {
        return Position;
    }
}
