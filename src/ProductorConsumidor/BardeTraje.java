package ProductorConsumidor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

public class BardeTraje {
    JFrame window;
    JLabel prov, cons, msg;
    JTextArea provide, consume, moves;
    JProgressBar bar;
    JScrollPane scrollMoves, scrollP, scrollC;
    JButton minP, maxP, minC, maxC, moving;
    int scoreMax, scoreMin, score, indexP, indexC, maxT, unit, iP, iC;
    int qProcessP[], qProcessC[];
    String msg1, msg2;
    Productor processP[] = new Productor[10];
    Consumidor processC[] = new Consumidor[10];

    public BardeTraje() {
        window = new JFrame("B A R   D E   T R A J E");
        prov = new JLabel("Proveedor", SwingConstants.CENTER);
        cons = new JLabel("Consumidor", SwingConstants.CENTER);
        msg = new JLabel(". . .", SwingConstants.CENTER);
        provide = new JTextArea();
        consume = new JTextArea();
        moves = new JTextArea();
        bar = new JProgressBar();
        scrollMoves = new JScrollPane(moves);
        scrollP = new JScrollPane(provide);
        scrollC = new JScrollPane(consume);
        minP = new JButton("-");
        maxP = new JButton("+");
        minC = new JButton("-");
        maxC = new JButton("+");
        moving = new JButton("Movimientos");
        scoreMax = 100;
        scoreMin = 0;
        score = 0;
        indexP = 0;
        indexC = 0;
        maxT = 9;
        unit = 23;
        iP = 0;
        iC = 0;
        qProcessP = new int[maxT];
        qProcessC = new int[maxT];
        for (int i = 0; i < maxT; i++) {
            processP[i] = new Productor("Productor " + i);
            processC[i] = new Consumidor("Consumidor " + i);
            qProcessP[i] = 0;
            qProcessC[i] = 0;
        }

        properties();
        build();
        listeners();
        show();
    }

    private void properties() {
        window.setSize(680, 500);
        window.setResizable(false);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(3);

        bar.setBounds(20, 20, 640, 50);
        bar.setValue(score);
        bar.setMinimum(scoreMin);
        bar.setMaximum(scoreMax);
        bar.setStringPainted(true);
        bar.setString(score + "%");
        bar.setBackground(Color.WHITE);
        bar.setForeground(new Color(0, 179, 134));
        moves.setEditable(false);
        scrollMoves.setBounds(190, 90, 300, 260);
        moving.setBounds(265, 360, 150, 40);
        prov.setBounds(20, 90, 150, 40);
        prov.setOpaque(true);
        prov.setBackground(new Color(0, 102, 204));
        prov.setForeground(Color.WHITE);
        provide.setEditable(false);
        scrollP.setBounds(20, 150, 150, 200);
        minP.setBounds(20, 360, 70, 40);
        maxP.setBounds(100, 360, 70, 40);
        cons.setBounds(510, 90, 150, 40);
        cons.setOpaque(true);
        cons.setBackground(new Color(255, 51, 0));
        cons.setForeground(Color.WHITE);
        consume.setEditable(false);
        scrollC.setBounds(510, 150, 150, 200);
        minC.setBounds(510, 360, 70, 40);
        maxC.setBounds(590, 360, 70, 40);
        msg.setOpaque(true);
        msg.setBounds(20, 410, 640, 40);
    }

    private void build() {
        window.add(prov);
        window.add(cons);
        window.add(scrollP);
        window.add(scrollC);
        window.add(bar);
        window.add(scrollMoves);
        window.add(moving);
        window.add(minP);
        window.add(maxP);
        window.add(minC);
        window.add(maxC);
        window.add(msg);
    }

    private void listeners() {
        ListenField lF = new ListenField();
        minP.addActionListener(lF);
        maxP.addActionListener(lF);
        minC.addActionListener(lF);
        maxC.addActionListener(lF);
        moving.addActionListener(lF);
    }

    private void show() {
        window.setVisible(true);
        startT();
    }

