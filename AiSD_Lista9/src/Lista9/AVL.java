package Lista9;

public class AVL {

    class Node {
        Node left, right;
        int data;
        int height;

        public Node() {
            left = null;
            right = null;
            data = 0;
            height = 0;
        }

        public Node(int n) {
            left = null;
            right = null;
            data = n;
            height = 0;
        }
    }

    private Node root;


    public AVL() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void insert(int data) throws DuplicateElementException {
        root = insert(data, root);
    }

    private int height(Node data) {
        return data == null ? -1 : data.height;
    }

    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    private Node insert(int x, Node root) throws DuplicateElementException {
        if (root == null)
            root = new Node(x);
        else if (x < root.data) {
            root.left = insert(x, root.left);
            if (height(root.left) - height(root.right) == 2)
                if (x < root.left.data)
                    root = leftRotate(root);
                else
                    root = rightleftRotate(root);
        } else if (x > root.data) {
            root.right = insert(x, root.right);
            if (height(root.right) - height(root.left) == 2)
                if (x > root.right.data)
                    root = rightRotate(root);
                else
                    root = leftrightRotate(root);
        } else
            throw new DuplicateElementException(root.data);
        root.height = max(height(root.left), height(root.right)) + 1;
        return root;
    }

    private Node leftRotate(Node node) {
        Node newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        node.height = max(height(node.left), height(node.right)) + 1;
        newNode.height = max(height(newNode.left), node.height) + 1;
        return newNode;
    }


    private Node rightRotate(Node node) {
        Node newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        node.height = max(height(node.left), height(node.right)) + 1;
        newNode.height = max(height(newNode.right), node.height) + 1;
        return newNode;
    }

    private Node rightleftRotate(Node node) {
        node.left = rightRotate(node.left);
        return leftRotate(node);
    }

    private Node leftrightRotate(Node node) {
        node.right = leftRotate(node.right);
        return rightRotate(node);
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node root, int val) {
        boolean found = false;
        while ((root != null) && !found) {
            int rval = root.data;
            if (val < rval)
                root = root.left;
            else if (val > rval)
                root = root.right;
            else {
                found = true;
                break;
            }
            found = search(root, val);
        }
        return found;
    }

    public void treeInorderWalk() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void treePreorderWalk() {
        preorder(root);
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void treePostorderWalk() {
        postorder(root);
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    void treeLevelorderWalk() {
        int h = maxHeight(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    int maxHeight(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = maxHeight(root.left);  // sprawdzamy wysokość każdego subdrzewa
            int rheight = maxHeight(root.right);

            if (lheight > rheight) // i znajdujemy maksymalna wysokosc
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);  //przekazujemy poziom niższy jakby był rootem jeśli to jeszcze nie nasz szukany poziom
            printGivenLevel(root.right, level - 1);
        }
    }

    public void print() {
        printBinaryTree(root, 0);
    }

    public void printBinaryTree(Node root, int level) {
        if (root == null)
            return;
        printBinaryTree(root.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|--" + root.data);
        } else
            System.out.println(root.data);
        printBinaryTree(root.left, level + 1);
    }
}
