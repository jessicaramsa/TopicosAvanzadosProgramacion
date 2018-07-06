package Excel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class ExcelToggle {
    char letra = 'A';
    JFrame window;
    JButton letras[] = new JButton[7];
    JButton num[] = new JButton[7];
    JButton blanco;
    JToggleButton bt1, bt2, bt3;
    GridBagConstraints gridb = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    public ExcelToggle() {
        window = new JFrame("Muestra GridBagLayout");

        for (int i = 0; i < 7; i++) {
            letras[i] = new JButton("" + (char) (letra + i));
            num[i] = new JButton("" + (i + 1));
        }

        blanco = new JButton();
        bt1 = new JToggleButton("Toggle 1");
        bt2 = new JToggleButton("Toggle 2");
        bt3 = new JToggleButton("Toggle 3");

        atributos();
        armar();
        mostrar();
    }

    private void atributos() {
        window.setSize(500, 500);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(gb);

        for (int i = 0; i < 7; i++) {
            letras[i].setVisible(true);
            letras[i].setBackground(Color.BLUE);
            num[i].setVisible(true);
            num[i].setBackground(Color.GREEN);
        }

        blanco.setVisible(true);
        blanco.setBackground(Color.gray);

        bt1.setVisible(true);
        bt1.setBackground(Color.red);
        bt2.setVisible(true);
        bt2.setBackground(Color.blue);
        bt3.setVisible(true);
        bt3.setBackground(Color.green);

        gridb.insets = new Insets(0, 0, 0, 0);
    }

    private void armar() {
        gridb.gridx = 1;
        gridb.gridy = 1;
        gridb.gridwidth = 1;
        gridb.fill = GridBagConstraints.BOTH;
        window.add(blanco, gridb);

        for (int i = 1; i < 7; i++) {
            gridb.gridx = i + 1;
            gridb.gridy = 1;
            gridb.gridwidth = 1;
            window.add(letras[i - 1], gridb);

            gridb.gridx = 1;
            gridb.gridy = i + 1;
            window.add(num[i - 1], gridb);
        }

        gridb.gridx = 2;
        gridb.gridy = 2;
        gridb.gridwidth = 3;
        gridb.fill = GridBagConstraints.HORIZONTAL;
        window.add(bt1, gridb);

        gridb.gridx = 4;
        gridb.gridy = 4;
        gridb.gridheight = 3;
        gridb.gridwidth = 1;
        gridb.fill = GridBagConstraints.VERTICAL;
        window.add(bt2, gridb);

        gridb.gridx = 6;
        gridb.gridy = 6;
        gridb.gridwidth = 2;
        gridb.fill = GridBagConstraints.BOTH;
        window.add(bt3, gridb);
    }

    private void mostrar() {
        window.pack();
        window.setVisible(true);
    }
}
