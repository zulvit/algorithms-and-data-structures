package tree;

import static tree.BinaryTree.morrisTraversalInOrder;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(10);
        BinaryTree<Integer> node1 = new BinaryTree<>(5);
        BinaryTree<Integer> node2 = new BinaryTree<>(15);
        BinaryTree<Integer> node3 = new BinaryTree<>(3);
        BinaryTree<Integer> node4 = new BinaryTree<>(7);
        BinaryTree<Integer> node5 = new BinaryTree<>(12);
        BinaryTree<Integer> node6 = new BinaryTree<>(17);

        root.setLeft(node1); // Установка левого поддерева для корня
        root.setRight(node2); // Установка правого поддерева для корня

        node1.setLeft(node3); // Установка левого поддерева для node1
        node1.setRight(node4); // Установка правого поддерева для node1

        node2.setLeft(node5); // Установка левого поддерева для node2
        node2.setRight(node6); // Установка правого поддерева для node2

        System.out.println("Pre-Order Traversal:");
        root.preOrder().forEach(tree -> System.out.print(tree.getKey() + " "));
        System.out.println();

        System.out.println("In-Order Traversal:");
        root.inOrder().forEach(tree -> System.out.print(tree.getKey() + " "));
        System.out.println();

        System.out.println("Post-Order Traversal:");
        root.postOrder().forEach(tree -> System.out.print(tree.getKey() + " "));
        System.out.println();

        System.out.println("Indented Pre-Order Traversal:");
        System.out.println(root.asIndentedPreOrder(0));

        morrisTraversalInOrder(root);
    }
}