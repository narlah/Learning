package oop_programing;

public class Student extends Human implements Comparable<Student> {
    int ocenka;

    public Student(String firstNameIn, String LastNameIn, int ocenka) {
        super();
        this.ocenka = ocenka;
        this.firstName = firstNameIn;
        this.lastName = firstNameIn;
    }

    public int getOcenka() {
        return ocenka;
    }

    public void setOcenka(int ocenka) {
        this.ocenka = ocenka;
    }

    public int compareTo(Student in) {
        int inOcenka = in.getOcenka();
        if (this.ocenka == in.getOcenka()) {
            return 0;
        } else if (this.ocenka > inOcenka) {
            return 1;
        } else {
            return -1;
        }

    }
}
