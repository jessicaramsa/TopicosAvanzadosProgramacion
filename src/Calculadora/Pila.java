package Calculadora;

public class Pila {
    private String[] pila;
    private int tope;

    public Pila(int capacidad) {
        pila = new String[capacidad];
        tope = -1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public void push(String cad) {
        if (tope + 1 < pila.length)
            pila[++tope] = cad;
    }

    public String pop() {
        if (isEmpty())
            return "";
        return pila[tope--];
    }

    public String cima() {
        return pila[tope];
    }
}
