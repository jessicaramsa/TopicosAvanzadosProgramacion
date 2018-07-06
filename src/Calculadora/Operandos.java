package Calculadora;

public class Operandos {
    double resp;
    double va, vb;
    int error;
    Pila pila;

    public Operandos() {
        pila = new Pila(1000);
        resp = 0;
        error = 0;
    }

    public void añadir(char c) {
        String s = String.valueOf(c);
        char pi;
        if(c == '(')
            pila.push(s);
        else {
            if (c == ')') {
                if (pila.isEmpty() == false)
                    pi = pila.pop().charAt(0);
            }
        }
    }

    public double suma(double v1, double v2) {
        return v1 + v2;
    }

    public double resta(double v1, double v2) {
        return v1 - v2;
    }

    public double multiplicar(double v1, double v2) {
        return v1 * v2;
    }

    public double dividir(double v1, double v2) {
        if (Double.compare(v1, 0) == 0)
            resp = 0;
        else if (Double.compare(v2, 0) == 0)
            resp = v1 / 0;
        else
            resp = v1 / v2;
        return resp;
    }

    public double potencia(double v1, double pot) {
        return Math.pow(v1, pot);
    }

    public double raiz(double v, double exp) {
        return Math.pow(v, exp);
    }

    public double porcent(double v1, double v2) {
        return (v1 / v2) * 100;
    }
}
