package learnJUnit;

import archive.DynamicStack;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestDynamicStack {
    @Test
    public void testDoubleLinked() {
        DynamicStack dynamicStack = new DynamicStack();
        dynamicStack.addElement(1); // 1
        dynamicStack.addElement(2); // 2,1
        dynamicStack.addElement(3); // 3,2,1
        int returnElement = dynamicStack.getElement(); //3
        dynamicStack.addElement(4); // 4,3,2,1
        int deletedElement = dynamicStack.deleteElement(); //4
        dynamicStack.addElement(12); // 12,3,2,1
        int[] result = dynamicStack.toArray();

        assertEquals(3, returnElement);
        assertEquals(4, deletedElement);
        assertArrayEquals(new int[]{12, 3, 2, 1}, result);

        dynamicStack.addElement(15); //15,12,3,2,1

        int getElement15 = dynamicStack.getElement(); //should be 15
        dynamicStack.deleteElement(); //12,3,2,1
        int[] resultSecond = dynamicStack.toArray();

        assertEquals(15, getElement15);
        assertArrayEquals(new int[]{12, 3, 2, 1}, resultSecond);

        DynamicStack dynamicStackTwo = new DynamicStack(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        int[] toArrayResult = dynamicStackTwo.toArray();
        assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, toArrayResult);
        dynamicStackTwo.emptyArray();
        dynamicStackTwo.addElement(1); // 1
        dynamicStackTwo.addElement(13); // 13,1
        assertArrayEquals(new int[]{13, 1}, dynamicStackTwo.toArray());
    }
}