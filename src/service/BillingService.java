package service;

import data.Bill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BillingService {

    public void generateBill() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        System.out.print("Amount per day: ");
        double amount = sc.nextDouble();

        BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) == id) {
                int days = Integer.parseInt(data[5]);

                Bill bill = new Bill(id, days, amount);

                System.out.println("---- Bill ----");
                System.out.println("Patient ID: " + id);
                System.out.println("Days Stayed: " + days);
                System.out.println("Total Amount: ₹" + bill.totalAmount);
                break;
            }
        }
        br.close();
    }
}