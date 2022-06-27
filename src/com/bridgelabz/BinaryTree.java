package com.bridgelabz;

public class BinaryTree<T extends Comparable<T>> {

    static Node root;

    //Method to insert elements at proper position
    public Node<T> insertElements(Node<T> root, T key) {
        if (root == null) {
            root = new Node<>(key);
        }
        if (key.compareTo(root.key) < 0) {
            root.left = insertElements(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertElements(root.right, key);
        }
        return root;
    }

    public void add(T key) {
        root = insertElements(root, key);
    }

    //To sort the tree in order
    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.key + ",");
            traverseInOrder(node.right);

        }
    }

    //Method findingNode to search for the element in the tree
    public boolean findingNode(Node<T> root, T key) {
        if (root == null) {
            return false;
        } else if (key.compareTo(root.key) == 0) {
            return true;
        } else {
            if (key.compareTo(root.key) < 0) {
                return findingNode(root.left, key);
            } else {
                return findingNode(root.right, key);
            }
        }
    }

    public boolean searchNode(T key) {
        System.out.println("Element to find is : " + key);
        return findingNode(root, key);
    }


    //Main method to take input and print the true or falso for element found or not
    public static void main(String args[]) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        int[] elements = {56, 30, 70, 40, 22, 60, 95, 65, 63, 67, 11, 16, 3};
        for (Integer i : elements) {
            binaryTree.add(i);
        }
        System.out.println("Found data in the tree : " + binaryTree.searchNode(30));
        System.out.println("Inorder traversal is as follows: ");
        binaryTree.traverseInOrder(root);
        System.out.println();

    }

}