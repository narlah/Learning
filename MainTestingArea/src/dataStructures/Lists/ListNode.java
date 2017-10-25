package dataStructures.Lists;

class ListNode<T> {
    private T value;
    ListNode next;

    ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public T getData() {
        return value;
    }
}