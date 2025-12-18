package service;

import data.Patient;
import data.Ward;

import java.io.*;
import java.util.Scanner;

public class PatientService {

    static final String FILE = "patients.csv";

    public void admitPatient() throws IOException {
        Scanner sc = new Scanner(System.in);

        if (!Ward.isAvailable()) {
            System.out.println("No ward available.");
            return;
        }

        System.out.print("Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        Patient p = new Patient(id, name, age, gender, contact);

        FileWriter fw = new FileWriter(FILE, true);
        fw.write(p.toString() + "\n");
        fw.close();

        Ward.occupiedBeds++;
        System.out.println("Patient admitted successfully.");
    }

    public void viewPatients() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;

        System.out.println("Patient Records:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public void updatePatient() throws IOException {
        Scanner sc = new Scanner(System.in);
        File file = new File(FILE);
        File temp = new File("temp.txt");

        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(file));
        FileWriter fw = new FileWriter(temp);

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) == id) {
                found = true;

                System.out.print("Update Contact: ");
                data[4] = sc.nextLine();

                System.out.print("Update Stay Days: ");
                data[5] = sc.nextLine();

                fw.write(String.join(",", data) + "\n");
            } else {
                fw.write(line + "\n");
            }
        }

        br.close();
        fw.close();

        file.delete();
        temp.renameTo(file);

        if (found)
            System.out.println("Patient updated successfully.");
        else
            System.out.println("Patient not found.");
    }
}