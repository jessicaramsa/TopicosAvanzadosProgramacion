package TableroColores;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TableroRandom {
    JFrame ventana;
    JPanel pTablero[][] = new JPanel[8][8];
    Random ra = new Random();

    public TableroRandom() {
        ventana = new JFrame("Tablero de ajedrez");

        for (int i = 0; i < pTablero.length; i++) {
            for (int j = 0; j < pTablero[i].length; j++) {
                pTablero[i][j] = new JPanel();
            }
        }

        atributos();
        armar();
        mostrar();
    }

    public void atributos() {
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(3);
        ventana.setLayout(new GridLayout(8, 8, 0, 0));
        ventana.setLocationRelativeTo(null);
    }

    public void armar() {
        for (int i = 0; i < pTablero.length; i++) {
            for (int j = 0; j < pTablero[i].length; j++) {
                float r = ra.nextFloat();
                float g = ra.nextFloat();
                float b = ra.nextFloat();
                Color c = new Color(r, g, b);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        pTablero[i][j].setBackground(c);
                        ventana.add(pTablero[i][j]);
                    } else {
                        pTablero[i][j].setBackground(c);
                        ventana.add(pTablero[i][j]);
                    }
                } else {
                    if (j % 2 == 0) {
                        pTablero[i][j].setBackground(c);
                        ventana.add(pTablero[i][j]);
                    } else {
                        pTablero[i][j].setBackground(c);
                        ventana.add(pTablero[i][j]);
                    }
                }
            }
        }
    }

    public void mostrar() {
        ventana.setVisible(true);
    }
}
