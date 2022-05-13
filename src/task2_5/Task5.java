package task2_5;

public class Task5 {
    public static void main(String[] args) {
        CustomBT tree = new CustomBT(); // исходное дерево
        CustomBT tree2 = new CustomBT(); // копия
        CustomBT.Node root = null;
        CustomBT.Node root2;
        root = tree.insert(root, 10);
        tree.insert(root, 47);
        tree.insert(root, 9);
        tree.insert(root, 11);
        tree.insert(root, 67);
        tree.insert(root, 56);
        tree.insert(root, 8);
        tree.insert(root, 4);
        tree.insert(root, 56);

        System.out.println(tree.toBracketStr(root));

        root2 = tree.cloneTree(root);

        System.out.println(tree2.toBracketStr(root2));

    }
}
