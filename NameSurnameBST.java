public class NameSurnameBST {
    private NameSurnameBSTNode root;

    // Constructor
    public NameSurnameBST() {
        this.root = null;
    }

    // Insert a node into the Name-Surname BST
    public void insert(String nameSurname) {
        this.root = insertRec(this.root, nameSurname);
    }

    private NameSurnameBSTNode insertRec(NameSurnameBSTNode root, String nameSurname) {
        if (root == null) {
            root = new NameSurnameBSTNode(nameSurname);
            return root;
        }

        if (nameSurname.compareTo(root.nameSurname) < 0) {
            root.left = insertRec(root.left, nameSurname);
        } else if (nameSurname.compareTo(root.nameSurname) > 0) {
            root.right = insertRec(root.right, nameSurname);
        }

        return root;
    }

    // Other methods for Name-Surname BST (search, delete, etc.) can be added as
    // needed
    // Delete a node with a given nameSurname
    public void delete(String nameSurname) {
        this.root = deleteRec(this.root, nameSurname);
    }

    private NameSurnameBSTNode deleteRec(NameSurnameBSTNode root, String nameSurname) {
        if (root == null) {
            return root;
        }

        if (nameSurname.compareTo(root.nameSurname) < 0) {
            root.left = deleteRec(root.left, nameSurname);
        } else if (nameSurname.compareTo(root.nameSurname) > 0) {
            root.right = deleteRec(root.right, nameSurname);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            root.nameSurname = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.nameSurname);
        }

        return root;
    }

    private String minValue(NameSurnameBSTNode root) {
        String minValue = root.nameSurname;
        while (root.left != null) {
            minValue = root.left.nameSurname;
            root = root.left;
        }
        return minValue;
    }
}
