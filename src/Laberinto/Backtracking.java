/* 0 - No visitado
   1 - Barrera
   2 - Intentado y erróneo
   3 - Intentado y acertado
   4 - Inicio
   5 - Fin
   6 - Posible
*/
package Laberinto;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Backtracking {
    private JFrame window;
    private JPanel panel[][]=new JPanel[10][10];
    private int num[][]={{1,4,1,1,1,1,1,1,1,1},
                         {1,0,0,0,0,0,1,0,1,1},
                         {1,0,1,1,1,0,0,0,1,1},
                         {1,0,1,0,0,1,0,1,1,1},
                         {1,0,1,1,0,1,0,1,1,1},
                         {1,0,0,0,0,1,0,1,1,1},
                         {1,1,1,1,0,1,0,0,0,1},
                         {1,1,1,1,0,0,1,1,0,1},
                         {1,1,0,0,0,1,1,1,0,1},
                         {1,1,1,1,1,1,1,1,5,1}};
    GridBagConstraints gridb=new GridBagConstraints();
    GridBagLayout gb=new GridBagLayout();
    int inX, inY;
    Pila road=new Pila((num.length*num.length));
    Generador a=new Generador();
    
    public Backtracking() {
        window=new JFrame("Laberinto: Backtracking");
        inX=0;
        inY=1;
        for (JPanel[] panel1:panel) {
            for (int j=0; j<panel.length; j++)
                panel1[j]=new JPanel();
        }
        
        atributos();
        armar();
        show();
        solve(inX, inY);
        road.visualiza();
    }

    private void atributos() {
        window.setDefaultCloseOperation(3);
        window.setSize(500, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(gb);

        for (int i=0; i<num.length; i++) {
            for (int j=0; j<num.length; j++) {
                switch (num[i][j]) {
                    case 0: panel[i][j].setBackground(Color.WHITE);
                        break;
                    case 1: panel[i][j].setBackground(Color.BLACK);
                        break;
                    case 4: panel[i][j].setBackground(Color.CYAN);
                        break;
                    case 5: panel[i][j].setBackground(Color.BLUE);
                        break;
                    default: panel[i][j].setBackground(Color.WHITE);
                        break;
                }
            }
        }
    }

    private void armar() {
        for (int i=0; i<num.length; i++) {
            for (int j=0; j<num.length; j++) {
                gridb.gridx=i;
                gridb.gridy=j;
                gridb.weightx=3;
                gridb.weighty=3;
                gridb.fill=GridBagConstraints.BOTH;
                window.add(panel[i][j], gridb);
            }
        }
    }

    private void show() {
        window.setVisible(true);
    }

    private boolean solve(int indexX, int indexY) {
        waitMove();
        switch (num[indexX][indexY]) {
            case 0: //casilla no visitada
                num[indexX][indexY]=3;
                road.push(new Coordenada(indexX, indexY));
                panel[indexX][indexY].setBackground(Color.GREEN);
                return dirR(indexX, indexY);
            case 1: //es pared
                return dirR(indexX, indexY);
            case 2: //intentado camino erróneo
                road.pop();
                panel[indexX][indexY].setBackground(Color.RED);
                return dirR(indexX, indexY);
            case 3: //intentado camino correcto
                if(indexX!=road.cima().x && indexY!=road.cima().y)
                    road.push(new Coordenada(indexX, indexY));
                panel[indexX][indexY].setBackground(Color.GREEN);
                return dirR(indexX, indexY);
            case 4: //es la casilla inicial
                road.push(new Coordenada(indexX, indexY));
                return dirR(indexX, indexY);
            case 5: //salida, termina el camino
                road.push(new Coordenada(indexX, indexY));
                return true;
            default:
                break;
        }
        return false;
    }
    
    private boolean dirR(int indX, int indY) {
        if(valLong(indX, indY)==true) {
            //Casillas no visitadas
            if(num[indX][indY-1]==0) return solve(indX, indY-1);//NORTH
            else if(num[indX][indY+1]==0) return solve(indX, indY+1);//SOUTH
            else if(num[indX+1][indY]==0) return solve(indX+1, indY);//EAST
            else if(num[indX-1][indY]==0) return solve(indX-1, indY);//WEST
            //Se encontró la salida
            else if(num[indX][indY-1]==5) return solve(indX, indY-1);
            else if(num[indX][indY+1]==5) return solve(indX, indY+1);
            else if(num[indX+1][indY]==5) return solve(indX+1, indY);
            else if(num[indX-1][indY]==5) return solve(indX-1, indY);
            //Camino erróneo(2) y Regresamos al camino correcto(3)
            else if(num[indX][indY-1]==2) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX][indY+1]==2) {
                road.pop();
                num[indX][indY+1]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX+1][indY]==2) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX-1][indY]==2) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX][indY-1]==3) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX][indY+1]==3) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX-1][indY]==3) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else if(num[indX+1][indY]==3) {
                road.pop();
                num[indX][indY]=2;
                panel[indX][indY].setBackground(Color.RED);
                return solve(road.cima().x, road.cima().y);
            } else {//camino sin salida
                panel[indX][indY].setBackground(Color.RED);
                num[indX][indY]=2;
                road.pop();
                return solve(road.cima().x, road.cima().y);
            }
        } else return false;
    }
    
    private boolean valLong(int i, int j) {
        return i>=0 && i<=num.length && j>=0 && j<=num.length;
    }
    
    private void waitMove() {
        try { Thread.sleep (500); }
        catch (InterruptedException e) { System.out.println(e); }
    }
}
