package main;

import main.Node;
import organisms.Organism;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void Add(Organism organism) {
        Node node = head;
        if (head == null) {
            head = new Node(organism, null);
            tail = head;
            size++;
            return;
        }
        while (node != null) {
            if (node.GetOrganism().GetInitiative() < organism.GetInitiative()) {
                if (node == head) {
                    head = new Node(organism, node);
                    size++;
                    return;
                }
                else {
                    Node prev = head;
                    while (prev.GetNext() != node) {
                        prev = prev.GetNext();
                    }
                    prev.SetNext(new Node(organism, node));
                    size++;
                    return;
                }
            }
		else if (node.GetOrganism().GetInitiative() == organism.GetInitiative()) {
                if (node.GetOrganism().GetAge() < organism.GetAge()) {
                    if (node == head) {
                        head = new Node(organism, node);
                        size++;
                        return;
                    }
                    else {
                        Node prev = head;
                        while (prev.GetNext() != node) {
                            prev = prev.GetNext();
                        }
                        prev.SetNext(new Node(organism, node));
                        size++;
                        return;
                    }
                }
            }
            if (node.GetNext() == null) {
                node.SetNext(new Node(organism, null));
                tail = node.GetNext();
                size++;
                return;
            }
            node = node.GetNext();
        }
    }

    public void Remove(Organism organism) {
        Node node = head;
        Node prev = null;
        while (node != null) {
            if (node.GetOrganism() == organism) {
                if (prev == null) {
                    RemoveHead();
                }
                else if (node.GetNext() == null) {
                    RemoveTail();
                }
                else {
                    prev.SetNext(node.GetNext());
                    size--;
                }
                return;
            }
            prev = node;
            node = node.GetNext();
        }
    }

    public void Remove(Node node) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            if (current == node) {
                if (prev == null) {
                    RemoveHead();
                }
                else if (current.GetNext() == null) {
                    RemoveTail();
                }
                else {
                    prev.SetNext(current.GetNext());
                    size--;
                }
                return;
            }
            prev = current;
            current = current.GetNext();
        }
    }

    public void RemoveHead() {
        if (head != null) {
            Node node = head;
            head = head.GetNext();
            //delete node;
            size--;
        }
    }

    public void RemoveTail() {
        if (tail != null) {
            Node node = head;
            Node prev = null;
            while (node != null) {
                if (node.GetNext() == null) {
                    if (prev == null) {
                        head = null;
                        tail = null;
                    }
                    else {
                        prev.SetNext(null);
                        tail = prev;
                    }
                    //delete node;
                    size--;
                    return;
                }
                prev = node;
                node = node.GetNext();
            }
        }
    }

    public Node GetHead() {
        return head;
    }

    public Node GetTail() {
        return tail;
    }


    public int GetSize() {
        return size;
    }

    public void Print() {
        Node node = head;
        System.out.println("Organisms: " + size);
        while (node != null) {
            System.out.println(node.GetOrganism().GetSymbol() + node.GetOrganism().GetAge() + " ");
            node = node.GetNext();
        }
        System.out.println("");
    }
}
