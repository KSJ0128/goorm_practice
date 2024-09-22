package org.example.LinkedList;

import org.example.List;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    public static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node(element);

        if (size == 0) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T get(int i) {
        if (i >= size || i < 0)
            throw new NoSuchElementException();

        Node<T> curNode = head;
        for (int j = 0; j < i; j++) {
            curNode = curNode.next;
        }

        return (curNode.data);
    }

    @Override
    public void delete(int i) {
        if (i > size - 1 || i < 0)
            throw new NoSuchElementException();

        Node<T> prevNode = null;
        Node<T> curNode = head;
        for (int j = 0; j < i; j++) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        if (prevNode == null)
            head = curNode.next;
        else
            prevNode.next = curNode.next;

        if (curNode == tail)
            tail = prevNode;

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        Node<T> curNode = head;

        for (int i = 0; i < size; i++) {
            System.out.println(i + "번째 데이터 : " + curNode.data);
            curNode = curNode.next;
        }
    }
}
