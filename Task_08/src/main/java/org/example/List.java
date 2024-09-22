package org.example;

public interface List<T> {
    public abstract void add(T element);

    public abstract T get(int idx);

    public abstract void delete(int idx);

    public abstract int size();
}
