package pl.com.bottega.queue;

/**
 * Created by macie on 26.12.2016.
 */
//Rozwiązanie Krzyśka

public class LinkedQueue <E> implements Queue<E> {

    private QueueLink firstLink;
    private QueueLink lastLink;

    public void enqueue(E e) {
        if (isEmpty()) {
            firstLink = new QueueLink(e);
            lastLink = firstLink;
        } else {
            lastLink.nextLink = new QueueLink(e);
            lastLink = lastLink.nextLink;
        }
    }

    public E dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        if (hasOneElementOnly()) {
            lastLink = null;
        }

        E e = firstLink.e;
        firstLink = firstLink.nextLink;
        return e;
    }

    private boolean hasOneElementOnly() {
        return firstLink == lastLink;
    }

    @Override
    public boolean isEmpty() {
        return firstLink == null;
    }

    public String toString() {
        QueueLink reference = firstLink;
        StringBuilder sb = new StringBuilder();
        while (reference != null) {
            sb.append(reference.e).append(" ");
            reference = reference.nextLink;
        }
        return sb.toString();
    }

    private class QueueLink {
        E e;
        QueueLink nextLink;

        private QueueLink(E e) {
            this.e = e;
        }
    }
}
