package junitLearning;

import archive.DoubleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestDoubleLinkedList {
    @Test
    public void testDoubleLinked() {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.addElement(1); // 1
        doubleList.addElement(2); // 1,2
        doubleList.addElement(3); // 1,2,3
        doubleList.deleteElement(1); //2,3
        doubleList.addElement(4); // 2,3,4
        int getElement = doubleList.findIndexData(3); //should be 2
        int getElementNonExisting = doubleList.findIndexData(55); //should be -1
        int getElementFourPosition_3 = doubleList.findIndexData(4); //should be 3
        doubleList.addElementAt(2, 5); // 2,5,3,4
        int getElementAt_4 = doubleList.getElementAt(4); //should be 4
        int getElementAt_2 = doubleList.getElementAt(2); //should be 5
        doubleList.addElement(12); // 2,5,3,4,12
        int[] result = doubleList.toArray();

        assertEquals(2, getElement);
        assertEquals(4, getElementAt_4);
        assertEquals(5, getElementAt_2);
        assertEquals(-1, getElementNonExisting);
        assertEquals(3, getElementFourPosition_3);
        assertArrayEquals(new int[]{2, 5, 3, 4, 12}, result);

        doubleList.addElement(15); //2,5,3,4,12,15
        int getElementAt_6 = doubleList.getElementAt(6); //should be 15
        int getElement_15 = doubleList.findIndexData(15); //should be 6
        doubleList.deleteElement(6);

        int[] resultSecond = doubleList.toArray();
        assertEquals(15, getElementAt_6);
        assertEquals(6, getElement_15);
        assertArrayEquals(new int[]{2, 5, 3, 4, 12}, resultSecond);

        DoubleLinkedList doubleListTwo = new DoubleLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        int[] toArrayResult = doubleListTwo.toArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, toArrayResult);
        doubleListTwo.emptyArray();
        doubleListTwo.addElement(1); // 1
        doubleListTwo.addElement(13); // 1,2
        assertArrayEquals(new int[]{1, 13}, doubleListTwo.toArray());
    }
}