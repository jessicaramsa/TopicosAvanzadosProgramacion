package JuegoGato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gato {
    JFrame ventana;
    JPanel casillas;
    JButton casBot[][] = new JButton[3][3];
    JPanel espBot;
    JLabel title;
    JButton jugar, salir;
    Random rac;
    float r, g, b;
    Color c;

    public Gato() {
        ventana = new JFrame("Juego del gato");
        espBot = new JPanel();
        title = new JLabel("GATO", JLabel.CENTER);
        jugar = new JButton("Jugar");
        salir = new JButton("Salir");
        casillas = new JPanel();
        rac = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                casBot[i][j] = new JButton((i + 1) + ", " + (j + 1));
        }

        atributos();
        armar();
        mostrar();
    }

    private void atributos() {
        ventana.setSize(500, 700);
        ventana.setDefaultCloseOperation(3);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        casillas.setLayout(new GridLayout(3, 3, 5, 5));
        title.setFont(new Font("Serif", Font.ITALIC, 25));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casBot[i][j].setBackground(c);
                r = rac.nextFloat();
                g = rac.nextFloat();
                b = rac.nextFloat();
                c = new Color(r, g, b);
            }
        }

        jugar.setBounds(0, 720, 80, 200);
        salir.setBounds(200, 720, 80, 200);
    }

    private void armar() {
        ventana.add(title, BorderLayout.NORTH);
        ventana.add(casillas, BorderLayout.CENTER);
        ventana.add(espBot, BorderLayout.SOUTH);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                casillas.add(casBot[i][j]);
        }

        espBot.add(jugar);
        espBot.add(salir);
    }

    private void mostrar() {
        ventana.setVisible(true);
    }
}
