package interviewPickings;

import java.util.HashMap;
import java.util.StringTokenizer;

public class LRUCache {
    private int counter = 0;
    private int maxCapacity;
    private HashMap<Integer, Ele> map = new HashMap<>();
    private Ele root;
    private Ele lastElement;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {// miss
            Ele e = map.get(key);
            if (root == lastElement)
                return e.value;
            if (e != root)
                addToFront(removeEleFromDLL(e));
            return e.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Ele e;
        if (!map.containsKey(key)) {
            e = new Ele(null, root, value, key);
            if (counter == maxCapacity) {
                Ele removed = removeEleFromDLL(lastElement);
                map.remove(removed.key);
            }
            map.put(key, e);
        } else {
            e = removeEleFromDLL(map.get(key));
            e.value = value;
        }
        if (root == null) {
            root = e;
            lastElement = e;
        } else {
            if (e != root)
                addToFront(e);
        }
    }

    private Ele removeEleFromDLL(Ele e) {
        if (root == lastElement) {
            root = lastElement = null;
            return e;
        } else if (root == e) return e;
        if (e != lastElement) {
            e.next.prev = e.prev;
        } else
            lastElement = e.prev;
        e.prev.next = e.next;
        return e;
    }

    private void addToFront(Ele e) {
        root.prev = e;
        e.next = root;
        root = e;
    }

    private class Ele {
        Ele prev, next;
        int value;
        int key;

        Ele(Ele prev, Ele next, int value, int key) {
            this.prev = prev;
            this.next = next;
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {

        String str = "93 11 S 9 1 G 12 S 8 3 G 7 G 11 G 9 S 13 12 G 11 G 1 S 8 14 G 2 G 14 G 11 S 11 10 S 10 6 G 3 G 3 G 12 G 7 G 2 G 11 S 11 14 S 11 12 S 3 15 G 14 G 6 G 4 S 13 3 G 11 S 4 15 G 12 G 9 S 15 9 G 4 S 5 15 S 4 4 S 9 7 G 5 S 9 13 S 11 10 S 11 12 G 12 S 7 6 S 6 2 G 1 S 15 6 G 7 S 8 8 S 14 8 G 12 G 12 S 6 15 G 2 S 2 5 S 13 15 G 13 S 6 6 G 7 G 12 G 15 S 10 8 G 6 G 5 G 5 S 14 10 G 15 G 5 G 14 G 12 S 11 15 G 5 G 2 S 9 5 S 4 7 G 13 G 2 S 7 13 G 9 G 9 S 11 5 G 6 G 4 S 6 13 G 2 S 3 15 G 13 G 4 S 6 11 G 15 G 15 G 3 G 3 G 3 ";
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        int operations = Integer.parseInt(tokenizer.nextElement() + "");
        int size = Integer.parseInt(tokenizer.nextElement() + "");
        System.out.println(operations);
        LRUCache cache = new LRUCache(size);
        int count = 0;
        String result = "";
        while (tokenizer.hasMoreElements()) {
            if (count == 71) {
                System.out.println(60);
            }
            Character op = (tokenizer.nextElement() + "").charAt(0);
            if (op == 'S') {
                int keyToADD = Integer.parseInt(tokenizer.nextElement() + "");
                int valueToADD = Integer.parseInt(tokenizer.nextElement() + "");
                cache.set(keyToADD, valueToADD);
            }
            if (op == 'G') {
                int searchFor = Integer.parseInt(tokenizer.nextElement() + "");
                String afterGet = cache.get(searchFor) + " , ";
                result += afterGet;
            }
            count++;
        }
        System.out.println(result);
    }
}


/* fastest (there is always an asian better than you)

import java.util.*;

public class Solution {
    Map<Integer,Integer> cache;
    public Solution(int capacity) {
        cache= new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            public boolean removeEldestEntry(Map.Entry eldest){
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }

    public void set(int key, int value) {
        cache.put(key,value);
    }
}
*/

/* lightweight

public class Solution {

    private PriorityQueue<timestampedValue> lru;
    private Map<Integer, timestampedValue> map;
    private int capacity;

    private int timestamp;

    public Solution(int capacity) {
        this.lru = new PriorityQueue<timestampedValue>();
        this.map = new HashMap();
        this.capacity = capacity;
    }

    private void updateTimestampLru(timestampedValue value) {
        lru.remove(value);
        // dumpLru();
        value.timestamp = ++timestamp;
        // System.out.println("touch " + value.key + " = " + value.value + " (" + value.timestamp + ") ");
        lru.offer(value);
        // dumpLru();
    }

    public int get(int key) {
        timestampedValue result = map.get(key);
        if (result == null) {
            // System.out.print("got " + key + " = ");
            return -1;
        }

        updateTimestampLru(result);

        // System.out.print("got " + key + " = ");
        return result.value;
    }

    public void set(int key, int value) {
        timestampedValue oldValue = map.remove(key);

        if (oldValue == null) {
            if (lru.size() == capacity) {
                evict();
            }
            timestampedValue insert = new timestampedValue();
            insert.timestamp = ++timestamp;
            insert.key = key;
            insert.value = value;
            lru.offer(insert);
            // dumpLru();
            map.put(key, insert);
            // System.out.println("set " + key + " = " + value + " (" + now + ") ");
        } else {
            oldValue.value = value;
            updateTimestampLru(oldValue);
            map.put(key, oldValue);
        }
    }

    private void evict() {
        timestampedValue e = lru.poll();
        // dumpLru();
        // System.out.print("evict k = " + e.key + " (" + e.timestamp + ") ");
        map.remove(e.key);
    }

    private void dumpLru() {
        for (timestampedValue v: lru) {
            System.out.println("\t" + v.key + " = " + v.value + " (" + v.timestamp + ") ");
        }
    }

    private static class timestampedValue implements Comparable<timestampedValue> {
        int timestamp;
        int key;
        int value;

        public int compareTo(timestampedValue that) {
            return Integer.compare(this.timestamp, that.timestamp);
        }
    }
}
*/

/* editorial


public class Solution {

    TreeMap<Integer, Integer> map ;
    int n;
    ArrayList<Integer> arr;

    public Solution(int capacity) {
        map = new TreeMap<Integer, Integer>();
        n = capacity;
        arr = new ArrayList<Integer>();
    }

    public int get(int key) {
        if (map.containsKey(key)){
            int value = map.get(key);
            int ind = arr.indexOf(key);
            arr.remove(ind);
            arr.add(key);

            return value;
        }

        return -1;
    }

    public void set(int key, int value) {

        if (map.containsKey(key)){
            //map.remove(key);
            int ind = arr.indexOf(key);
            arr.remove(ind);
            map.put(key, value);
            arr.add(key);
            return;
        }

        if (n == 0)
            return ;

        while (arr.size() >= n){
            //System.out.println(arr.size() + " " + n);
            int lru = arr.get(0);
            map.remove(lru);
            //int ind = arr.indexOf(key);
            arr.remove(0);

        }
        map.put(key, value);
        arr.add(key);
    }
}


*/