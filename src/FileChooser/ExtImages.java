package FileChooser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExtImages {
    String url, nomExt[] = {"jpg", "bmp", "gif", "tift", "png", "jpeg"};
    JFrame window, fFch;
    JFileChooser fch;
    JCheckBox extCB[] = new JCheckBox[nomExt.length];
    JButton mostrar, salir;
    ImageIcon imagen;
    JLabel img;
    FileFilter ff;
    ArrayList<String> nExt;

    public ExtImages() {
        window = new JFrame("Filtrar tipos de imagenes");
        fFch = new JFrame();
        fch = new JFileChooser();
        for (int i = 0; i < nomExt.length; i++)
            extCB[i] = new JCheckBox(nomExt[i]);
        mostrar = new JButton("Mostrar");
        salir = new JButton("Salir");
        imagen = new ImageIcon();
        img = new JLabel();
        url = "src/FileChooser/Imgs/";
        nExt = new ArrayList();

        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        window.setSize(630, 590);
        window.setDefaultCloseOperation(3);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        img.setBounds(10, 10, 480, 480);
        img.setOpaque(false);
        img.setBackground(Color.LIGHT_GRAY);

        mostrar.setBounds(500, 10, 100, 30);
        extCB[0].setBounds(500, 50, 100, 30);
        extCB[1].setBounds(500, 90, 100, 30);
        extCB[2].setBounds(500, 130, 100, 30);
        extCB[3].setBounds(500, 170, 100, 30);
        extCB[4].setBounds(500, 210, 100, 30);
        extCB[5].setBounds(500, 250, 100, 30);
        salir.setBounds(500, 500, 100, 30);
    }

    private void armar() {
        for (JCheckBox extCB1 : extCB) window.add(extCB1);
        window.add(mostrar);
        window.add(salir);
        window.add(img);
    }

    private void escuchas() {
        escB eB = new escB();
        mostrar.addActionListener(eB);
        salir.addActionListener(eB);
    }

    private void mostrar() {
        window.setVisible(true);
    }

    private class escB implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(mostrar)) {
                selectExt();
                String nTemp[] = new String[nExt.size()];
                for(int i = 0; i < nExt.size(); i++)
                    nTemp[i] = nExt.get(i);
                
                ff = new FileNameExtensionFilter("Images", nTemp);
                fch.setCurrentDirectory(new File(url));
                fch.setFileFilter(ff);
                int n = fch.showOpenDialog(fFch);
                
                if(n == JFileChooser.APPROVE_OPTION) {
                    String dir = fch.getName(fch.getSelectedFile());
                    imagen = new ImageIcon(url + dir);
                    imagen = new ImageIcon(imagen.getImage().
                            getScaledInstance(480, 480, 16));
                    img.setIcon(new ImageIcon(url + dir));
                    nExt.clear();
                }
            } else if(e.getSource().equals(salir))
                System.exit(0);
        }
    }

    public void selectExt() {
        for (int i = 0; i < extCB.length; i++) {
            if(extCB[i].isSelected())
                nExt.add(nomExt[i]);
        }
        if(nExt.isEmpty())
            nExt.addAll(Arrays.asList(nomExt));
    }
}
