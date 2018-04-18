package dataStructures.Lists;

class ListNode<T> {
    ListNode next;
    private T value;

    ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public T getData() {
        return value;
    }
}