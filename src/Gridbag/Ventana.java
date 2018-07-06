package Gridbag;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana {
    JFrame window;
    JPanel panel;
    JButton uno, dos, tres, cuatro, cinco;

    public Ventana() {
        window = new JFrame("Muestra GridbagLayout");
        panel = new JPanel();
        uno = new JButton("Uno");
        dos = new JButton("Dos");
        tres = new JButton("Tres");
        cuatro = new JButton("Cuatro");
        cinco = new JButton("Cinco");

        atributos();
        armar();
        mostrar();
    }

    public void atributos() {
        window.setSize(500, 500);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(new FlowLayout());

        panel.setBackground(Color.cyan);

        uno.setBackground(Color.green);
        dos.setBackground(Color.red);
        tres.setBackground(Color.yellow);
        cuatro.setBackground(Color.blue);
        cinco.setBackground(Color.magenta);
    }

    public void armar() {
        window.add(uno);
        window.add(dos);
        window.add(tres);
        window.add(cuatro);
        window.add(cinco);
    }

    public void mostrar() {
        window.setVisible(true);
        window.pack();
    }
}
