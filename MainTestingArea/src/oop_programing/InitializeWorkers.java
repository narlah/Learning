package oop_programing;

import java.util.Arrays;

public class InitializeWorkers {
    public static void main(String[] args) {
        Worker[] data = new Worker[10];

        data[1] = (new Worker("Ivan1", "Draganov", 121, 8));
        data[2] = (new Worker("Ivan2", "Draganov2", 123123, 12));
        data[3] = (new Worker("Ivan3", "Draganov", 13123, 1));
        data[4] = (new Worker("Ivan4", "Draganov", 88, 13));
        data[5] = (new Worker("Ivan5", "Draganov", 1, 1));

        data[6] = (new Worker("Ivan6", "Draganov", 13, 17));
        data[7] = (new Worker("Ivan7", "Draganov", 122, 99));
        data[8] = (new Worker("Ivan8", "Draganov", 989891.1f, 1));
        data[9] = (new Worker("Ivan9", "Draganov", 12, 9));
        data[0] = (new Worker("Ivan10", "Draganov", 10, 9));
        Arrays.sort(data);
        for (Worker aData : data) {
            System.out.printf("Worker %s %s have daily salary %f\n", aData.getFirstName(), aData.getLastName(),
                    aData.getSalaryPerDay());
        }

    }

}
