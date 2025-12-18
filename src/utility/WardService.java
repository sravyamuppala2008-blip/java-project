package utility;

import data.Ward;

public class WardService {

    public void showWardStatus() {
        System.out.println("Total Beds: " + Ward.totalBeds);
        System.out.println("Occupied Beds: " + Ward.occupiedBeds);
        System.out.println("Available Beds: " + (Ward.totalBeds - Ward.occupiedBeds));
    }
}