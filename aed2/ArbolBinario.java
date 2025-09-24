//*********************************************************
//* Nombre: CamilaMadelaineDosSantos
//* Legajo:INF388
//* DNI: 43256551
//*********************************************************

import java.io.*;

// Definición de la clase NodoBinario
class NodoBinario {
    int dato;
    NodoBinario Hizq, Hder;

    // Constructor
    NodoBinario(int Elem) {
        dato = Elem;
        Hizq = null;
        Hder = null;
    }
}

// Definición de la clase Arbol
class Arbol {
    public NodoBinario Raiz;

    // Constructor
    public Arbol() {
        Raiz = null;
    }

    // Inserción de un hijo izquierdo
    public NodoBinario InsertaNodoHIzq(NodoBinario Nodo, int Elem) {
        NodoBinario result = null;
        if (Nodo == null) {
            NodoBinario NodoAux = new NodoBinario(Elem);
            result = NodoAux;
            Raiz = NodoAux;
        } else {
            if (Nodo.Hizq == null) {
                NodoBinario NodoAux = new NodoBinario(Elem);
                Nodo.Hizq = NodoAux;
                result = NodoAux;
            } else {
                System.out.print("ERR- Hijo izquierdo de " + Elem + " no es nulo\n");
            }
        }
        return result;
    }

    // Inserción de un hijo derecho
    public NodoBinario InsertaNodoHDer(NodoBinario Nodo, int Elem) {
        NodoBinario result = null;
        if (Nodo == null) {
            NodoBinario NodoAux = new NodoBinario(Elem);
            result = NodoAux;
            Raiz = NodoAux;
        } else {
            if (Nodo.Hder == null) {
                NodoBinario NodoAux = new NodoBinario(Elem);
                Nodo.Hder = NodoAux;
                result = NodoAux;
            } else {
                System.out.print("ERR- Hijo derecho de " + Elem + " no es nulo\n");
            }
        }
        return result;
    }

    // Recorrido Inorden (Izquierda - Raíz - Derecha)
    public void Inorden(NodoBinario Nodo) {
        if (Nodo != null) {
            Inorden(Nodo.Hizq);
            System.out.print(Nodo.dato + " ");
            Inorden(Nodo.Hder);
        }
    }

    // Cálculo de la altura del árbol
    public int Altura(NodoBinario Nodo) {
        if (Nodo == null) {
            return 0;
        } else {
            int altIzq = Altura(Nodo.Hizq);
            int altDer = Altura(Nodo.Hder);
            return 1 + Math.max(altIzq, altDer);
        }
    }
}

// Clase principal
class ArbolBinario {
    public static void main(String[] ar) {
        Arbol A = new Arbol();
        System.out.print("Agregando la raiz 30 \n");

        NodoBinario NodoAux = null, NodoAux2 = null, NodoAux3 = null, NodoAux4 = null;

        NodoAux2 = A.InsertaNodoHIzq(NodoAux, 30); // raíz
        NodoAux = NodoAux2;

        NodoAux2 = A.InsertaNodoHIzq(NodoAux, 25);
        NodoAux3 = A.InsertaNodoHDer(NodoAux, 45);

        NodoAux = NodoAux2;
        NodoAux2 = A.InsertaNodoHIzq(NodoAux, 20);
        NodoAux4 = A.InsertaNodoHDer(NodoAux, 27);

        System.out.print("\nEl árbol binario en Inorden es: \n");
        A.Inorden(A.Raiz);

        Integer Altura = A.Altura(A.Raiz);
        System.out.print("\n\nLa altura del árbol es: " + Altura + "\n");
    }
}
