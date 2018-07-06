package MouseListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMouse {
    JFrame window;
    JLabel etA, etB;
    JPanel centro;

    public VentanaMouse() {
        window = new JFrame("Prueba MouseListener 1");
        etA = new JLabel("");
        etB = new JLabel("");
        centro = new JPanel();

        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        window.setSize(500, 500);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());

        centro.setVisible(true);
        etA.setText("Escucha de Mouse");
    }

    private void armar() {
        window.add(etA, BorderLayout.NORTH);
        window.add(centro, BorderLayout.CENTER);
        window.add(etB, BorderLayout.SOUTH);
    }

    private void escuchas() {
        centro.addMouseListener(new EscMouse());
        centro.addMouseMotionListener(new EscMouse());
    }

    private void mostrar() {
        window.setVisible(true);
    }

    private class EscMouse implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            etB.setText("¡Ay¡");
            centro.setBackground(Color.black);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            etB.setText("Presionaste un botón.");
            centro.setBackground(Color.green);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            etB.setText("Entraste al lado obscuro.");
            centro.setBackground(Color.cyan);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            etB.setText("¿¡Por qué te vas!?");
            centro.setBackground(Color.gray);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            etB.setText("Clic izquierdo y arrastra.");
            centro.setBackground(Color.orange);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            etB.setText("¡Se mueve D:! X = " + e.getX() + " Y = " + e.getY());
        }
    }
}
