package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.matrix.Matrix;

public class Node {
    private Node nodePrev;
    private Node nodeNext;
    private Matrix value;

    public Node() {
        this.nodePrev = null;
        this.nodeNext = null;
        this.value = null;
    }

    public Node(Node prev, Node next, Matrix matrix) {
        this.nodePrev = prev;
        this.nodeNext = next;
        this.value = matrix;
    }

    public Matrix getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.nodeNext;
    }

    public Node getPrev() {
        return this.nodePrev;
    }

    public void setNext(Node next) {
        this.nodeNext = next;
    }

    public void setPrev(Node prev) {
        this.nodePrev = prev;
    }

    public void setValue(Matrix value) {
        this.value = value;
    }
}
