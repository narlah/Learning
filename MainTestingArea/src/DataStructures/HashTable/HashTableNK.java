package DataStructures.HashTable;

import java.util.HashSet;
import java.util.Set;

class HashTableNK<K, V> {
    private final static int INITIAL_DEFAULT_SIZE = 16;
    private final static float LOAD_FACTOR = 0.75f;
    private EntryNK<K, V>[] storage;
    private int currentEntries;


    HashTableNK() {
        this(INITIAL_DEFAULT_SIZE);
    }

    HashTableNK(int initialNumberOfElements) {
        this.storage = new EntryNK[initialNumberOfElements];
    }

    public int lenght() {
        return currentEntries;
    }

    public void clear() {
        storage = new EntryNK[INITIAL_DEFAULT_SIZE];
        currentEntries = 0;
    }

    public EntryNK<K, V> put(K key, V value) {
        EntryNK<K, V> newEntry = insertInGivenStorage(key, value, storage, storage.length);
        currentEntries++;
        if (currentEntries / storage.length > LOAD_FACTOR)
            resizeHashMap();
        return newEntry;
    }

    private EntryNK<K, V> insertInGivenStorage(K key, V value, EntryNK<K, V>[] paramStorage, int paramSize) {
        int hashNumber = hash(key);
        int index = indexFor(hashNumber, paramSize);
        EntryNK<K, V> newEntry = new EntryNK<K, V>(key, value);
        newEntry.hash = hashNumber;
        if (paramStorage[index] == null) { //put on empty space
            paramStorage[index] = newEntry;
        } else { //find last and put there
            findLast(paramStorage[index]).next = newEntry;
        }
        return newEntry;
    }

    private void resizeHashMap() {
        int newSize = storage.length * 2;
        EntryNK<K, V>[] newStorage = new EntryNK[newSize];
        for (K key : this.getKeys()) {
            insertInGivenStorage(key, this.get(key), newStorage, newSize);
        }
        storage = newStorage;
    }

    public V get(K key) {
        EntryNK current = getElementForKey(key);
        return current == null ? null : (V) current.getValue();
    }

    public V remove(K key) {
        int index = indexFor(hash(key), storage.length);
        EntryNK<K, V> current = storage[index];
        if (current == null) return null; //nothing to remove
        EntryNK<K, V> prev = null;
        if (current.getKey().equals(key)) {
            if (current.next != null) {
                storage[index] = current.next;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        EntryNK current = getElementForKey(key);
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

    public Set<K> getKeys() {
        Set<K> resultSet = new HashSet();
        for (EntryNK entry : storage) {
            while (entry != null) {
                resultSet.add((K) entry.getKey());
                entry = entry.next;
            }
        }
        return resultSet;
    }

    private static int hash(int h) {
        return 31 * h;
    }

    private static int hash(Object o) {
        return 27 * o.hashCode();
    }

    private static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private EntryNK<K, V> findLast(EntryNK<K, V> current) {
        if (current.next != null) {
            while (current.next != null) {
                current = current.next;
            }
        }
        return current;
    }


}
