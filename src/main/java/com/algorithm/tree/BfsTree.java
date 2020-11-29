package com.algorithm.tree;

import java.util.*;

public class BfsTree {

    public static void main(String[] args) {
        BfsTree b = new BfsTree();
//        System.out.println(b.isSymmetric(root));
        TreeNode treeNode = b.generateTreeNode(1,2,null);
        System.out.println(b.minDepth(treeNode));
//        List<List<Integer>> lists = b.levelOrder(treeNode);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return 1;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public TreeNode generateTreeNode(Integer... arr) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        stack.push(root);
        int i = 0;
        while (i < arr.length - 1) {
            TreeNode pop = stack.pollFirst();
            if (pop != null) {
                if (arr[++i] != null) {
                    pop.left = new TreeNode(arr[i]);
                }
                if (arr[++i] != null) {
                    pop.right = new TreeNode(arr[i]);
                }
                if (pop.left != null) {
                    stack.addLast(pop.left);
                }
                if (pop.right != null) {
                    stack.addLast(pop.right);
                }
            }
        }
        return root;

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pollFirst();
                if (pop != null) {
                    if (pop.left != null) stack.addLast(pop.left);
                    if (pop.right != null) stack.addLast(pop.right);
                    list.add(pop.val);
                }
            }
            result.add(list);
        }
        return result;
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
