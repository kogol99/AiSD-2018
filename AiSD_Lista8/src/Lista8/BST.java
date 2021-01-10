package Lista8;

import java.util.NoSuchElementException;

public class BST<T> {
    private Node<T> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void insert(T value) throws DuplicateElementException {
        root = insert(root, value);
        size++;
    }

    private Node<T> insert(Node<T> node, T value) throws DuplicateElementException {
        if (node == null) {
            node = new Node<>(value);
        } else {
            int compVal = compareTo(value, node.value);
            if (compVal < 0) {
                node.left = insert(node.left, value);
                node.left.parent = node;
            } else {
                if (compVal > 0) {
                    node.right = insert(node.right, value);
                    node.right.parent = node;
                } else {
                    size--;
                    throw new DuplicateElementException(value.toString());
                }
            }
        }
        return node;
    }

    public T find(T data) {
        Node<T> node = search(data);
        return node == null ? null : node.value;
    }

    private Node<T> search(T data) {
        Node<T> node = root;
        int compVal;
        while (node != null && (compVal = compareTo(data, node.value)) != 0) {
            node = compVal < 0 ? node.left : node.right;
        }
        return node;
    }

    public T getMax() {
        if (root == null)
            throw new NoSuchElementException();
        Node<T> node = getMax(root);
        return node.value;
    }

