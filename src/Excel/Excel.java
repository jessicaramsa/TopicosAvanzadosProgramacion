package Excel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class Excel {
    char letra = 'A';
    private static final String img = "src/Excel/";
    JFrame window;
    JButton esp[] = new JButton[12];
    JButton fila[] = new JButton[12];
    JButton blanco;
    ImageIcon imagen;
    JToggleButton bt1, bt2, bt3;
    GridBagConstraints gridb = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    public Excel() {
        window = new JFrame("Muestra GridBagLayout");

        for (int i = 0; i < esp.length; i++) {
            esp[i] = new JButton("" + (char) (letra + (i - 1)));
            fila[i] = new JButton("" + i);
        }

        blanco = new JButton();
        imagen = new ImageIcon(img + "image.jpg");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
        bt1 = new JToggleButton("Toggle 1");
        bt2 = new JToggleButton("Toggle 2");
        bt3 = new JToggleButton("Toggle 3");

        atributos();
        armar();
        mostrar();
    }

    public void atributos() {
        window.setSize(500, 500);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(gb);

        for (int i = 0; i < esp.length; i++) {
            esp[i].setVisible(true);
            esp[i].setFont(new Font("Serif", Font.ITALIC, 10));
            fila[i].setVisible(true);
            fila[i].setFont(new Font("Serif", Font.ITALIC, 10));
        }

        blanco.setVisible(true);
        blanco.setBackground(Color.green);
        blanco.setIcon(imagen);

        gridb.insets = new Insets(4, 4, 4, 4);
    }

    public void armar() {
        gridb.gridx = 0;
        gridb.gridy = 0;
        gridb.gridwidth = 1;
        window.add(blanco, gridb);

        for (int i = 1; i < 12; i++) {
            gridb.gridx = i;
            gridb.gridy = 0;
            gridb.gridwidth = 1;
            window.add(esp[i], gridb);

            gridb.gridx = 0;
            gridb.gridy = i;
            window.add(fila[i], gridb);
        }
    }

    public void mostrar() {
        window.pack();
        window.setVisible(true);
    }

    private ImageIcon escalarImagen(String archivo) {
        Image i = new ImageIcon(archivo).getImage();
        ImageIcon ir;
        ir = new ImageIcon(i.getScaledInstance(499, 450, Image.SCALE_SMOOTH));
        return ir;
    }

    public static void main(String[] args) {
        Excel tv2 = new Excel();
    }
}
