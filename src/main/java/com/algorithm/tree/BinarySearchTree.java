package com.algorithm.tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        Tree tree = new Tree(new Node('c', null, null));
        tree.insert(new Node('a', null, null));
        tree.insert(new Node('b', null, null));
        tree.insert(new Node('d', null, null));
        tree.insert(new Node('f', null, null));
        tree.insert(new Node('e', null, null));

        System.out.println(111);
        System.out.println(tree);
    }

}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    void insert(Node node) {
        Node temp = root;
        while (temp != null) {
            if (node.value == temp.value) {
                break;
            }
            if (node.value > temp.value) {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                } else {
                    temp = root.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                } else {
                    temp = root.left;
                }
            }
        }
//        insert(root, node);
    }

    private void insert(Node root, Node node) {
        if (node.value > root.value) {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
}


