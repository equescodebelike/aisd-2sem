package util;

public interface BasicQueue<T> {
    void add(T value);

    T remove() throws Exception;

    T element() throws Exception;

    int count();

    boolean empty();
}
