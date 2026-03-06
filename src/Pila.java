import java.util.ArrayList;

// Clase que implementa una pila por medio de un arreglo.
public class Pila {

    private String[] elementos;
    private int cima;
    private int capacidad;

    public Pila(int capacidad){
        this.capacidad = capacidad;
        elementos = new String[capacidad];
        cima = -1;
    }

    // Push: agrega un elemento a la pila
    public void push(String valor) {
        if (cima < capacidad - 1) {
            cima++;
            elementos[cima] = valor;
        } else {
            System.out.println("La pila está llena.");
        }
    }

    // pop: elimina y retorna el elemento en la cima
    public String pop() {
        if (!isEmpty()) {
            String valor = elementos[cima];
            cima--;
            return valor;
        } else {
            return null;
        }
    }

    // peek: devuelve el elemento en la cima sin eliminarlo
    public String peek() {
        if (!isEmpty()) {
            return elementos[cima];
        }
        return null;
    }

    // isEmpty: verifica si la pila está vacía
    public boolean isEmpty() {
        return cima == -1;
    }

    // Método para vaciar la pila
    public void clear() {
        cima = -1;
    }
}
