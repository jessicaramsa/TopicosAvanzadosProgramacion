package Laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Generador {
    int n[][] = new int[10][10];

    public BufferedReader getBuffered(String dir) {
        FileReader lector = null;
        BufferedReader br = null;
        try {
            File file = new File(dir);
            if (!file.exists()) {
                System.out.println("El archivo no existe.");
                createFileMat(file);
            } else {
                lector = new FileReader(dir);
                br = new BufferedReader(lector);
                System.out.println("Se ha cargado el archivo correctamente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    public void readTxt(String file, int[][] m) {
        try {
            BufferedReader br = getBuffered(file);
            String linea = br.readLine();
            m = new int[10][10];
            int contador = 0;
            while (linea != null) {
                String[] values = linea.split(",");
                for (int i = 0; i < values.length; i++) {
                    m[contador][i] = values[i].charAt(i);
                }
                contador++;
                linea = br.readLine();
            }
            imprimir(m);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void createFileMat(File f) throws IOException {
        f.createNewFile();
    }

    public void imprimir(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++)
                System.out.print(m[i][j] + ",");
            System.out.println("");
        }
    }
}
