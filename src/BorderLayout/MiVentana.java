package BorderLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class MiVentana {
    JFrame ventana;
    JButton botNorte, botSur, botEste, botOeste, botCentro;
    JPanel panNorte, panSur, panEste, panOeste, panCentro;
    BorderLayout bl;

    public MiVentana() {
        bl = new BorderLayout();
        ventana = new JFrame("Feria de León");

        botNorte = new JButton("Norte");
        botSur = new JButton("Sur");
        botEste = new JButton("Este");
        botOeste = new JButton("Oeste");
        botCentro = new JButton("Centro");

        panNorte = new JPanel();
        panSur = new JPanel();
        panEste = new JPanel();
        panOeste = new JPanel();
        panCentro = new JPanel();

        atributos();
        armar();
        mostrar();
    }

    public void atributos() {
        ventana.setSize(500, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(bl);
        ventana.setLocationRelativeTo(null);

        panNorte.setBackground(Color.red);
        panSur.setBackground(Color.blue);
        panEste.setBackground(Color.pink);
        panOeste.setBackground(Color.yellow);
        panCentro.setBackground(Color.green);

        bl.setHgap(10);
        bl.setVgap(10);
    }

    public void armar() {
        ventana.add(panNorte, BorderLayout.NORTH);
        ventana.add(panSur, BorderLayout.SOUTH);
        ventana.add(panEste, BorderLayout.EAST);
        ventana.add(panOeste, BorderLayout.WEST);
        ventana.add(panCentro, BorderLayout.CENTER);

        panNorte.add(botNorte);
        panSur.add(botSur);
        panEste.add(botEste);
        panOeste.add(botOeste);
        panCentro.add(botCentro);
    }

    public void mostrar() {
        ventana.setVisible(true);
    }
}
