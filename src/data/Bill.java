package data;

public class Bill {
    public int patientId;
    public int stayDays;
    public double perDayAmount;
    public double totalAmount;

    public Bill(int patientId, int stayDays, double perDayAmount) {
        this.patientId = patientId;
        this.stayDays = stayDays;
        this.perDayAmount = perDayAmount;
        this.totalAmount = stayDays * perDayAmount;
    }
}