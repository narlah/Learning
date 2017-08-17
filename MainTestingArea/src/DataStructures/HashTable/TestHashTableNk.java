package DataStructures.HashTable;

import org.junit.Test;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestHashTableNk {

    @Test
    public void testAdd() {
        HashTableNK<Integer, String> testHT = new HashTableNK<>();
        testHT.put(1, "nk1");
        testHT.put(2, "nk2");
        testHT.put(3, "nk3");
        testHT.put(12, "nk12");
        testHT.put(17, "nk17");
        testHT.put(182, "nk182");
        testHT.put(89, "nk89");
        testHT.put(1000, "nk1000");
        testHT.put(12121, "nk12121");
        testHT.put(16, "nk16");
        assertTrue(testHT.get(17).equals("nk17"));
        assertTrue(testHT.get(1).equals("nk1"));
        assertTrue(testHT.get(2).equals("nk2"));
        assertTrue(testHT.get(89).equals("nk89"));
        assertTrue(testHT.get(1000).equals("nk1000"));
        assertTrue(testHT.get(11) == null);
    }

    @Test
    public void testGetKeys() {
        HashTableNK<Integer, String> testHT = new HashTableNK<>();
        testHT.put(1, "nk1");
        testHT.put(2, "nk2");
        testHT.put(3, "nk3");
        testHT.put(17, "nk17");
        Set keys = testHT.getKeys();
        assertTrue(keys.contains(1));
        assertTrue(keys.contains(2));
        assertTrue(keys.contains(3));
        assertTrue(keys.contains(17));
        assertFalse(keys.contains(18));
        assertFalse(keys.contains(18));

    }

    @Test
    public void testResize() {
        HashTableNK<Integer, String> testHT = new HashTableNK<>(2);
        testHT.put(1, "nk1");
        testHT.put(2, "nk2");
        testHT.put(3, "nk3");
        testHT.put(1800, "nk1800");
        assertTrue(testHT.lenght() > 3);
        assertFalse(testHT.lenght() <= 2);
        assertTrue(testHT.containsKey(1));
        assertTrue(testHT.containsKey(1800));
        assertFalse(testHT.containsKey(112));
    }

    @Test
    public void testRemove() {
        HashTableNK<Integer, String> testHT = new HashTableNK<>(2);
        testHT.put(1, "nk1");
        testHT.put(2, "nk2");
        testHT.put(33, "nk3");
        assertTrue(testHT.remove(33).equals("nk3"));
        assertTrue(testHT.containsKey(1));
        assertFalse(testHT.containsKey(22));
        testHT.remove(2);
        assertTrue(testHT.remove(1).equals("nk1"));
        assertTrue(testHT.lenght()==0);

        testHT.put(1,"z");
        assertTrue(testHT.lenght()==1);
        testHT.put(2,"k");
        assertTrue(testHT.lenght()==2);
        testHT.put(1,"l");
        assertTrue(testHT.lenght()==2);
        assertTrue(testHT.remove(1).equals("l"));
        assertTrue(testHT.lenght()==1);
        System.out.println(testHT.getKeys());
    }
}




