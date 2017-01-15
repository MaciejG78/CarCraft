package pl.com.bottega.queue;

/**
 * Created by macie on 26.12.2016.
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    boolean isEmpty();

}
