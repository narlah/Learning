package oop_programing;

import java.util.Arrays;

public class InitializeStudents {
    public static void main(String[] args) {
        Student[] data = new Student[10];
        ;
        data[1] = (new Student("Ivan1", "Draganov", 2));
        data[2] = (new Student("Ivan2", "Draganov2", 3));
        data[3] = (new Student("Ivan3", "Draganov", 6));
        data[4] = (new Student("Ivan4", "Draganov", 4));
        data[5] = (new Student("Ivan5", "Draganov", 1));

        data[6] = (new Student("Ivan6", "Draganov", 3));
        data[7] = (new Student("Ivan7", "Draganov", 4));
        data[8] = (new Student("Ivan8", "Draganov", 8));
        data[9] = (new Student("Ivan9", "Draganov", 9));
        data[0] = (new Student("Ivan10", "Draganov", 10));
        Arrays.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Student %s %s have ocenka %d\n", data[i].getFirstName(), data[i].getLastName(),
                    data[i].getOcenka());
        }

    }

}
