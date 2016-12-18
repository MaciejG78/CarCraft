package pl.com.bottega.stack;

/**
 * Created by macie on 15.12.2016.
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    boolean isEmpty();
}
