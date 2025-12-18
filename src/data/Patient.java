package data;

import java.io.Serializable;

public class Patient implements Serializable {
    public int patientId;
    public String name;
    public int age;
    public String gender;
    public String contact;
    public int stayDays;

    public Patient(int patientId, String name, int age, String gender, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.stayDays = 0;
    }

    @Override
    public String toString() {
        return patientId + "," + name + "," + age + "," + gender + "," + contact + "," + stayDays;
    }
}