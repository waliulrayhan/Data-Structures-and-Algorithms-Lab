package bst;

        import java.util.Scanner;
        import java.util.Vector;
class BST_class {
    Vector<Integer> arr= new Vector<>();

    class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }

    Node root;

    BST_class(){
        root = null;
    }

    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    Node delete_Recursive(Node root, int key)  {

        if (root == null)  return root;


        if (key < root.key)
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)
            root.right = delete_Recursive(root.right, key);
        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);

            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root)  {
        int minval = root.key;

        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    int min(){
        return minValue(root);
    }

    int maxValue(Node root)  {
        int maxval = root.key;
        while (root.right != null)  {
            maxval = root.right.key;
            root = root.right;
        }
        return maxval;
    }

    int max(){
        return maxValue(root);
    }

    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);

        return root;
    }

    void inorder() {
        inorder_Recursive(root);
    }

    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            arr.add(root.key);
            inorder_Recursive(root.right);
        }
    }

    void preorder(){
        preorder_Recursive(root);
    }

    void preorder_Recursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder_Recursive(root.left);
            preorder_Recursive(root.right);
        }
    }

    void postorder(){
        postorder_Recursive(root);
    }

    void postorder_Recursive(Node root) {
        if (root != null) {
            postorder_Recursive(root.left);
            postorder_Recursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    boolean search(int key)  {
        root = search_Recursive(root, key);
        if (root!= null) {
            return true;
        }
        else
            return false;
    }

    Node search_Recursive(Node root, int key)  {

        if (root==null || root.key==key)
            return root;
        if (root.key > key)
            return search_Recursive(root.left, key);
        return search_Recursive(root.right, key);
    }

    void successor(int key){
        for (int i=0;i<arr.size();i++){
            if (arr.get(i) ==key){
                System.out.println(arr.get(i+1));
                break;
            }
        }
    }
    void predecessor(int key){
        for (int i=0;i<arr.size();i++){
            if (arr.get(i) ==key){
                System.out.println(arr.get(i-1));
                break;
            }
        }
    }
}
class Main{
    public static void main(String[] args)  {

        Scanner input= new Scanner(System.in);
        BST_class bst = new BST_class();
        bst.insert(23);
        bst.insert(18);
        bst.insert(44);
        bst.insert(12);
        bst.insert(20);
        bst.insert(35);
        bst.insert(52);

        System.out.println("1. Traverse the Tree.");
        System.out.println("2. Insert node.");
        System.out.println("3. Delete node.");
        System.out.println("4. Show Maximum node.");
        System.out.println("5. Show Minimum node.");
        System.out.println("6. Search a node.");
        System.out.println("7. Find Successor.");
        System.out.println("8. Find Predecessor.");
        System.out.println("0. Exit");

        while(true) {
            System.out.print("\nEnter your choice: ");
            int n;
            n = input.nextInt();
            if (n == 1) {
                System.out.println("1. PreOrder.");
                System.out.println("2. InOrder.");
                System.out.println("3. PostOrder.");
                System.out.print("Choose option: ");
                int x;
                x = input.nextInt();
                if(x==1){
                    bst.preorder();
                }
                else if(x==2){
                    bst.inorder();
                }
                else if(x==3){
                    bst.postorder();
                }
                else{
                    System.out.println("Invalid Choice!");
                }
            }
            else if (n == 2) {
                System.out.print("Enter a value to insert:");
                int x;
                x = input.nextInt();
                bst.insert(x);
                bst.inorder();
            }
            else if (n == 3) {
                System.out.print("Enter a value to delete :");
                int x;
                x = input.nextInt();
                bst.deleteKey(x);
                bst.inorder();
            }
            else if (n == 4) {
                int x=bst.max();
                System.out.println(x);
            }
            else if (n == 5) {
                int x=bst.min();
                System.out.println(x);
            }
            else if(n==6){
                System.out.print("Enter a value to search :");
                int x;
                x = input.nextInt();
                boolean ret_val = bst.search (x);
                System.out.println("\nKey "+x+" found in BST:" + ret_val );
            }
            else if(n==7){
                System.out.print("Find Successor of node: ");
                int x;
                x = input.nextInt();
                bst.successor(x);
            }
            else if(n==8){
                System.out.print("Find Predecessor of node: ");
                int x;
                x = input.nextInt();
                bst.predecessor(x);
            }

            else if (n == 0) {
                break;
            }
            else {
                System.out.println("1. Traverse the Tree.");
                System.out.println("2. Insert node.");
                System.out.println("3. Delete node.");
                System.out.println("4. Show Maximum node.");
                System.out.println("5. Show Minimum node.");
                System.out.println("6. Search a node.");
                System.out.println("7. Find Successor.");
                System.out.println("8. Find Predecessor.");
                System.out.println("0. Exit");
            }
        }
    }
}

