package oop_programing;

public class Worker extends Human implements Comparable<Worker> {
    float salaryPerDay;
    int workedHours;

    public Worker(String firstNameIn, String LastNameIn, float salaryPerDay, int workedHours) {
        super();
        this.salaryPerDay = salaryPerDay;
        this.workedHours = workedHours;
        this.firstName = firstNameIn;
        this.lastName = firstNameIn;
    }

    public float getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(float salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public float getDailySalaryPerHour() {

        return salaryPerDay / workedHours;
    }

    public int compareTo(Worker in) {
        float inSalary = in.getSalaryPerDay();
        if (this.salaryPerDay == inSalary) {
            return 0;
        } else if (this.salaryPerDay > inSalary) {
            return 1;
        } else {
            return -1;
        }
    }
}
