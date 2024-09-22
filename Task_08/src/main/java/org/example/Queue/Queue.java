package org.example.Queue;

import org.example.LinkedList.LinkedList;

import java.util.NoSuchElementException;

public class Queue<T> extends LinkedList<T> {
    private LinkedList<T> linkedList = new LinkedList<>();

    public Queue() {
        super();
    }

    public void enqueue(T element) {
        linkedList.add(element);
    }

    public boolean empty() {
        return (linkedList.size() == 0);
    }

    public void dequeue() {

        if (!this.empty()) {
            linkedList.delete(0);
        }
        else
            throw new NoSuchElementException();
    }

    public T front() {
        if (!this.empty())
            return (linkedList.get(0));
        else
            throw new NoSuchElementException();
    }
}
