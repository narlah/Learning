package dataStructures.HashTable;

 final class EntryNK<K, V> {
    private final K key;
    private V value;
    EntryNK<K, V> next;
    EntryNK<K, V> prev;
    int hash;

    EntryNK(K key, V value) {
        this.key = key;
        this.setValue(value);
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    V setValue(V value) {
        this.value = value;
        return value;
    }
}