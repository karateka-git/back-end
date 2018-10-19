package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.matrix.Matrix;

public class DoubleEndedQueue {
    private Node start;
    private Node end;
    private int size;

    public DoubleEndedQueue() {
        this.start = new Node();
        this.end = new Node();
        this.start.setNext(end);
        this.end.setPrev(start);
        this.size = 0;
    }

    public Matrix getFirst() {
        return this.start.getNext().getValue();
    }

    public Matrix getLast() {
        return this.end.getPrev().getValue();
    }

    public void addFirst(Matrix m) {
        Node second = start.getNext();
        Node currentFirst = new Node(start, second, m);
        start.setNext(currentFirst);
        second.setPrev(currentFirst);
        size++;
    }

    public void addLast(Matrix m) {
        Node prevLast = end.getPrev();
        Node currentLast = new Node(prevLast, end, m);
        end.setPrev(currentLast);
        prevLast.setNext(currentLast);
        size++;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this.start.getNext();
        for(int i = 0; i < getSize(); i++) {
            sb.append("--").append('\n').append(current.getValue().toString()).append("--").append('\n');
            current = current.getNext();
        }
        return sb.toString();
    }
}
