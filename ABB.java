// Clase de Árbol Binario de Búsqueda (ABB / BST en inglés)
// Nombre: Camila Madelaine Dos Santos
// Legajo: INF388-11130
// DNI: 43256551

class ABB {

    // Esta clase interna representa un nodo del árbol.
    // Cada nodo tiene un valor (clave) y dos referencias a sus hijos izquierdo y derecho.
    class Nodo {
        int clave;
        Nodo izquierda, derecha;

        public Nodo(int data) {
            clave = data;
            izquierda = derecha = null;
        }
    }

    // Nodo raíz que representa el inicio del árbol
    Nodo raiz;

    // Constructor: inicializo el árbol vacío (raíz = null)
    ABB() {
        raiz = null;
    }

    // --------------------------------------------------------------------
    // MÉTODOS PARA BORRAR NODOS 
    // --------------------------------------------------------------------
    void borrarClave(int clave) {
        raiz = borrar_Recursivo(raiz, clave);
    }

    Nodo borrar_Recursivo(Nodo raiz, int clave) {
        if (raiz == null) return raiz;

        if (clave < raiz.clave) {
            raiz.izquierda = borrar_Recursivo(raiz.izquierda, clave);
        } else if (clave > raiz.clave) {
            raiz.derecha = borrar_Recursivo(raiz.derecha, clave);
        } else {
            if (raiz.izquierda == null)
                return raiz.derecha;
            else if (raiz.derecha == null)
                return raiz.izquierda;

            // Caso con dos hijos: reemplazo el valor por el mínimo del subárbol derecho
            raiz.clave = ValorMinimo(raiz.derecha);

            // Borro el nodo que tenía ese valor mínimo
            raiz.derecha = borrar_Recursivo(raiz.derecha, raiz.clave);
        }
        return raiz;
    }

    // --------------------------------------------------------------------
    // MÉTODO ValorMinimo
    // --------------------------------------------------------------------
    // Este método recorre el subárbol que recibe por parámetro
    // hasta encontrar el nodo más a la izquierda (el menor valor).
    // Lo implementé yo completamente para devolver ese valor mínimo.
    int ValorMinimo(Nodo raiz) {
        int minValor = raiz.clave;         // Asumo que el mínimo es la raíz recibida
        while (raiz.izquierda != null) {   // Mientras haya hijos izquierdos, avanzo
            raiz = raiz.izquierda;
            minValor = raiz.clave;
        }
        return minValor; // Devuelvo el valor mínimo encontrado
    }

    // --------------------------------------------------------------------
    // MÉTODO insertar_Recursivo
    // --------------------------------------------------------------------
    // Este método inserta de forma recursiva una nueva clave en el árbol.
    // Lo implementé yo siguiendo la lógica de un ABB:
    // - Si está vacío, creo un nuevo nodo.
    // - Si la clave es menor, inserto en el subárbol izquierdo.
    // - Si la clave es mayor, inserto en el subárbol derecho.
    // - Si es igual, no la inserto (evito duplicados).
    Nodo insertar_Recursivo(Nodo raiz, int clave) {
        if (raiz == null) {
            return new Nodo(clave); // Caso base: árbol vacío, creo nodo nuevo
        }

        if (clave < raiz.clave) {
            raiz.izquierda = insertar_Recursivo(raiz.izquierda, clave); // Inserto a la izquierda
        } else if (clave > raiz.clave) {
            raiz.derecha = insertar_Recursivo(raiz.derecha, clave);     // Inserto a la derecha
        }
        // Si es igual no hago nada

        return raiz; // Devuelvo la referencia al nodo actual para mantener el enlace del árbol
    }

    // Método público para insertar (invoca al recursivo)
    void insertar(int clave) {
        raiz = insertar_Recursivo(raiz, clave);
    }

    // --------------------------------------------------------------------
    // MÉTODOS AUXILIARES: inorder y buscar (dados en el enunciado)
    // --------------------------------------------------------------------
    void inorder() {
        inorder_Recursive(raiz);
    }

    void inorder_Recursive(Nodo raiz) {
        if (raiz != null) {
            inorder_Recursive(raiz.izquierda);
            System.out.print(raiz.clave + " ");
            inorder_Recursive(raiz.derecha);
        }
    }

    boolean buscar(int clave) {
        Nodo resultado = buscar_Recursivo(raiz, clave);
        return (resultado != null);
    }

    Nodo buscar_Recursivo(Nodo raiz, int clave) {
        if (raiz == null || raiz.clave == clave)
            return raiz;

        if (clave < raiz.clave)
            return buscar_Recursivo(raiz.izquierda, clave);

        return buscar_Recursivo(raiz.derecha, clave);
    }

    // --------------------------------------------------------------------
    // MAIN DE PRUEBA
    // --------------------------------------------------------------------
    public static void main(String[] args) {
        ABB ABB = new ABB();

        /* ABB de ejemplo
                45
               /  \
             10    90
            / \    /
           7  12  50
        */

        // Inserto los valores en el ABB
        ABB.insertar(45);
        ABB.insertar(10);
        ABB.insertar(7);
        ABB.insertar(12);
        ABB.insertar(90);
        ABB.insertar(50);

        System.out.println("El árbol ABB ha sido creado (inorder izquierda - raíz - derecha):");
        ABB.inorder();

        System.out.println("\nEl árbol ABB después de borrar 12 (Nodo hoja):");
        ABB.borrarClave(12);
        ABB.inorder();

        System.out.println("\nEl árbol ABB después de borrar 90 (Nodo con 1 hijo):");
        ABB.borrarClave(90);
        ABB.inorder();

        System.out.println("\nEl árbol ABB después de borrar 45 (Nodo con 2 hijos):");
        ABB.borrarClave(45);
        ABB.inorder();

        boolean ret_val = ABB.buscar(50);
        System.out.println("\nClave 50 en el ABB: " + ret_val);
        ret_val = ABB.buscar(12);
        System.out.println("Clave 12 en el ABB: " + ret_val);
    }
}