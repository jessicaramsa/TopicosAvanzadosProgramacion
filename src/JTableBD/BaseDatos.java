package JTableBD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class BaseDatos {
    JFrame window;
    JTable table;
    JScrollPane scrollT;
    JMenuBar menu;
    JMenu mArch, mVer, mAyuda, maAbrir, mayAW;
    JMenuItem item[] = new JMenuItem[14];
    String tIt[] = {"Alumnos", "Docentes", "Amigos", "Guardar", "Actualizar",
        "Salir", "Todo", "No Control", "No Control y Nombre", "Total",
        "Facebook", "YouTube", "www.www", "Acerca de"};
    String datos[][];
    String encabezado[];
    JTextField campos[] = new JTextField[4];
    JLabel nuevoR, message;
    JLabel registro[] = new JLabel[4];
    JButton ingresar, actualizar;
    ConexionMySQL mysql = new ConexionMySQL();

    public BaseDatos() throws SQLException, ClassNotFoundException {
        window = new JFrame("Registro de alumnos");
        encabezado = mysql.obtColumName();
        datos = mysql.instruction("SELECT * FROM escuela.alumnocomida;");
        table = new JTable(datos, encabezado);
        scrollT = new JScrollPane(table);
        menu = new JMenuBar();
        mArch = new JMenu("Archivo");
        mVer = new JMenu("Ver");
        mAyuda = new JMenu("Ayuda");
        maAbrir = new JMenu("Abrir");
        mayAW = new JMenu("Ayuda Web");
        for (int i = 0; i < item.length; i++)
            item[i] = new JMenuItem(tIt[i]);
        nuevoR = new JLabel("Ingresar nuevo registro");
        message = new JLabel(". . . . .", SwingConstants.CENTER);
        ingresar = new JButton("Ingresar");
        actualizar = new JButton("Actualizar");
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField();
            registro[i] = new JLabel(encabezado[i]);
        }

        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        window.setSize(650, 540);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(3);
        window.setBackground(Color.WHITE);
        window.setResizable(false);

        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setGridColor(Color.BLACK);
        table.setRowHeight(15);
        scrollT.setBounds(0, 0, 650, 200);

        nuevoR.setBounds(0, 250, 700, 30);
        nuevoR.setFont(new Font("Serif", Font.ITALIC, 20));
        message.setBounds(150, 480, 350, 30);
        message.setFont(new Font("Serif", Font.ITALIC, 15));

        registro[0].setBounds(30, 300, 120, 40);
        registro[1].setBounds(170, 300, 140, 40);
        registro[2].setBounds(340, 300, 150, 40);
        registro[3].setBounds(510, 300, 120, 40);

        campos[0].setBounds(20, 360, 120, 40);
        campos[1].setBounds(160, 360, 140, 40);
        campos[2].setBounds(320, 360, 150, 40);
        campos[3].setBounds(490, 360, 120, 40);

        ingresar.setBounds(200, 420, 100, 40);
        actualizar.setBounds(400, 420, 100, 40);
    }

    private void armar() {
        mArch.add(maAbrir);
        mAyuda.add(mayAW);
        for (int i = 0; i < tIt.length; i++) {
            if (i < 3)
                maAbrir.add(tIt[i]);
            else if (i == 3 || i < 6)
                mArch.add(tIt[i]);
            else if (i == 6 || i < 10)
                mVer.add(tIt[i]);
            else if (i == 10 || i < 13)
                mayAW.add(tIt[i]);
            else if (i == 13)
                mAyuda.add(tIt[i]);
        }
        
        menu.add(mArch);
        menu.add(mVer);
        menu.add(mAyuda);

        window.add(ingresar);
        window.add(actualizar);
        window.add(nuevoR);
        window.add(message);
        for (int i = 0; i < campos.length; i++) {
            window.add(registro[i]);
            window.add(campos[i]);
        }
        window.add(nuevoR);
        window.add(scrollT);
        window.setJMenuBar(menu);
    }

    private void escuchas() {
        escBotones escB = new escBotones();
        ingresar.addActionListener(escB);
        actualizar.addActionListener(escB);
    }

    private void mostrar() {
        window.setVisible(true);
    }

    private class escBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(ingresar)) {
                if (isNumber() == true && isNull() == true) {
                    String data = "INSERT INTO escuela.alumnocomida VALUES ('";
                    data += campos[0].getText() + "','" + campos[1].getText() + "','";
                    data += campos[2].getText() + "'," + campos[3].getText() + ");";
                    for (JTextField campo : campos)
                        campo.setText("");
                    try {
                        mysql.update(data);
                        message.setText("Información ingresada");
                    } catch (SQLException | ClassNotFoundException ex) {
                        System.out.println(ex);
                    }
                }
            } else if (e.getSource().equals(actualizar)) {
                String select = "SELECT * FROM escuela.alumnocomida;";
                try {
                    encabezado = mysql.obtColumName();
                    datos = mysql.instruction(select);
                    table = new JTable(datos, encabezado);
                    message.setText("Actualizado");
                } catch (SQLException | ClassNotFoundException ex) {
                    System.out.println(ex);
                }
            }
        }

        private boolean isNumber() {
            try {
                Integer.parseInt(campos[3].getText());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private boolean isNull() {
            if (campos[0].getText() == null)
                return false;
            else if (campos[1].getText() == null)
                return false;
            else if (campos[2].getText() == null)
                return false;
            else if (campos[3].getText() == null)
                return false;
            return true;
        }
    }
}
