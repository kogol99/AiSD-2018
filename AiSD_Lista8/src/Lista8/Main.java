package Lista8;

public class Main {

    public static void main(String[] args) {

        BST<Integer> tree = new BST<Integer>();

        System.out.println();
        System.out.println("----------------- Zadanie 1. ... -----------------");
        System.out.println();
        System.out.println("----------------- Dodawanie 7 elementow ... -----------------");
        try {
            tree.insert(20);
            tree.insert(15);
            tree.insert(30);
            tree.insert(25);
            tree.insert(40);
            tree.insert(23);
            tree.insert(28);
        } catch (DuplicateElementException e){
            System.out.println("Blad dodawania");
        }


        System.out.println();
        System.out.println("----------------- Drukowanie BinarySearchTree ... -----------------");
        tree.print();

        System.out.println();
        System.out.println("----------------- Balans BinarySearchTree ... -----------------");
        tree.repairTree();

        System.out.println();
        System.out.println("----------------- Drukowanie BinarySearchTree po DSW ... -----------------");
        tree.print();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------- Zadanie 2. ... -----------------");
        System.out.println();
        System.out.println("----------------- Drukowanie BinarySearchTree Inorder Walk ... -----------------");
        ElementToStringExec exec=new ElementToStringExec();
        tree.Tree_Inorder_Walk(exec);
        System.out.println(exec.getResult());

        System.out.println();
        System.out.println("----------------- Drukowanie BinarySearchTree Preorder Walk ... -----------------");
        exec=new ElementToStringExec();
        tree.Tree_Preorder_Walk(exec);
        System.out.println(exec.getResult());

        System.out.println();
        System.out.println("----------------- Drukowanie BinarySearchTree Postorder Walk ... -----------------");
        exec=new ElementToStringExec();
        tree.Tree_Postorder_Walk(exec);
        System.out.println(exec.getResult());

        System.out.println();
        System.out.println("----------------- Drukowanie BinarySearchTree Levelorder Walk ... -----------------");
        exec=new ElementToStringExec();
        tree.Tree_Levelorder_Walk(exec);
        System.out.println(exec.getResult());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------- Zadanie 3. ... -----------------");
        System.out.println();
        System.out.println("----------------- Wykonywanie testu na szybkosc obu drzew ... -----------------");
        Tester test = new Tester();
        test.wykonanieTestu();
    }
}
