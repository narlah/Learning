package DataStructures.HashTable;

/**
 * Created by Nk on 7/25/2016.
 */
final class EntryNK<K, V> {
    final K key;
    V value;
    EntryNK<K, V> next;
    int hash;

    EntryNK(K key, V value) {
        this.key = key;
        this.setValue(value);
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        this.value = value;
        return value;
    }
}