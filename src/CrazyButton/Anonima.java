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

public class Anonima {
    JFrame ventana;
    JPanel area;
    JButton boton1, boton2;
    JLabel title;
    int ra;
    Random rac;
    float r, g, b;
    Color c;

    public Anonima() {
        ventana = new JFrame("Crazy Button");
        area = new JPanel();
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
        ventana.setLayout(new BorderLayout());
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(3);
        ventana.setLocationRelativeTo(null);

        boton1.setBounds(50, 200, 80, 40);
        boton1.setBackground(c);

        boton2.setBounds(50, 350, 80, 40);
        boton2.setBackground(c);

        title.setText("Presiona Aceptar o Cancelar ...");
        title.setBounds(0, 0, 400, 50);
        title.setFont(new Font("Monospaced", Font.BOLD, 18));
    }

    private void armar() {
        ventana.add(title, BorderLayout.NORTH);
        ventana.add(area, BorderLayout.CENTER);
        area.add(boton1);
        area.add(boton2);
    }

    private void escuchas() {
        MouseAdapter ma;
        boton1.addMouseListener(
                ma = new MouseAdapter() {
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
        });
        boton2.addMouseListener(ma);
    }

    private void mostrar() {
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        Anonima atest = new Anonima();
    }
}
