package JTableBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexionMySQL {
    private Connection cnx = null;

    public void conect() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/escuela";
                cnx = DriverManager.getConnection(url, "root", "ada.SALEM.7");
                System.out.println("Conexión establecida.");
            } catch (SQLException ex) {
                System.out.println("Error de conexión.");
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver no localizado.");
            }
        }
    }

    public void update(String r) throws SQLException, ClassNotFoundException {
        conect();
        int cont = 0;
        if (cnx != null) {
            Statement s = cnx.createStatement();
            int rs = s.executeUpdate(r);
        }
        cerrar();
    }

    public String[][] instruction(String r) throws SQLException, ClassNotFoundException {
        conect();
        String[][] datos = new String[1][1];
        String[][] temp;
        int cont = 0;
        
        if (cnx != null) {
            Statement s = cnx.createStatement();
            ResultSet rs = s.executeQuery(r);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            while (rs.next()) {
                temp = new String[datos.length][col];
                for (int i = 0; i < cont; i++)
                    System.arraycopy(datos[i], 0, temp[i], 0, col);
                datos = new String[cont + 1][col];
                for (int i = 0; i < cont; i++)
                    System.arraycopy(temp[i], 0, datos[i], 0, col);
                for (int i = 1; i <= col; i++)
                    datos[cont][i - 1] = "" + rs.getObject(i);
                cont++;
            }
            return datos;
        }
        cerrar();
        return datos;
    }

    public String[] obtColumName() throws SQLException, ClassNotFoundException {
        conect();
        String[] columns = new String[1];
        ArrayList c = new ArrayList();
        if (cnx != null) {
            Statement s = cnx.createStatement();
            String r = "SELECT * FROM escuela.alumnocomida;";
            ResultSet rs = s.executeQuery(r);
            ResultSetMetaData rsm = rs.getMetaData();
            int col = rsm.getColumnCount();
            for (int i = 1; i <= col; i++)
                c.add(rsm.getColumnName(i));
            columns = new String[c.size()];
            columns = (String[]) c.toArray(columns);
            return columns;
        }
        return columns;
    }

    public void cerrar() throws SQLException {
        if (cnx != null)
            cnx.close();
    }
}
