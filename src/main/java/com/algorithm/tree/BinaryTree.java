package com.algorithm.tree;

import lombok.AllArgsConstructor;

/**
 * @author admin
 * @description
 * @dateTime 2020-01-20 14:43:00
 */
public class BinaryTree {

    static void pre(Node node) {
        System.out.print(node.value);
        if (node.left != null) {
            pre(node.left);
        }
        if (node.right != null) {
            pre(node.right);
        }
    }

    static void mid(Node node) {
        if (node.left != null) {
            mid(node.left);
        }
        System.out.print(node.value);
        if (node.right != null) {
            mid(node.right);
        }
    }

    static void post(Node node) {
        if (node.left != null) {
            post(node.left);
        }
        if (node.right != null) {
            post(node.right);
        }
        System.out.print(node.value);
    }

    public static void main(String[] args) {

        Node d = new Node('D', null, null);
        Node h = new Node('H', null, null);
        Node k = new Node('K', null, null);

        Node c = new Node('C', d, null);
        Node b = new Node('B', null, c);


        Node g = new Node('G', h, k);
        Node f = new Node('F', g, null);
        Node e = new Node('E', null, f);
        Node a = new Node('A', b, e);

        pre(a);
        System.out.println();
        mid(a);
        System.out.println();
        post(a);


    }
}


@AllArgsConstructor
class Node {
    char value;

    Node left;

    Node right;


}
