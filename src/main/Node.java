package main;

import organisms.Organism;

public class Node {
    private Organism organism;
    private Node next;

    public Node(Organism organism, Node next) {
        this.organism = organism;
        this.next = next;
    }

    public Organism GetOrganism() {
        return organism;
    }

    public Node GetNext() {
        return next;
    }

    public void SetNext(Node next) {
        this.next = next;
    }
}
