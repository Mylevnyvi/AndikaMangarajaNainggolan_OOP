public class Vehicles {

    private String brand;
    private double payRate;
    private final int EMPLOYEE_ID;

    private static int nextID = 1000;

    public static final double STARTING_PAY_RATE = 7.75;

    public Employee(String brand) {
        this.brand = brand;
        EMPLOYEE_ID = getNextID();
        payRate = STARTING_PAY_RATE;
    }

    public Employee(String name, double startingPay) {
        this.brand = name;
        EMPLOYEE_ID = getNextID();
        payRate = startingPay;
    }

    public String getName() { return brand; }

    public int getEmployeeID() { return EMPLOYEE_ID; }

    public double getPayRate() { return payRate; }

    public void changeName(String newName) { brand = newName; }

    public void changePayRate(double newRate) { payRate = newRate; }

    public static int getNextID() {
        int id = nextID;
        nextID++;
        return id;
    }
}
