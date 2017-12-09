package archive;

import java.util.HashMap;

public class NamesCountQuestionTest1 {
    private int count = 0;
    private HashMap<String, Integer> counts = new HashMap<String, Integer>();

    public static void main(String[] args) {
        NamesCountQuestionTest1 namesCount = new NamesCountQuestionTest1();

        namesCount.addName("James");
        namesCount.addName("John");
        namesCount.addName("Mary");
        namesCount.addName("Mary");

        System.out.println("Fraction of Johns: " + namesCount.nameProportion("John"));
        System.out.println("Fraction of Marys: " + namesCount.nameProportion("Mary"));
    }

    /**
     * Adds the name.
     *
     * @param name Name.
     */
    public void addName(String name) {
        Integer nameCount = counts.get(name);
        if (nameCount == null)
            nameCount = 1;
        else
            nameCount++;

        count++;
        counts.put(name, nameCount);
    }

    /**
     * Returns proportion of parameter name in all calls to addName.
     *
     * @param name Name.
     * @return Double in interval [0, 1]. Returns 0 if AddName has not been
     * called.
     */
    public double nameProportion(String name) {
        Integer numberOfOccurences = counts.get(name);
        if (count == 0 || name.isEmpty() || numberOfOccurences == null) {
            return 0;
        }
        return numberOfOccurences.doubleValue() / (double) count;
    }
}