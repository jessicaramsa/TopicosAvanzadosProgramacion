package CambioColores;

public enum nColores {
    NEGRO(0, 0, 0),
    BLANCO(255, 255, 255),
    ROJO(255, 0, 0),
    VERDE(0, 255, 0),
    AZUL(0, 0, 255),
    ROSA(255, 0, 255),
    AMARILLO(255, 255, 0),
    CYAN(0, 255, 255),
    GRIS(128, 128, 128),
    CAFE(126, 42, 42),
    SALMON(250, 128, 114),
    NARANJA(255, 165, 0),
    TURQUESA(64, 224, 208),
    AZUL_CIELO(135, 206, 250),
    MORADO(128, 0, 128),
    VIOLETA(238, 130, 238),
    BEIGE(245, 245, 220),
    OLIVA(128, 128, 0);
    private int r, g, b;

    private nColores(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