    private Node<T> getMax(Node<T> node) {
        assert (node != null);
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public T getMin() {
        if (root == null)
            throw new NoSuchElementException();
        Node<T> node = getMin(root);
        return node.value;
    }

    private Node<T> getMin(Node<T> node) {
        assert (node != null);
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public T successor(T elem) {
        Node<T> succNode = successorNode(root, elem);
        return succNode == null ? null : succNode.value;
    }

    private Node<T> successorNode(Node<T> node, T elem) {
        if (node == null)
            throw new NoSuchElementException();

        int compVal = compareTo(elem, node.value);
        if (compVal == 0) {
            if (node.right != null) {
                return getMin(node.right);
            } else {
                return null;
            }
        } else {
            if (compVal < 0) {
                Node<T> retNode = successorNode(node.left, elem);
                return retNode == null ? node : retNode;
            } else {
                return successorNode(node.right, elem);
            }
        }
    }

    public void delete(T data) {
        treeDelete(root, search(data));
    }

    public Node<T> treeDelete(Node<T> node, Node<T> z) {
        Node<T> y, x;
        if ((z.left == null) || (z.right == null)) {
            y = z;
        } else {
            y = successorNode(node, z.value);
        }
        if (y != null) {
            size--;
            if (y.left != null) {
                x = y.left;
            } else
                x = y.right;
            if (x != null)
                x.parent = y.parent;
            if (y.parent == null)
                node = x;
            else {
                if (y == y.parent.left)
                    y.parent.left = x;
                else
                    y.parent.right = x;
            }
            if (y != z) {
                T val = z.value;
                z.value = y.value;
                y.value = val;
            }
        }
        return y;
    }

    public void print(){
        printBinaryTree(root,0);
    }

    public void printBinaryTree(Node root, int level){
        if(root==null)
            return;
        printBinaryTree(root.right, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|--"+root.value);
        }
        else
            System.out.println(root.value);
        printBinaryTree(root.left, level+1);
    }

    public int compareTo(T a, T b){
        if(((Integer) a)>((Integer) b)) return 1;
        if(((Integer) a)<((Integer) b)) return -1;
        return 0;
    }

    public void repairTree() {
        DSW dsw = new DSW();
        dsw.create();
        dsw.balance();
    }

    private class DSW{
        public void create() {
            create(root);
        }

        private void create(Node<T> tmp) {
            while (tmp != null) {
                if (tmp.left != null) {
                    rightRotate(tmp, tmp.left);
                    tmp = tmp.parent;

                } else {
                    tmp = tmp.right;
                }
            }
        }

        public void balance() {
            int m = (int) Math.pow(2,Math.floor((Math.log10(size+1))/(Math.log10(2)))) - 1;
            Node<T> tmp = root;
            for(int i = size-m ; i >= 0 ; i--) {
                if(tmp.right == null)
                    break;
                leftRotate(tmp, tmp.right);
                tmp = tmp.parent;
            }
            tmp = tmp.right;
            while (m > 1) {
                m = (int) Math.floor(m / 2);
                for(int i = 0 ; i < m ; i++) {
                    if(tmp.right == null)
                        break;
                    leftRotate(tmp, tmp.right);
                    tmp = tmp.parent.right;
                }
                tmp = root;
            }
        }

        public void leftRotate(Node<T> x, Node<T> y) {
            if(x.parent == null){
                root = y;
            } else{
                if(x.parent.left == x){
                    x.parent.left = y;
                }else
                    x.parent.right = y;
            }
            y.parent = x.parent;
            x.parent = y;

            x.right = y.left;
            y.left = x;
            if(x.right != null)
                x.right.parent = x;
        }

        public void rightRotate(Node<T> y, Node<T> x) {
            Node<T> pom = x.right;
            if(y.parent == null)
                root = x;
            if(y.parent != null) {
                if (y == y.parent.left)
                    y.parent.left = x;
                else
                    y.parent.right = x;
            }
            x.parent = y.parent;
            y.parent = x;
            x.right = y;
            y.left = pom;
        }
    }

    private class Node<T> {
        T value;
        Node<T> left, right, parent;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /*##############################################################################*/
    /*                                    ZADANIE 2                                 */
    /*##############################################################################*/

    public void Tree_Inorder_Walk(ElementToStringExec exec){ // wypisywanie jest pomiedzy odwiedzonym ostatnim lewym (left=null), a wejsciu w prawy
        Tree_Inorder_Walk(root,exec);
    }

    public <R> void Tree_Inorder_Walk(Node<T> x, ElementToStringExec exec){
        if (x != null){
            Tree_Inorder_Walk(x.left,exec);
            exec.execute((Integer) x.value);
            Tree_Inorder_Walk(x.right,exec);
        }
    }

    public void Tree_Preorder_Walk(ElementToStringExec exec){ //rozpoczynamy od wypisywanie od korzenia idąć w dół lewo
        Tree_Preorder_Walk(root,exec);
    }

    public <R> void Tree_Preorder_Walk(Node<T> x, ElementToStringExec exec){
        if (x != null){
            exec.execute((Integer) x.value);
            Tree_Preorder_Walk(x.left,exec);
            Tree_Preorder_Walk(x.right,exec);
        }
    }

    public void Tree_Postorder_Walk(ElementToStringExec exec){ // rozpoczynamy od najniższego elementu, po odwiedzeniu wszystkich węzłów rozpoczyna się wypisywanie
        Tree_Postorder_Walk(root,exec);
    }

    public <R> void Tree_Postorder_Walk(Node<T> x, ElementToStringExec exec){
        if (x != null){
            Tree_Postorder_Walk(x.left,exec);
            Tree_Postorder_Walk(x.right,exec);
            exec.execute((Integer) x.value);
        }
    }

    void Tree_Levelorder_Walk(ElementToStringExec exec)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i,exec);
    }

    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            int lheight = height(root.left);  // sprawdzamy wysokość każdego subdrzewa
            int rheight = height(root.right);

            if (lheight > rheight) // i znajdujemy maksymalna wysokosc
                return(lheight+1);
            else return(rheight+1);
        }
    }

    void printGivenLevel (Node root ,int level,ElementToStringExec exec)
    {
        if (root == null)
            return;
        if (level == 1)
            exec.execute((Integer) root.value);
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1,exec);  //przekazujemy poziom niższy jakby był rootem jeśli to jeszcze nie nasz szukany poziom
            printGivenLevel(root.right, level-1,exec);
        }
    }

}
