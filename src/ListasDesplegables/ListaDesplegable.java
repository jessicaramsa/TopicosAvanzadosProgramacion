package ListasDesplegables;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListaDesplegable {
    JFrame ventana;
    JPanel area;
    JTextField recuadro;
    private JList lista;
    private JScrollPane scroll;
    private String[] datos = {"Puerto Vallarta", "Veracruz", "Cancún", "Mazatlán",
        "Punta de Mita", "Ixtapa", "Huatulco", "Splash", "Metropolitano",
        "TI - Puerto Vallarta"};

    public ListaDesplegable() {
        ventana = new JFrame("Calculadora: Modo Básico.");
        area = new JPanel();
        recuadro = new JTextField("");
        lista = new JList(datos);
        scroll = new JScrollPane(lista);

        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        ventana.setSize(600, 500);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(3);

        area.setBackground(Color.GRAY);
        recuadro.setEditable(false);
        recuadro.setBackground(Color.CYAN);

        lista.setSelectedIndex(0);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void armar() {
        ventana.add(recuadro, BorderLayout.NORTH);
        ventana.add(area, BorderLayout.CENTER);
        area.add(scroll);
    }

    private void escuchas() {
        lista.addListSelectionListener(new escLista());
    }

    private void mostrar() {
        ventana.setVisible(true);
    }

    private class escLista implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String salida = "";
            int i[] = lista.getSelectedIndices();
            for (int j : i)
                salida += j + " ,";
            System.out.println("Selección : " + lista.getSelectedValuesList());
            System.out.println("Índices : [" + salida + "]");
        }
    }

    public static void main(String[] args) {
        ListaDesplegable bmTest = new ListaDesplegable();
    }
}
