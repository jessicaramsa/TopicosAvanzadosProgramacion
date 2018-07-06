package CrazyButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonRandom {
    JFrame ventana;
    JPanel area;
    JButton boton;
    JLabel title;
    int cont;
    Random rac;
    float r, g, b;
    Color c;

    public ButtonRandom() {
        ventana = new JFrame("Crazy Button");
        area = new JPanel();
        boton = new JButton("Aceptar");
        title = new JLabel();
        cont = 0;

        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        ventana.setSize(400, 500);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(3);
        ventana.setLocationRelativeTo(null);

        area.setLayout(null);
        area.setBackground(Color.CYAN);

        boton.setBounds(50, 200, 80, 40);
        boton.setBackground(c);

        title.setText("Presiona Aceptar... Intentos = " + cont);
        title.setBounds(0, 0, 400, 50);
        title.setFont(new Font("Monospaced", Font.BOLD, 18));
    }

    private void armar() {
        ventana.add(title, BorderLayout.NORTH);
        ventana.add(area, BorderLayout.CENTER);
        area.add(boton);
    }

    private void escuchas() {
        escMouse em = new escMouse();
        boton.addMouseListener(em);
        boton.addMouseMotionListener(em);
    }

    private void mostrar() {
        ventana.setVisible(true);
    }

    private class escMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (cont < 10)
                cont++;
            else {
                boton.setLocation(100, 100);
                boton.setBackground(Color.DARK_GRAY);
                title.setText("P E R D I S T E... Intentos = " + cont);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            int x, y;
            x = (int) (Math.random() * (400 - 80));
            y = (int) (Math.random() * (500 - 80));
            boton.setBounds(x, y, 80, 40);
            rac = new Random();
            r = rac.nextFloat();
            g = rac.nextFloat();
            b = rac.nextFloat();
            c = new Color(r, g, b);
            boton.setBackground(c);
            title.setText("Presiona Aceptar... Intentos = " + cont);
        }
    }

    public static void main(String[] args) {
        ButtonRandom btTest = new ButtonRandom();
    }
}
