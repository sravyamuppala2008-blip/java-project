package data;

public class Ward {
    public static int totalBeds = 10;
    public static int occupiedBeds = 0;

    public static boolean isAvailable() {
        return occupiedBeds < totalBeds;
    }
}