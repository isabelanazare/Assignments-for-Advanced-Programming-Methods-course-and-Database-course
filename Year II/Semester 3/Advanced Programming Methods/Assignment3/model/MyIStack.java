package model;

import java.util.Stack;

public interface MyIStack <T> {
    void push(T el);
    T pop();
    T peek();
    boolean isEmpty();
    Stack<T> getStack();
    String toString();
    }