    public class ListenField implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(minP)) {
                if(indexP > 0) {
                    processP[iP].waitT();
                    msg1 = "Productor " + iP +" eliminado";
                    msg.setText(msg1);
                    moves.setText(moves.getText() + msg1 + "\n");
                    indexP--;
                } else
                    msg.setText("No se pueden eliminar más productores");
            } else if(e.getSource().equals(maxP)) {
                if(indexP < maxT) {
                    int qP = randomQ(unit);
                    iP = randomQ(maxT);
                    ExecutorService exec = Executors.newCachedThreadPool();
                    exec.execute(processP[iP]);
                    indexP++;
                } else
                    msg.setText("No se pueden agreagr más productores");
            } else if(e.getSource().equals(minC)) {
                if(indexC > 0) {
                    processC[iC].waitT();
                    msg1 = "\t    Consumidor " + iC +" eliminado";
                    msg.setText(msg1);
                    moves.setText(moves.getText() + msg1 + "\n");
                    indexC--;
                } else
                    msg.setText("No se pueden eliminar más consumidores");
            } else if(e.getSource().equals(maxC)) {
                if(indexC < maxT) {
                    int qC = randomQ(unit);
                    iC = randomQ(maxT);
                    ExecutorService exec = Executors.newCachedThreadPool();
                    exec.execute(processC[iC]);
                    indexC++;
                } else
                    msg.setText("No se pueden agregar más consumidores");
            } else if(e.getSource().equals(moving)) {
                String t = "";
                if(indexP > 0 && indexC > 0) {
                    for (int p = 0; p < maxT; p++) {
                        if(qProcessP[p] != 0) {
                            t += "Productor " + p + " = " + qProcessP[p] + "\n";
                        }
                    }
                    t += "\n";
                    for (int c = 0; c < maxT; c++) {
                        if(qProcessC[c] != 0) {
                            t += "Consumidor " + c + " = " + qProcessC[c] + "\n";
                        }
                    }
                    t += "\nScore actual = " + score;
                    msg.setText("Productores y consumidores");
                    JOptionPane.showConfirmDialog(null, t, "Resultados", -1);
                } else if(indexP > 0) {
                    for (int p = 0; p < maxT; p++) {
                        if(qProcessP[p] != 0) {
                            t += "Productor " + p + " = " + qProcessP[p] + "\n";
                        }
                    }
                    t += "\nScore actual = " + score;
                    msg.setText("Productores");
                    JOptionPane.showConfirmDialog(null, t, "Resultados", -1);
                } else
                    msg.setText("No hay productores ni consumidores para mostrar");
            }
        }
    }
    
    public synchronized void introduce(int index, int quantity, String name) {
        if((score + quantity) < scoreMax) {
            msg1 = provide.getText() + name + ": " + quantity + "\n";
            msg2 = moves.getText() + name + ": " + quantity + "\n";
            score += quantity;
            qProcessP[index] +=quantity;
            provide.setText(msg1);
            moves.setText(msg2);
            bar.setValue(score);
            bar.setString(score + "%");
        } else {
            msg1 = "Espacio insuficiente (intento = " + quantity;
            msg1+= ", actual = " + score + ")";
            msg.setText(msg1);
        }
        try {
            sleep(400);
            notifyAll();
        } catch (InterruptedException ex) {
            msg.setText(ex.toString());
        }
    }

    public synchronized void remove(int index, int quantity, String name) {
        if(score >= quantity && (score - quantity) > scoreMin) {
            msg1 = consume.getText() + name + ": " + quantity + "\n";
            msg2 = moves.getText() + "\t    " + name + ": " + quantity + "\n";
            score -= quantity;
            qProcessC[index] += quantity;
            consume.setText(msg1);
            moves.setText(msg2);
            bar.setValue(score);
            bar.setString(score + "%");
        } else {
            msg1 = "Insumos insuficientes (intento = " + quantity;
            msg1+= ", actual = " + score + ")";
            msg.setText(msg1);
        }
        try {
            sleep(400);
            notifyAll();
        } catch (InterruptedException ex) {
            msg.setText(ex.toString());
        }
    }
    
    public void startT() {
        int p1, p2, p3, c1, c2, c3;
        p1 = randomQ(unit);
        p2 = randomQ(unit);
        p3 = randomQ(unit);
        c1 = randomQ(unit);
        c2 = randomQ(unit);
        c3 = randomQ(unit);
        processP[0] = new Productor("Productor 1");
        processP[1] = new Productor("Productor 2");
        processP[2] = new Productor("Productor 3");
        indexP = 3;
        processC[0] = new Consumidor("Consumidor 1");
        processC[1] = new Consumidor("Consumidor 2");
        processC[2] = new Consumidor("Consumidor 3");
        indexC = 3;
        
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
                iP = i + 1;
                exec.execute(processP[i]);
                Thread.sleep(300);
                iC = i + 1;
                exec.execute(processC[i]);
            } catch (InterruptedException e) {
                msg.setText(e.toString());
            }
        }
    }

    public int randomQ(int n) {
        int quant = (int)(Math.random() * (n-1)) + 1;
        return quant;
    }
}
