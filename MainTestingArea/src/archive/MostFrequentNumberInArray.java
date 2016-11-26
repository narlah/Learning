package archive;

import java.util.*;

public class MostFrequentNumberInArray {
    class FrequencyMatrix {
        private int[] massive = null;
        private String currentName = null;

        // Inner class - holds the frequency and the positions where the
        // most frequent element occurs
        private class Element {
            private int frequency = 0;
            private ArrayList<Integer> positions = new ArrayList<Integer>();

            public Element(int freq) {
                this.frequency = freq;
            }

            public void increaseFreuencyByOne() {
                frequency++;
            }

            public void addPosition(int pos) {
                positions.add(pos);
            }
        }

        HashMap<Integer, Element> hashMap = new HashMap<Integer, Element>();

        public FrequencyMatrix(int[] inputCurrent, String name) { //constructor
            if (inputCurrent == null || inputCurrent.length == 0 || name == null) {
                String defaultName = name == null ? "Frequency Matrix" : name;
                System.out.printf("\n********\n%S invalid, constructor failed!\n\n", defaultName);
            } else {
                this.massive = inputCurrent;
                this.currentName = name;
            }
        }

        //Fills the hashmap with frequencies and positions
        public void findCurrent() {
            if (massive == null || massive.length == 0) {
                System.out.println("No valid frequency matrix - invalid parameters.");
                return;
            }

            for (int i = 0; i < massive.length; i++) {
                if (hashMap.containsKey(massive[i])) {
                    hashMap.get(massive[i]).increaseFreuencyByOne();
                    hashMap.get(massive[i]).addPosition(i);
                } else {
                    Element el = new Element(1);
                    el.addPosition(i);
                    hashMap.put(massive[i], el);
                }
            }
        }

        public void printCurrent() {
            int size = hashMap.size();
            if (size == 0) {
                System.out.println("Some error occured , the result is empty.");
            } else {
                int maxFrequency = 0, maxKey = 0;
                Iterator<Integer> iterator = hashMap.keySet().iterator();
                while (iterator.hasNext()) {
                    Integer currentKey = iterator.next();
                    Element element = hashMap.get(currentKey);
                    if (element.frequency > maxFrequency) {
                        maxFrequency = element.frequency;
                        maxKey = currentKey;
                    }
                }
                Element maxElement = hashMap.get(maxKey);
                System.out.println("************");
                System.out.println(currentName);
                System.out.printf("Element %d has frequency %d \n", maxKey, maxElement.frequency);
                System.out.println("Positions in the array :"
                        + Arrays.toString(maxElement.positions.toArray()));
            }
        }
    }

    public static void main(String[] args) { // Testing Method
        MostFrequentNumberInArray Enclosing = new MostFrequentNumberInArray();
        int[] testNormal = {4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3};
        FrequencyMatrix freqMatrx = Enclosing.new FrequencyMatrix(testNormal,
                "����� ������,  �������� ������");
        freqMatrx.findCurrent();
        freqMatrx.printCurrent();
        // Single element
        int[] singleElementTest = {1};
        FrequencyMatrix currenSingleElement = Enclosing.new FrequencyMatrix(singleElementTest,
                "�������� �������");
        currenSingleElement.findCurrent();
        currenSingleElement.printCurrent();
        System.out.println();
        System.out.println(Arrays.toString(singleElementTest));
        // Mass test
        Random rand = new Random();
        final int MASS_TEST_NUM = 10000;
        int[] massTestMatrix = new int[MASS_TEST_NUM];
        for (int j = 0; j < MASS_TEST_NUM; j++) {
            massTestMatrix[j] = rand.nextInt(1000);
        }

        FrequencyMatrix massTestCurrent = Enclosing.new FrequencyMatrix(massTestMatrix,
                "����� ���� � 10000 �������� (1-1000)!");
        massTestCurrent.findCurrent();
        massTestCurrent.printCurrent();
        System.out.println();
        System.out.println(Arrays.toString(massTestMatrix));
        // Empty element, no name
        FrequencyMatrix currenEmptyElement = Enclosing.new FrequencyMatrix(null, null);
        currenEmptyElement.findCurrent();
        currenEmptyElement.printCurrent();

    }
}
