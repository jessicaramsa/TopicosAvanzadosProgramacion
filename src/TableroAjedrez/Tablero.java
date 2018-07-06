package TableroAjedrez;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablero {
    JFrame ventana;
    JPanel pTablero[][] = new JPanel[8][8];

    public Tablero() {
        ventana = new JFrame("Tablero de ajedrez");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
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
        ventana.setResizable(false);
        ventana.setLayout(new GridLayout(8, 8, 0, 0));
        ventana.setLocationRelativeTo(null);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        pTablero[i][j].setBackground(Color.white);
                    else
                        pTablero[i][j].setBackground(Color.black);
                } else {
                    if (j % 2 == 0)
                        pTablero[i][j].setBackground(Color.black);
                    else
                        pTablero[i][j].setBackground(Color.white);
                }
            }
        }
    }

    public void armar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ventana.add(pTablero[i][j]);
            }
        }
    }

    public void mostrar() {
        ventana.setVisible(true);
    }
}
