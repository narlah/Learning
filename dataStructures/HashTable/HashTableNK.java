package dataStructures.HashTable;

import java.util.HashSet;
import java.util.Set;

public class HashTableNK<K, V> {
    private final static int INITIAL_DEFAULT_SIZE = 16;
    private final static float LOAD_FACTOR = 0.75f;
    private EntryNK[] storage;
    private int currentEntries;


    HashTableNK() {
        this(INITIAL_DEFAULT_SIZE);
    }

    HashTableNK(int initialNumberOfElements) {
        this.storage = new EntryNK[initialNumberOfElements];
    }

    private static int hash(int h) {
        return 31 * h;
    }

    private static int hash(Object o) {
        return 27 * o.hashCode(); // for strings you can do hash = hash*31 + charAt(i);
    }

    private static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public int lenght() {
        return currentEntries;
    }

    public void clear() {
        storage = new EntryNK[INITIAL_DEFAULT_SIZE];
        currentEntries = 0;
    }

    public EntryNK put(K key, V value) {
        if (containsKey(key)) {
            EntryNK updateEntry = getElementForKey(key);
            assert updateEntry != null;
            updateEntry.setValue(value);
            return updateEntry;
        } else {
            EntryNK<K, V> newEntry = insertInGivenStorage(key, value, storage);
            currentEntries++;
            if (currentEntries / storage.length > LOAD_FACTOR)
                resizeHashMap();
            return newEntry;
        }
    }

    private EntryNK<K, V> insertInGivenStorage(K key, V value, EntryNK<K, V>[] paramStorage) {
        int hashNumber = hash(key);
        int index = indexFor(hashNumber, paramStorage.length);
        EntryNK<K, V> newEntry = new EntryNK<>(key, value);
        newEntry.hash = hashNumber;
        if (paramStorage[index] == null) { //put on empty space
            paramStorage[index] = newEntry;
        } else { //find last and put there
            EntryNK lastInList = findLast(paramStorage[index]);
            lastInList.next = newEntry;
            newEntry.prev = lastInList;
        }
        return newEntry;
    }

    private void resizeHashMap() {
        int newSize = storage.length * 2;
        EntryNK[] newStorage = new EntryNK[newSize];
        for (K key : this.getKeys()) {
            insertInGivenStorage(key, this.get(key), newStorage);
        }
        storage = newStorage;
    }

    public V get(K key) {
        EntryNK<K, V> current = getElementForKey(key);
        return current == null ? null : current.getValue();
    }

    V remove(K key) {
        int index = indexFor(hash(key), storage.length);
        EntryNK<K, V> current = storage[index];
        current = removeKey(current, key, index);
        return current != null ? current.getValue() : null;
    }

    boolean containsKey(K key) {
        EntryNK<? extends K, ? extends V> current = getElementForKey(key);
        return current != null;
    }

    private EntryNK<K, V> getElementForKey(K key) {
        int index = indexFor(hash(key), storage.length);
        EntryNK<K, V> current = storage[index];
        if (current == null) return null;
        else {
            while (current != null && !current.getKey().equals(key)) {
                current = current.next;
            }
            if (current != null && current.getKey().equals(key)) //found
                return current;
            else
                return null;
        }
    }

    Set<K> getKeys() {
        Set<K> resultSet = new HashSet<>();
        for (EntryNK entry : storage) {
            while (entry != null) {
                resultSet.add((K) entry.getKey());
                entry = entry.next;
            }
        }
        return resultSet;
    }

    private EntryNK<K, V> findLast(EntryNK<K, V> current) {
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private EntryNK<K, V> removeKey(EntryNK<K, V> current, K key, int index) {
        while (current != null && !current.getKey().equals(key)) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null)
                current.prev.next = current.next;
            else if (current.next != null)
                storage[index] = current.next;
            else
                storage[index] = null;
            currentEntries--;
        }

        return current;
    }

}
