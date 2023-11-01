public class Node {
    private Integer value = null;
    private Node left = null;
    private Node right = null;

    public Node() {}

    public void add(int value) {
        if (this.value == null) this.value = value;
        else if (this.value == value) throw new RuntimeException("El valor ya existe en el árbol");
        else if (value < this.value) {
            if (this.left == null) this.left = new Node();
            this.left.add(value);
        } else {
            if (this.right == null) this.right = new Node();
            this.right.add(value);
        }
    }

    public void preorden() {
        if (this.value != null) {
            System.out.print(this.value + " ");
            if (this.left != null) this.left.preorden();
            if (this.right != null) this.right.preorden();
        }
    }

    public void inorden() {
        if (this.value != null) {
            if (this.left != null) this.left.inorden();
            System.out.print(this.value + " ");
            if (this.right != null) this.right.inorden();
        }
    }

    public void postorden() {
        if (this.value != null) {
            if (this.left != null) this.left.postorden();
            if (this.right != null) this.right.postorden();
            System.out.print(this.value + " ");
        }
    }

    public void delete(int value) {
        if (this.value == null) throw new RuntimeException("El valor no existe en el árbol");
        // Si el valor es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        else if (value < this.value) {
            if (this.left == null) throw new RuntimeException("El valor no existe en el árbol");
            else if (this.left.value != value) {
                this.left.delete(value);
                return;
            }
            if (this.left.left == null && this.left.right == null) this.left = null;
            else if (this.left.left == null) this.left = this.left.right;
            else if (this.left.right == null) this.left = this.left.left;
            else {
                Node ref = this.left.right;
                while (ref.left != null) ref = ref.left;
                ref.left = this.left.left;
                this.left = this.left.right;
            }
            return;
        // Si el valor es mayor que el valor del nodo actual, buscar en el subárbol derecho
        } else if (value > this.value) {
            if (this.right == null) throw new RuntimeException("El valor no existe en el árbol");
            else if (this.right.value != value) {
                this.right.delete(value);
                return;
            }
            if (this.right.left == null && this.right.right == null) this.right = null;
            else if (this.right.left == null) this.right = right.right;
            else if (this.right.right == null) this.right = right.left;
            else {
                Node ref = this.right.right;
                while (ref.left != null) ref = ref.left;
                ref.left = this.right.left;
                this.right = this.right.right;
            }
            return;
        }
        // Si el valor es igual al valor del nodo actual
        if (this.left == null && this.right == null) this.value = null;
        else if (this.left == null) this.value = this.right.value;
        else if (this.right == null) this.value = this.left.value;
        else {
            Node ref = this.right;
            while (ref.left != null) ref = ref.left;
            ref.left = this.left;
            this.value = this.right.value;
            this.right = this.right.right;
        }
    }

    public static void main(String[] args) {
        Node arbol = new Node();
        arbol.add(5);
        arbol.add(3);
        arbol.add(7);
        arbol.add(2);
        arbol.add(4);
        arbol.add(6);
        arbol.add(8);
        arbol.preorden();
        System.out.println();
        arbol.inorden();
        System.out.println();
        arbol.postorden();
        System.out.println();
        arbol.delete(5);
        arbol.preorden();
        System.out.println();
        arbol.inorden();
        System.out.println();
        arbol.postorden();
        System.out.println();
    }

}
