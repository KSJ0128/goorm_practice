package org.example.Stack;

import org.example.LinkedList.LinkedList;

import java.util.NoSuchElementException;

public class Stack<T> extends LinkedList<T> {
    private LinkedList<T> linkedList = new LinkedList<>();

    public Stack() {
        super();
    }

    public void push(T element) {
        linkedList.add(element);
    }

    public boolean empty() {
        return (linkedList.size() == 0);
    }

    public void pop() {
        if (!this.empty()) {
            int last = linkedList.size() - 1;
            linkedList.delete(last);
        }
        else
            throw new NoSuchElementException();
    }

    public T top() {
        if (!this.empty()) {
            int last = linkedList.size() - 1;
            return (linkedList.get(last));
        }
        else
            throw new NoSuchElementException();
    }
}
