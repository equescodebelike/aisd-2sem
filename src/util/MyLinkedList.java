package util;

public class MyLinkedList<T> {

    private static class ListNode<T> {
        public T value;
        public ListNode<T> next;

        public ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(T value) {
            this(value, null);
        }

        public ListNode() {
            this(null);
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;

    private int count = 0;

    public void addFirst(T value) {
        head = new ListNode<>(value, head);
        if (count == 0) {
            tail = head;
        }
        count++;
    }

    public void addLast(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        if (count > 0) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    private void emptyError() throws Exception {
        if (count == 0) {
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

    private ListNode<T> getNode(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws Exception {
        return getNode(index).value;
    }

    public T removeFirst() throws Exception {
        T value = getFirst();
        head = head.next;
        count--;
        if (count == 0) {
            tail = null;
        }
        return value;
    }

    public T removeLast() throws Exception {
        T value = getLast();
        count--;
        if (count == 0) {
            head = tail = null;
        } else {
            tail = getNode(count - 1);
            tail.next = null;
        }
        return value;
    }

    public T remove(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }

        T value;
        if (index == 0) {
            value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            ListNode<T> prev = getNode(index - 1);
            value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        count--;
        return value;
    }

    public void removeAll(T value) {
        while (head != null && value.equals(head.value)) {
            head = head.next;
            count--;
        }
        for (ListNode<T> curr = head; curr != null; curr = curr.next) {
            while (curr.next != null && value.equals(curr.next.value)) {
                curr.next = curr.next.next;
                count--;
            }
            if (curr.next == null) {
                tail = curr;
            }
        }
    }

    public void insert(int index, T value) throws Exception {
        if (index < 0 || index > count) {
            throw new Exception("Wrong index");
        }
        if (index == 0) {
            addFirst(value);
        } else {
            ListNode prev = getNode(index - 1);
            prev.next = new ListNode(value, prev.next);
            count++;
        }
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
