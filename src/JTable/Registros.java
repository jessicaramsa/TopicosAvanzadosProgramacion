package JTable;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Registros {
    JFrame window;
    JTable tabla;
    JScrollPane scroll;
    JMenuBar menu;
    JMenu mArch, mVer, mAyuda, maAbrir, mayAW;
    JMenuItem item[] = new JMenuItem[14];
    String tIt[] = {"Alumos", "Docentes", "Amigos", "Guardar", "Actualizar",
        "Salir", "Todo", "No Control", "No Control y Nombre", "Total",
        "Facebook", "YouTube", "www.www", "Acerca de"};
    String datos[][] = {{"María", "Enchiladas rojas", "maria@gmail.com", "21"},
    {"Miguel", "Pescado a la plancha", "mike_09@gmail.com", "27"},
    {"Pedro", "Caldo de pollo", "pedrito@gmail.com", "20"},
    {"Martha", "Lasagna", "martha00@gmail.com", "45"},
    {"Joanna", "Torrejas", "oaj@gmail.com", "20"},
    {"Roberto", "Filete de pescado", "rob_to@gmail.com", "18"},
    {"Hugo", "Ensalada de frutas", "hg_uo@gmail.com", "25"},
    {"Virginia", "Tamales", "vr_gn@gmail.com", "30"},
    {"Luis", "Sopa", "ilus@gmail.com", "20"},
    {"Horacio", "Hamburguesa", "meti_cio@gmail.com", "37"}};
    String encabezado[] = {"Nombre", "Comida Preferida", "e-mail", "Edad"};

    public Registros() {
        window = new JFrame("Registros");
        tabla = new JTable(datos, encabezado);
        scroll = new JScrollPane(tabla);
        menu = new JMenuBar();
        mArch = new JMenu("Archivo");
        mVer = new JMenu("Ver");
        mAyuda = new JMenu("Ayuda");
        maAbrir = new JMenu("Abrir");
        mayAW = new JMenu("Ayuda Web");
        for (int i = 0; i < item.length; i++) {
            item[i] = new JMenuItem(tIt[i]);
        }

        atributos();
        armar();
        mostrar();
    }

    private void atributos() {
        window.setDefaultCloseOperation(3);
        window.setSize(700, 200);
        window.setLocationRelativeTo(null);

        tabla.setSelectionBackground(Color.CYAN);
        tabla.setGridColor(Color.RED);
    }

    private void armar() {
        mArch.add(maAbrir);
        mAyuda.add(mayAW);
        for (int i = 0; i < tIt.length; i++) {
            if (i < 3) {
                maAbrir.add(tIt[i]);
            } else if (i == 3 || i < 6) {
                mArch.add(tIt[i]);
            } else if (i == 6 || i < 10) {
                mVer.add(tIt[i]);
            } else if (i == 10 || i < 13) {
                mayAW.add(tIt[i]);
            } else if (i == 13) {
                mAyuda.add(tIt[i]);
            }
        }

        menu.add(mArch);
        menu.add(mVer);
        menu.add(mAyuda);
        window.add(scroll);
        window.setJMenuBar(menu);
    }

    private void mostrar() {
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Registros testR = new Registros();
    }
}
