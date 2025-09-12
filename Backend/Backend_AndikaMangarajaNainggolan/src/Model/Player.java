package Model;
import java.time.LocalDateTime;
import java.util.UUID;

public class Player {


    private String username;
    private double payRate;
    private final int highscore;
    private final int totalcoins = 0;
    private final int totaldistance = 0;
    private final class LocalDateTime;

    public static void playerID(String[] args) {
        UUID playerID = UUID.randomUUID();
        String uuidAsString = playerID.toString();

        System.out.println("Your UUID is: " + uuidAsString);
    }

    private static void main(String[] args)
    {
        LocalDateTime createdAt = LocalDateTime.createdAt();
        System.out.println(createdAt);}


    public Player(String username) {
        this.username = username;
    }
    private static int newScore;

    public Player(String name, double startingPay) {
        this.username = name;
       highscore = getnewScore();
        payRate = startingPay;
    }

    public String getName() { return username; }

    public int getEmployeeID() { return playerID(String[] args); }

    public double getPayRate() { return payRate; }

    public void changeName(String newName) { username = newName; }

    public void changePayRate(double newRate) { payRate = newRate; }

    public static int getnewScore() {
        int id = newScore;
        return id;
    }
}
