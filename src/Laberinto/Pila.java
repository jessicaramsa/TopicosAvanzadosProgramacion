package Laberinto;

public class Pila {
    private Coordenada[] pila;
    private int tope;

    public Pila(int capacidad) {
        pila = new Coordenada[capacidad];
        tope = -1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public void push(Coordenada coord) {
        if (tope + 1 < pila.length)
            pila[++tope] = coord;
    }

    public Coordenada pop() {
        if (isEmpty())
            return new Coordenada(-1, -1);
        return pila[tope--];
    }

    public Coordenada cima() {
        return pila[tope];
    }

    public void visualiza() {
        for (int i = 0; pila[i] != null; i++)
            System.out.println(i + ". " + pila[i]);
    }
}
