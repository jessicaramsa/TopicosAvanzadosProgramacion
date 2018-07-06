/* 0. Foreground Color
   1. Background Color
   2. R FC
   3. G FC
   4. B FC
   5. R BC
   6. G BC
   7. B BC
 */
package CambioColores;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Colores {
    private JFrame window;
    private JLabel texto, nota;
    private JLabel titles[] = new JLabel[8];
    private JList listas[] = new JList[8];
    private JScrollPane scroll[] = new JScrollPane[8];
    private int r, g, b;
    private int numC[] = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90,
        95, 100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180,
        185, 190, 195, 200, 205, 210, 215, 220, 225, 230, 235, 240, 245, 250, 255};
    private String tT[] = {"Foreground Color", "Background Color", "R", "G", "B", "R",
        "G", "B"};
    DefaultListModel nC = new DefaultListModel();

    public Colores() {
        window = new JFrame("Cambia los colores del texto");
        texto = new JLabel("Texto de prueba", SwingConstants.CENTER);
        nota = new JLabel("");
        r = 0;
        g = 0;
        b = 0;
        for (int i = 0; i < numC.length; i++) {
            nC.addElement(numC[i]);
        }
        for (int i = 0; i < 8; i++) {
            if (i < 2) {
                listas[i] = new JList(nColores.values());
            } else {
                listas[i] = new JList(nC);
            }
            titles[i] = new JLabel(tT[i], SwingConstants.CENTER);
            scroll[i] = new JScrollPane(listas[i]);
        }
        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        window.setDefaultCloseOperation(3);
        window.setSize(700, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        texto.setFont(new Font("Monospaced", Font.BOLD, 25));
        texto.setBounds(0, 0, 700, 60);
        texto.setOpaque(true);

        for (int i = 0; i < listas.length; i++) {
            listas[i].setSelectedIndex(0);
            listas[i].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

        titles[0].setBounds(50, 90, 250, 70);
        titles[1].setBounds(400, 90, 250, 100);
        scroll[0].setBounds(50, 180, 250, 100);
        scroll[1].setBounds(400, 180, 250, 100);
        titles[2].setBounds(105, 300, 20, 20);
        titles[3].setBounds(165, 300, 20, 20);
        titles[4].setBounds(225, 300, 20, 20);
        titles[5].setBounds(455, 300, 20, 20);
        titles[6].setBounds(515, 300, 20, 20);
        titles[7].setBounds(575, 300, 20, 20);
        scroll[2].setBounds(100, 350, 50, 80);
        scroll[3].setBounds(160, 350, 50, 80);
        scroll[4].setBounds(220, 350, 50, 80);
        scroll[5].setBounds(450, 350, 50, 80);
        scroll[6].setBounds(510, 350, 50, 80);
        scroll[7].setBounds(570, 350, 50, 80);
    }

    private void armar() {
        window.add(texto);
        window.add(titles[0]);
        window.add(titles[1]);
        window.add(scroll[0]);
        window.add(scroll[1]);
        window.add(titles[2]);
        window.add(titles[3]);
        window.add(titles[4]);
        window.add(titles[5]);
        window.add(titles[6]);
        window.add(titles[7]);
        window.add(scroll[2]);
        window.add(scroll[3]);
        window.add(scroll[4]);
        window.add(scroll[5]);
        window.add(scroll[6]);
        window.add(scroll[7]);
        window.add(nota);
    }

    private void escuchas() {
        escListC eLC = new escListC();
        escListRGB eLRGB = new escListRGB();
        for (int i = 0; i < 2; i++) {
            if (i < 2)
                listas[i].addListSelectionListener(eLC);
            else
                listas[i].addListSelectionListener(eLRGB);
        }
    }

    private void mostrar() {
        window.setVisible(true);
    }

    private class escListC implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selected;
            nColores s;
            Color c;
            if (e.getSource() == listas[0]) {
                s = (nColores) listas[0].getSelectedValue();
                c = new Color(s.getR(), s.getG(), s.getB());
                texto.setForeground(c);
            } else if (e.getSource() == listas[1]) {
                s = (nColores) listas[1].getSelectedValue();
                c = new Color(s.getR(), s.getG(), s.getB());
                texto.setBackground(c);
            }
        }
    }

    private class escListRGB implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getSource() == listas[2]) {
                r = (int) listas[2].getSelectedValue();
                texto.setForeground(new Color(r, g, b));
            } else if (e.getSource() == listas[3]) {
                g = (int) listas[3].getSelectedValue();
                texto.setForeground(new Color(r, g, b));
            } else if (e.getSource() == listas[4]) {
                b = (int) listas[4].getSelectedValue();
                texto.setForeground(new Color(r, g, b));
            } else if (e.getSource() == listas[5]) {
                r = (int) listas[5].getSelectedValue();
                texto.setBackground(new Color(r, g, b));
            } else if (e.getSource() == listas[6]) {
                g = (int) listas[6].getSelectedValue();
                texto.setBackground(new Color(r, g, b));
            } else if (e.getSource() == listas[7]) {
                b = (int) listas[7].getSelectedValue();
                texto.setBackground(new Color(r, g, b));
            }
        }
    }

    public static void main(String[] args) {
        Colores testC = new Colores();
    }
}
