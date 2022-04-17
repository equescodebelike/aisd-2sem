package util;

import java.util.Comparator;
import java.util.List;

public class CustomLinkedList<T> {

    private static class ListItem<T> {
        public T value;
        public ListItem<T> next;

        public ListItem(T value, ListItem<T> next) {
            this.value = value;
            this.next = next;
        }

        public ListItem(T value) {
            this(value, null);
        }

        public ListItem() {
            this(null);
        }
    }

    protected ListItem<T> head = null;
    protected ListItem<T> tail = null;
    protected int size = 0;

    public void addFirst(T value) {
        head = new ListItem<>(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        ListItem<T> newNode = new ListItem<>(value);
        if (size > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    private void emptyError() throws Exception {
        if (size == 0) {
            throw new Exception("List is empty");
        }
    }

    public T getFirst() throws Exception {
        emptyError();
        return head.value;
    }

    public T getLast() throws Exception {
        emptyError();
        return tail.value;
    }

    private ListItem<T> getItem(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Wrong index");
        }
        ListItem<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws Exception {
        return getItem(index).value;
    }

    public T removeFirst() throws Exception {
        T value = getFirst();
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return value;
    }

    public T removeLast() throws Exception {
        T value = getLast();
        size--;
        if (size == 0) {
            head = tail = null;
        } else {
            tail = getItem(size - 1);
            tail.next = null;
        }
        return value;
    }

    public T remove(int k) throws Exception {
        if (k < 0 || k >= size) {
            throw new Exception("Wrong index");
        }

        T value;

        if (k == 1) {
            head = tail = null;
            size = 0;
        }

        if (k == 0) {
            value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            ListItem<T> prev = getItem(k - 1);
            value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
        return value;
    }

    public void removeAll(T value) {
        while (head != null && value.equals(head.value)) {
            head = head.next;
            size--;
        }
        for (ListItem<T> curr = head; curr != null; curr = curr.next) {
            while (curr.next != null && value.equals(curr.next.value)) {
                curr.next = curr.next.next;
                size--;
            }
            if (curr.next == null) {
                tail = curr;
            }
        }
    }

    public void insert(int index, T value) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Wrong index");
        }
        if (index == 0) {
            addFirst(value);
        } else {
            ListItem prev = getItem(index - 1);
            prev.next = new ListItem(value, prev.next);
            size++;
        }
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

}
