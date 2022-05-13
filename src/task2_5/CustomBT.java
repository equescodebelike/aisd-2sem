package task2_5;

public class CustomBT { // класс простейшего двоичного дерева
    protected static class Node {
        protected int value;
        protected Node left;
        protected Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node insert(Node node, int value) { // вставляем значения в дерево
        if (node == null) {
            return (new Node(value));
        } else {
            if (value <= node.value) { // отбор правого и левого потомка
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
            return node;
        }
    }

    public Node cloneTree(Node root) { // копирование дерева
        Node n1 = new Node(0);
        n1.value = root.value;
        cloneTree(root, n1);
        return n1;
    }

    public void cloneTree(Node root, Node newNode) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            newNode.left = new Node(0);
            newNode.left.value = root.left.value;
            cloneTree(root.left, newNode.left); // рекурсивно вызываем пока рут имеет потомков
        }
        if (root.right != null) {
            newNode.right = new Node(0);
            newNode.right.value = root.right.value;
            cloneTree(root.right, newNode.right);
        }

    }

    public String toBracketStr(Node treeNode) {
        // метод преобразование в скобочный вид
        // данный класс нужен только для того, чтобы "спрятать" его метод (c 2-мя параметрами)
        class Inner {
            void printTo(Node node, StringBuilder sb) {
                if (node == null) {
                    return;
                }
                sb.append(node.value);
                if (node.left != null || node.right != null) {
                    sb.append(" (");
                    printTo(node.left, sb);
                    if (node.right != null) {
                        sb.append(", ");
                        printTo(node.right, sb);
                    }
                    sb.append(")");
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // класс приходится создавать, т.к. статические методы в таких класс не поддерживаются
        new Inner().printTo(treeNode, sb);

        return sb.toString();
    }
}
