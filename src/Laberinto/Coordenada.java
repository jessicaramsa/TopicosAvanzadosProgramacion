package Laberinto;

public class Coordenada {
    int x, y;
    int[][] matriz = new int[1][2];

    public Coordenada() {}

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada getCoordenada() {
        return new Coordenada(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
