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
            System.out.print(node.key+ ",");
            traverseInOrder(node.right);

        }
    }

    //To sort the tree in preOrder form
    public void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.key+ ",");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //To sort the tree post order
    public void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.key+ ",");
        }
    }

    //To find the size
    public int sizeFinding(Node<T> root) {
        if (root == null) {
            return 0;
        } else {
            return sizeFinding(root.right) + 1 + sizeFinding(root.left);
        }
    }

    public int size() {
        return sizeFinding(root);
    }

    //Main method to print the tree
    public static void main(String[] args) {
        System.out.println("Welcome to Binary Search Tree Program");
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        int[] elements = {56, 30, 70, 22, 40, 60, 63, 65, 95, 67, 3, 16, 11};
        for (Integer i : elements) {
            binaryTree.add(i);
        }
        System.out.println("Size of the elements is : " + binaryTree.size());
        System.out.println();
        System.out.println("In order traversal is as follows : ");
        binaryTree.traverseInOrder(root);
        System.out.println();
        System.out.println("Pre order traversal is as follows : ");
        binaryTree.traversePreOrder(root);
        System.out.println();
        System.out.println("Post order traversal is as follows : ");
        binaryTree.traversePostOrder(root);

    }

}
