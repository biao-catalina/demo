package com.leetcode;

/**
 * swap nodes in pairs
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodes {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node swapNodes(Node head) {


        Node prev = head;
        Node current = head.next;
        Node result = current;
        while (current != null) {
            Node future = current.next;
            current.next = prev;
            if (future == null || future.next == null) {
                prev.next = future;
                break;
            }
            prev.next = future.next;
            prev = future;
            current = prev.next;
        }
        return result;
    }

    public static Node swapPairs(Node head) {

        if (head == null || head.next == null)
            return head;
        Node prev = head;
        Node cur = head.next;
        Node result = cur;

        while (true) {
            Node future = cur.next;
            cur.next = prev;
            if (future == null || future.next == null) {
                prev.next = future;
                break; // end of the list
            }
            prev.next = future.next;
            prev = future;
            cur = prev.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        swapPairs(node);
        Node node1 = swapNodes(node);
        System.out.println(node1);
    }
}
