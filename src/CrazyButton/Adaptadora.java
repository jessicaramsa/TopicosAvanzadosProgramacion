package CrazyButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Adaptadora {
    JFrame ventana;
    JButton boton1, boton2;
    JLabel title;
    int ra;
    Random rac;
    float r, g, b;
    Color c;

    public Adaptadora() {
        ventana = new JFrame("Crazy Button");
        boton1 = new JButton("Aceptar");
        boton2 = new JButton("Cancelar");
        title = new JLabel();
        ra = (int) Math.random();
        rac = new Random();
        r = rac.nextFloat();
        g = rac.nextFloat();
        b = rac.nextFloat();
        c = new Color(r, g, b);

        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        ventana.setSize(400, 500);
        ventana.setLayout(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(3);
        ventana.setLocationRelativeTo(null);

        boton1.setSize(80, 40);
        boton1.setBounds(50, 200, 100, 40);
        boton1.setBackground(c);

        boton2.setSize(80, 40);
        boton2.setBounds(50, 300, 100, 40);
        boton2.setBackground(c);

        title.setText("Presiona Aceptar o Cancelar...");
        title.setBounds(0, 0, 400, 50);
        title.setFont(new Font("Monospaced", Font.BOLD, 18));
    }

    private void armar() {
        ventana.add(title);
        ventana.add(boton1);
        ventana.add(boton2);
    }

    private void move() {
        boton1.setSize(80, 40);
        boton1.setLocation(ra, ra + 80);
        boton1.setBackground(c);

        boton2.setSize(80, 40);
        boton2.setLocation(ra, ra + 80);
        boton2.setBackground(c);

        title.setText("Presiona Aceptar...");
    }

    private void escuchas() {
        escMouse em = new escMouse();
        boton1.addMouseListener(em);
        boton1.addMouseMotionListener(em);
        boton2.addMouseListener(em);
        boton2.addMouseMotionListener(em);
    }

    private void mostrar() {
        ventana.setVisible(true);
    }

    private class escMouse extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            int x, y;
            x = (int) (Math.random() * (400 - 80));
            y = (int) (Math.random() * (500 - 80));
            if (e.getSource().equals(boton1))
                boton1.setBounds(x, y, 80, 40);
            else
                boton2.setBounds(x, y, 80, 40);
        }
    }

    public static void main(String[] args) {
        Adaptadora atest = new Adaptadora();
    }
}
