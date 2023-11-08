package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    public void setLeft(AbstractBinaryTree<E> left) {
        this.left = left;
    }

    public void setRight(AbstractBinaryTree<E> right) {
        this.right = right;
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        list.add(this);
        if (left != null) {
            list.addAll(left.preOrder());
        }
        if (right != null) {
            list.addAll(right.preOrder());
        }
        return list;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        if (left != null) {
            list.addAll(left.inOrder());
        }
        list.add(this);
        if (right != null) {
            list.addAll(right.inOrder());
        }
        return list;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> list = new ArrayList<>();
        if (left != null) {
            list.addAll(left.postOrder());
        }
        if (right != null) {
            list.addAll(right.postOrder());
        }
        list.add(this);
        return list;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        return buildIndentedPreOrder(new StringBuilder(), "", "", indent).toString();
    }

    private StringBuilder buildIndentedPreOrder(StringBuilder sb, String prefix, String childrenPrefix, int indent) {
        sb.append(prefix);
        sb.append(key);
        sb.append("\n");
        List<AbstractBinaryTree<E>> children = new ArrayList<>();
        if (this.left != null) children.add(this.left);
        if (this.right != null) children.add(this.right);

        for (int i = 0; i < children.size(); i++) {
            if (i < children.size() - 1) {
                ((BinaryTree<E>) children.get(i)).buildIndentedPreOrder(sb, childrenPrefix + "├── ", childrenPrefix + "│   ", indent);
            } else {
                ((BinaryTree<E>) children.get(i)).buildIndentedPreOrder(sb, childrenPrefix + "└── ", childrenPrefix + "    ", indent);
            }
        }
        return sb;
    }

    public static void morrisTraversalInOrder(BinaryTree<Integer> root) {
        BinaryTree<Integer> current = root;
        BinaryTree<Integer> pre;

        while (current != null) {
            if (current.getLeft() == null) {
                System.out.print(current.getKey() + " ");
                current = (BinaryTree<Integer>) current.getRight();
            } else {
                // Находим предшественник для текущего узла
                pre = (BinaryTree<Integer>) current.getLeft();
                while (pre.getRight() != null && pre.getRight() != current) {
                    pre = (BinaryTree<Integer>) pre.getRight();
                }

                // Создаем временные ссылки на текущий узел
                if (pre.getRight() == null) {
                    pre.setRight(current);
                    current = (BinaryTree<Integer>) current.getLeft();
                } else {
                    // Восстанавливаем дерево и выводим ключ текущего узла
                    pre.setRight(null);
                    System.out.print(current.getKey() + " ");
                    current = (BinaryTree<Integer>) current.getRight();
                }
            }
        }
    }
}
