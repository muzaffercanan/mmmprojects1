public class IDBST {
    private IDBSTNode root;

    // Constructor
    public IDBST() {
        this.root = null;
    }

    // Insert a node into the ID BST
    public void insert(int ID) {
        this.root = insertRec(this.root, ID);
    }

    private IDBSTNode insertRec(IDBSTNode root, int ID) {
        if (root == null) {
            root = new IDBSTNode(ID);
            return root;
        }

        if (ID < root.ID) {
            root.left = insertRec(root.left, ID);
        } else if (ID > root.ID) {
            root.right = insertRec(root.right, ID);
        }

        return root;
    }

    // Other methods for ID BST (search, delete, etc.) can be added as needed
    // Delete a node with a given ID
    public void delete(int ID) {
        this.root = deleteRec(this.root, ID);
    }

    private IDBSTNode deleteRec(IDBSTNode root, int ID) {
        if (root == null) {
            return root;
        }

        if (ID < root.ID) {
            root.left = deleteRec(root.left, ID);
        }

        else if (ID > root.ID) {
            root.right = deleteRec(root.right, ID);
        }

        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            }

            else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            root.ID = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.ID);
        }

        return root;
    }

    private int minValue(IDBSTNode root) {
        int minValue = root.ID;
        while (root.left != null) {
            minValue = root.left.ID;
            root = root.left;
        }
        return minValue;
    }

public void insertrec(IDBSTNode root , int ID){

        if(root==null){
            root = new IDBSTNode(ID);
        }
        else if(ID<root.ID){
            root.left = insertrec(IDBSTNode root, int ID);
        }
    }

}
