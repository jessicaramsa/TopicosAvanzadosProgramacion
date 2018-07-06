package Calculadora;

import java.util.ArrayList;
import java.util.Vector;

public class NPostfija {
    private Vector<String> rpn;
    private ArrayList<String> cadena;

    public NPostfija(ArrayList<String> cadenaInfija) {
        cadena = cadenaInfija;
        rpn = new Vector();
        postFijo();
    }

    private void postFijo() {
        Pila pila = new Pila(cadena.size());
        int cont = 0, simp;
        while(cont < cadena.size()) {
            String s = cadena.get(cont);
            simp = jerarquia(s);
            if(simp == 0)
                rpn.add(s);
            else {
                while(pila.isEmpty() == false && orden(pila.cima(), s) && simp > 0)
                    rpn.add(pila.pop());
                if(simp == -2) {
                    while(jerarquia(pila.cima()) != -1)
                        rpn.add(pila.pop());
                    pila.pop();
                } else
                    pila.push(s);
            }
            cont++;
        }
        while(pila.isEmpty() == false)
            rpn.add(pila.pop());
    }

    public String get(int index) {
        return rpn.get(index);
    }

    public int Size() {
        return rpn.size();
    }

    public boolean orden(String cadPila, String cad) {
        int p1 = jerarquia(cadPila);
        int p2 = jerarquia(cad);
        return p1 >= p2;
    }

    private int jerarquia(String cad) {
        int i = 0;
        switch(cad) {
            case "-": i = 1; break;
            case "+": i = 1; break;
            case "*": i = 2; break;
            case "/": i = 2; break;
            case "^": i = 3; break;
            case "√": i = 3; break;
            case "(": i = -1; break;
            case ")": i = -2; break;
            case "%": i = 2; break;
            default: break;
        }
        return i;
    }

    public double getValor() {
        Pila pila = new Pila(cadena.size());
        String s, valor;
        double op1, op2;
        int i, simbol;
        for(i = 0; i < rpn.size(); i++) {
            s = rpn.get(i);
            simbol = jerarquia(s);
            if(jerarquia(s) == 0)
                pila.push(s);
            else {
                op2 = Double.valueOf(pila.pop());
                op1 = Double.valueOf(pila.pop());
                valor = operaracion(s, op1, op2);
                pila.push(valor);
            }
        }
        return Float.valueOf(pila.pop());
    }

    private static String operaracion(String cad, double op1, double op2) {
        double valor = 0;
        Operandos op = new Operandos();
        switch(cad) {
            case "+": valor = op.suma(op1, op2); break;
            case "-": valor = op.resta(op1, op2); break;
            case "*": valor = op.multiplicar(op1, op2); break;
            case "/": valor = op.dividir(op1, op2); break;
            case "^": valor = op.potencia(op1, op2); break;
            case "√": valor = op.raiz(op2, 1 / op1); break;
            case "%": valor = op.porcent(op1, op2); break;
            default: break;
        }
        return String.valueOf(valor);
    }
}
