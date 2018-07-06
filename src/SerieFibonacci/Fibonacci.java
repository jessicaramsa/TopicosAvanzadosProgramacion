package SerieFibonacci;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Fibonacci {
    JFrame window;
    JTextField numeros, grado;
    JLabel nSeries, nGrado, tiempoTotal, msg;
    JTable resul;
    String encabezado[] = {"#","Número","Tiempo inicio","Tiempo final",
        "Tiempo ejec"};
    String datos[][] = {};
    JScrollPane scroll;
    JButton iniciar, limpiar, salir;
    DefaultTableModel dtm;
    LogicaFibonacci lf = new LogicaFibonacci();

    public Fibonacci() {
        window = new JFrame("Serie de Fibonacci");
        numeros = new JTextField();
        grado = new JTextField();
        nSeries = new JLabel("Números de la Serie");
        nGrado = new JLabel("Grado de la serie = 2");
        tiempoTotal = new JLabel("Tiempo Total de ejecución: ");
        resul = new JTable(datos, encabezado);
        scroll = new JScrollPane(resul);
        iniciar = new JButton("Iniciar");
        limpiar = new JButton("Limpiar");
        salir = new JButton("Salir");
        msg = new JLabel();
        dtm = new DefaultTableModel();
        
        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        window.setSize(700, 520);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setLayout(null);

        resul.setModel(dtm);
        nSeries.setBounds(20, 20, 130, 40);
        numeros.setBounds(160, 20, 50, 40);
        nGrado.setBounds(230, 20, 130, 40);
        grado.setBounds(370, 20, 50, 40);
        grado.setVisible(false);
        iniciar.setBounds(450, 20, 130, 40);
        scroll.setBounds(20, 80, 660, 300);
        limpiar.setBounds(20, 400, 100, 40);
        salir.setBounds(580, 400, 100, 40);
        msg.setBounds(20, 460, 660, 40);
        msg.setForeground(Color.RED);
        msg.setFont(new Font("Serif", Font.BOLD, 18));
    }

    private void armar() {
        window.add(nSeries);
        window.add(numeros);
        window.add(nGrado);
        window.add(grado);
        window.add(scroll);
        window.add(iniciar);
        window.add(limpiar);
        window.add(salir);
        window.add(msg);
    }

    private void escuchas() {
        escBotones eB = new escBotones();
        iniciar.addActionListener(eB);
        limpiar.addActionListener(eB);
        salir.addActionListener(eB);
    }

    private void mostrar() {
        window.setVisible(true);
    }

    private class escBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(iniciar)) {
                String n = numeros.getText(), g = grado.getText();
                if(isNum(n) == true) {
                    datos = lf.solve(Integer.parseInt(n));
                    resul = new JTable(datos, encabezado);
                    dtm.setDataVector(datos, encabezado);
                }
            } else if(e.getSource().equals(limpiar)) {
                numeros.setText("");
                grado.setText("");
                for (String[] dato : datos) {
                    for (int j = 0; j < dato.length; j++)
                        dato[j] = "";
                }
                resul = new JTable(datos, encabezado);
                dtm.setDataVector(datos, encabezado);
            } else if(e.getSource().equals(salir)) System.exit(0);
        }
    }

    private boolean isNum(String c) {
        try {
            Integer.parseInt(c);
            return true;
        } catch(NumberFormatException e) {
            System.out.println(e);
            return false;
        }
    }

    private boolean isGrade(String c) {
        if(Integer.parseInt(c) == 2 || Integer.parseInt(c)>2)
            return true;
        else {
            msg.setText("El grado de la serie debe ser mayor o igual a 2");
            return false;
        }
    }
}
