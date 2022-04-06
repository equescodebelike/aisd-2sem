package util;

public class CustomLinkedListQueue<T> extends CustomLinkedList<T> implements BasicQueue<T> {
    @Override
    public void add(T value) {
        this.addLast(value);
    }

    @Override
    public T remove() throws Exception {
        T result = this.element();
        this.removeFirst();
        return result;
    }

    @Override
    public T element() throws Exception {
        if (this.empty()) {
            throw new Exception("Queue is empty");
        }
        return this.getFirst();
    }

    @Override
    public int count() {
        return this.getSize();
    }

    @Override
    public boolean empty() {
        return this.count() == 0;
    }
}
