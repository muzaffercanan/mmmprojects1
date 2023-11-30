class NameSurnameBST {
    private NameSurnameBSTNode root;

    // Constructor
    public NameSurnameBST() {
        this.root = null;
    }

    // Insert a node into the Name-Surname BST
    public void insert(String nameSurname, Student student) {
        this.root = insertRec(this.root, nameSurname, student);
    }

    private NameSurnameBSTNode insertRec(NameSurnameBSTNode root, String nameSurname, Student student) {
        if (root == null) {
            root = new NameSurnameBSTNode(nameSurname, student);
            return root;
        }

        if (nameSurname.compareTo(root.nameSurname) < 0) {
            root.left = insertRec(root.left, nameSurname, student);
        } else if (nameSurname.compareTo(root.nameSurname) > 0) {
            root.right = insertRec(root.right, nameSurname, student);
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

    // Exact search by Name-Surname
    //...
    public Student exactSearch(String nameSurname) {
        return exactSearchRec(this.root, nameSurname);
    }

    private Student exactSearchRec(NameSurnameBSTNode root, String nameSurname) {
        if (root == null || root.nameSurname.equals(nameSurname)) {
            return (root != null) ? root.student : null;
        }

        if (nameSurname.compareTo(root.nameSurname) < 0) {
            return exactSearchRec(root.left, nameSurname);
        }

        return exactSearchRec(root.right, nameSurname);
    }

    // Interval search by Name-Surname
    public void intervalSearch(String startNameSurname, String endNameSurname) {
        intervalSearchRec(this.root, startNameSurname, endNameSurname);
    }

    private void intervalSearchRec(NameSurnameBSTNode root, String startNameSurname, String endNameSurname) {
        if (root != null) {
            // If current node's nameSurname is greater than the startNameSurname,
            // then search in the left subtree
            if (root.nameSurname.compareTo(startNameSurname) > 0) {
                intervalSearchRec(root.left, startNameSurname, endNameSurname);
            }

            // If current node's nameSurname is within the interval, print it
            if (root.nameSurname.compareTo(startNameSurname) >= 0 && root.nameSurname.compareTo(endNameSurname) <= 0) {
                System.out.println("Found student in interval: " + root.student.getName());
            }

            // If current node's nameSurname is less than the endNameSurname,
            // then search in the right subtree
            if (root.nameSurname.compareTo(endNameSurname) < 0) {
                intervalSearchRec(root.right, startNameSurname, endNameSurname);
            }
        }
    }
}
