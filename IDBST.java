class IDBST {
   IDBSTNode root;

    // Constructor
    public IDBST() {
        this.root = null;
    }

    // Insert a node into the ID BST
    public void insert(int ID, Student student) {
        this.root = insertRec(this.root, ID, student);
    }

    private IDBSTNode insertRec(IDBSTNode root, int ID, Student student) {
        if (root == null) {
            root = new IDBSTNode(ID, student);
            return root;
        }

        if (ID < root.ID) {
            root.left = insertRec(root.left, ID, student);
        } else if (ID > root.ID) {
            root.right = insertRec(root.right, ID, student);
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
        } else if (ID > root.ID) {
            root.right = deleteRec(root.right, ID);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
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

    // Exact search by ID
    //...
    public Student exactSearch(int ID) {
        return exactSearchRec(this.root, ID);
    }

    private Student exactSearchRec(IDBSTNode root, int ID) {
        if (root == null || root.ID == ID) {
            return (root != null) ? root.student : null;
        }

        if (ID < root.ID) {
            return exactSearchRec(root.left, ID);
        }

        return exactSearchRec(root.right, ID);
    }
}
