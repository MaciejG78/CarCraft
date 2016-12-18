package pl.com.bottega.stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Created by macie on 15.12.2016.
 */
public class ArrayStack<E> implements Stack<E> {

    private int size = 1000; //size of the stack table
    private E[] elements = (E[]) new Object[size]; // create array
    private int index = -1; //top of stack

    @Override
    public E pop() {
        if (isEmpty()) // if stack is empty
            throw new IllegalStateException("Stack is empty");
        E tempValue = elements[index];
        elements[index--] = null;
        return tempValue; // remove and return top element of Stack
    }

    @Override
    public void push(E pushValue) {
        if (index == size - 1) // if stack is full
            throw new IllegalStateException(String.format("Stack is full, cannot push %s", pushValue));

        elements[++index] = pushValue; // place pushValue on Stack
    }

    @Override
    public boolean isEmpty() {
        return index < 0;
    }

    public String toString() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty"); //return "Stack is empty";

        StringBuilder s = new StringBuilder();

        for (int i = 0; i <= index; i++){
            s.append(elements[i]);
            if (!(elements[i+1] == null))
                s.append(" ");
        }

        return s.toString();
    }
}
