package com.bridgelabz;

public class Node<T extends Comparable<T>> {
    T key;
    Node<T> left;
    Node<T> right;

    public Node(T key) {
        this.key = key;
    }
}
