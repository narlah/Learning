package dataStructures.Lists;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class NKLinkedList<T> implements List<T> {
    private ListNode root = null;
    private ListNode<Object> last = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object o) {
        if (root == null)
            return false;

        ListNode current = root;
        while (current != null) {
            if (current.getData().equals(o))
                return true;

            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        final NKLinkedList<T> list = this;
        return new Iterator<T>() {
            final ListNode firstNode = list.root;
            ListNode currentNode = null;

            @Override
            public boolean hasNext() {
                if (list.isEmpty()) {
                    return false;
                } else if (currentNode == null) {
                    return true;
                } else if (currentNode == list.last) {
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                if (list.isEmpty()) {
                    throw new NoSuchElementException();
                } else if (currentNode == null) {
                    this.currentNode = firstNode;
                    return (T) currentNode.getData();
                } else if (currentNode.next == null) {
                    throw new NoSuchElementException();
                }
                this.currentNode = currentNode.next;
                return (T) currentNode.getData();
            }
        };
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> arr = new ArrayList<>();
        ListNode current = root;
        while (current != null) {
            arr.add((T) current);
            current = current.next;
        }
        return arr.toArray();
    }

    @Override
    public boolean add(Object o) {
        if (o == null) return false;
        ListNode<Object> added = new ListNode<>(o, null);
        if (this.root == null) {
            this.root = added;
        } else {
            this.last.next = added;
        }
        this.last = added;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListNode current = root;
        ListNode prev = root;
        while (current != null) {
            if (current.getData().equals(o)) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c == null) return false;
        for (Object element : c) {
            this.add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
        last = null;
    }

    @Override
    public T get(int index) {
        if (size < index) throw new NoSuchElementException("There is not enough elements into the list");
        ListNode current = root;
        for (int j = 0; j < index; j++) {
            current = current.next;
        }
        return (T)current.getData();
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index == 0) {
            root = new ListNode((T)element, root);
        } else {
            throw new NotImplementedException();
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        ListNode current = root;
        ListNode prev = root;
            while(current!=null){
                if (c.contains(current)) {
                    prev.next = current.next;
                    current = current.next;
                }
                current = current.next;
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


}
