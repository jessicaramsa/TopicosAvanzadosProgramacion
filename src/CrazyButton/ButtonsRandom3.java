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

public class ButtonsRandom3 {
    JFrame ventana;
    JPanel area;
    JButton touch, salir, toca;
    JLabel title;
    int contA, contC, contT;
    Random rac;
    float r, g, b;
    Color c;

    public ButtonsRandom3() {
        ventana = new JFrame("Crazy Button");
        area = new JPanel();
        touch = new JButton("Touch " + contA);
        salir = new JButton("Salir " + contC);
        toca = new JButton("Toca " + contT);
        title = new JLabel();
        contA = 0;
        contC = 0;

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

        touch.setBounds(50, 200, 100, 40);
        touch.setBackground(Color.WHITE);
        salir.setBounds(50, 300, 100, 40);
        salir.setBackground(Color.WHITE);
        toca.setBounds(50, 350, 100, 40);
        toca.setBackground(Color.WHITE);

        title.setText("Presiona Touch, Salir o Toca ...");
        title.setBounds(0, 0, 400, 50);
        title.setFont(new Font("Monospaced", Font.BOLD, 18));
    }

    private void armar() {
        ventana.add(title, BorderLayout.NORTH);
        ventana.add(area, BorderLayout.CENTER);
        area.add(touch);
        area.add(salir);
        area.add(toca);
    }

    private void escuchas() {
        escMouse em = new escMouse();
        touch.addMouseListener(em);
        touch.addMouseMotionListener(em);
        salir.addMouseListener(em);
        salir.addMouseMotionListener(em);
        toca.addMouseMotionListener(em);
        toca.addMouseListener(em);
    }

    private void mostrar() {
        ventana.setVisible(true);
    }

    private class escMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (contA > 10 && contC > 10 && contT > 10) {
                touch.setLocation(100, 100);
                touch.setBackground(Color.DARK_GRAY);
                salir.setLocation(100, 150);
                salir.setBackground(Color.DARK_GRAY);
                toca.setLocation(100, 200);
                toca.setBackground(Color.DARK_GRAY);
                title.setText("P E R D I S T E...Intentos = " + contA + ", " + contC);
            } else if (e.getSource().equals(touch))
                contA++;
            else if (e.getSource().equals(salir))
                contC++;
            else if (e.getSource().equals(toca))
                contT++;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            int x, y;
            x = (int) (Math.random() * (400 - 100));
            y = (int) (Math.random() * (500 - 100));
            rac = new Random();
            r = rac.nextFloat();
            g = rac.nextFloat();
            b = rac.nextFloat();
            c = new Color(r, g, b);
            if (e.getSource().equals(touch)) {
                touch.setBounds(x, y, 100, 40);
                touch.setBackground(c);
            } else if (e.getSource().equals(salir)) {
                salir.setBounds(x, y, 100, 40);
                salir.setBackground(c);
            } else if (e.getSource().equals(toca)) {
                toca.setBounds(x, y, 100, 40);
                toca.setBackground(c);
            }
        }
    }

    public static void main(String[] args) {
        ButtonsRandom3 btTest = new ButtonsRandom3();
    }
}
