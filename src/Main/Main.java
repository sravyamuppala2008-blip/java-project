package Main;

import service.PatientService;
import service.BillingService;
import utility.WardService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PatientService ps = new PatientService();
        BillingService bs = new BillingService();
        WardService ws = new WardService();

        while (true) {
            System.out.println("\n--- Hospital Patient Record System ---");
            System.out.println("1. Admit Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. View Patients");
            System.out.println("4. Generate Bill");
            System.out.println("5. Ward Status");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> ps.admitPatient();
                case 2 -> ps.updatePatient();
                case 3 -> ps.viewPatients();
                case 4 -> bs.generateBill();
                case 5 -> ws.showWardStatus();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}