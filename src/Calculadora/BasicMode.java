package Calculadora;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasicMode {
    JFrame ventana;
    JPanel area;
    JButton bot[][] = new JButton[6][4];
    int cont, lim;
    String caracter[] = {"7", "4", "1", "0", "8", "5", "2", ".", "9", "6", "3", "%", "/",
        "x", "-", "+", "AC", "(", "^n", "=", "<¬", ")", "√", "Relleno"};
    String texto, t;
    JTextField recuadro;
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    ArrayList memoria;
    Operandos op = new Operandos();

    public BasicMode() {
        ventana = new JFrame("Calculadora: Modo Básico");
        area = new JPanel();
        texto = "";
        t = "";
        lim = 29;
        recuadro = new JTextField(texto, lim);
        memoria = new ArrayList();
        cont = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                bot[i][j] = new JButton(caracter[cont]);
                cont++;
            }
        }
        cont = 0;

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

        area.setLayout(gb);
        area.setBackground(new Color(153, 204, 255));
        recuadro.setSize(700, 600);
        recuadro.setFont(new Font("Calculator", Font.BOLD, 30));
        recuadro.setEditable(false);
        recuadro.setBackground(Color.WHITE);
        recuadro.setForeground(new Color(9, 62, 141));
        recuadro.setHorizontalAlignment(JTextField.RIGHT);

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                bot[i][j].setSize(50, 50);
                bot[i][j].setBackground(new Color(0, 128, 255));
                bot[i][j].setFont(new Font("Calculator", Font.BOLD, 30));
            }
        }

        gbc.insets = new Insets(1, 1, 1, 1);
    }

    private void armar() {
        ventana.add(recuadro, BorderLayout.NORTH);
        ventana.add(area, BorderLayout.CENTER);

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) {
                if(i == 5 && j == 3)
                    bot[5][3].setVisible(false);
                else {
                    gbc.gridx = i;
                    gbc.gridy = j;
                    gbc.weightx = 2;
                    gbc.weighty = 3;
                    gbc.fill = GridBagConstraints.BOTH;
                    area.add(bot[i][j], gbc);
                }
            }
        }

        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        area.add(bot[4][3], gbc);
    }

    private void escuchas() {
        escMouse em = new escMouse();
        recuadro.addKeyListener(new escKeyboard());
        recuadro.requestFocusInWindow();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++)
                bot[i][j].addMouseListener(em);
        }
    }

    private void mostrar() {
        ventana.setVisible(true);
        ventana.pack();
        recuadro.requestFocusInWindow();
        recuadro.transferFocus();
    }

    private class escMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            cont = 0;
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 4; j++) {
                    if(e.getSource().equals(bot[i][j]) && texto.length() <= lim) {
                        if(e.getSource().equals(bot[1][3])) {//punto decimal
                            if(valCaracter(t) == false) {
                                texto += caracter[cont];
                                t += caracter[cont];
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[2][3])) {//porcent
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[3][0])) {//dividir
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[3][1])) {//multip
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[3][2])) {//restar
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[3][3])) {//sumar
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[4][0])) {//borra todo
                            texto = "";
                            t = "";
                            memoria.clear();
                            recuadro.setText(texto);
                        } else if(e.getSource().equals(bot[4][1])) {//parAbre
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[4][3])) {//igual
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                recuadro.setText(texto);
                                igual(memoria);
                            }
                        } else if(e.getSource().equals(bot[4][2])) {//potencia
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else if(e.getSource().equals(bot[5][0])) {
                            delete();
                            memoria.clear();
                        } else if(e.getSource().equals(bot[5][1])) {//parCierra
                            if(valCaracter(t) == false) {
                                agrega(t);
                                texto += caracter[cont];
                                agrega(caracter[cont]);
                                recuadro.setText(texto);
                            }
                        } else {//numeros
                            texto += caracter[cont];
                            t += caracter[cont];
                            recuadro.setText(texto);
                        }
                    }
                    cont++;
                }
            }
        }
    }

    private class escKeyboard implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {  //tecla da entrada
            int nTecla = e.getKeyChar();
            if(tValida(nTecla) == true && recuadro.getText().length() <= lim) {
                if(42 <= nTecla && nTecla <= 47) {//teclado numerico
                    t += (char) nTecla;
                    agrega(t);
                    texto += (char) nTecla;
                    recuadro.setText(texto);
                } else if(48 <= nTecla && nTecla <= 57) {//0-9
                    t += (char) nTecla;
                    agrega(t);
                    texto += (char) nTecla;
                    recuadro.setText(texto);
                } else if(96 <= nTecla && nTecla <= 105) {//operandos
                    if(valCaracter(t) == false) {
                        agrega(t);
                        texto += (char) nTecla;
                        recuadro.setText(texto);
                    }
                } else
                    recuadro.setText(recuadro.getText());
            }
        }

        private boolean tValida(int nTecla) {
            boolean bandera;
            if(48 <= nTecla && nTecla <= 57)
                bandera = true;//del 0 al 9
            else if(96 <= nTecla && nTecla <= 105)
                bandera = true;//operandos
            else if(42 <= nTecla && nTecla <= 47)
                bandera = true;//teclado numérico
            else
                bandera = nTecla == '.';//punto decimal
            return bandera;
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    private boolean valCaracter(String cad) {
        return cad.contains(caracter[cont]);
    }

    private void delete() {
        if(recuadro.getText().length() != 0) {
            String nText;
            nText = recuadro.getText().substring(0, recuadro.getText().length() - 1);
            texto = nText;
            t = nText;
            memoria.remove(memoria.get(memoria.size()));
            memoria.add(t);
            recuadro.setText(texto);
        }
    }

    private void valNum(String cad) {
        try {
            Double.parseDouble(cad);
        } catch (NumberFormatException e) {
            System.out.println("No es número");
        }
    }

    private void agrega(String cad) {
        memoria.add(cad);
        t = "";
    }

    private void igual(ArrayList mem) {
        NPostfija np = new NPostfija(mem);
        texto = String.valueOf(np.getValor());
        memoria.clear();
        memoria.add(texto);
        recuadro.setText(texto);
    }
}
