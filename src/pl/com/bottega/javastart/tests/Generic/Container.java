package pl.com.bottega.javastart.tests.Generic;

/**
 * Created by macie on 11.01.2017.
 */
public class Container<T> {
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public void printObjects() {
        for(T o: array) {
            System.out.println(o);
        }
    }
}