package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDerby {
    public static void main(String[] args) {
        String bd = "jdbc:derby://localhost:1527/escuela";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conecta = DriverManager.getConnection(bd, "root", "loquesea");
            Statement sql = conecta.createStatement();
            ResultSet consulta = sql.executeQuery("SELECT * FROM ROOT.ALUMNO");
            ResultSetMetaData rsm = consulta.getMetaData();
            int col = rsm.getColumnCount();
            for(int i = 1; i <= col; i++)
                System.out.print("\t\t\t\t" + rsm.getColumnName(i));
            System.out.println();
            while(consulta.next()) {
                for (int i = 1; i <= col; i++)
                    System.out.print("\t\t" + consulta.getObject(i));
                System.out.println();
            }
        } catch(SQLException ex) {
            System.out.println("Error de conexión");
        } catch(ClassNotFoundException ex) {
            System.out.println("Controlador no disponible");
        }
    }
}
