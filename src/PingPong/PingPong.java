package PingPong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PingPong {
    JFrame window;
    JLabel ping, pong;
    JTextArea moves;
    JScrollPane scroll;
    JButton start;
    boolean flag;

    public PingPong() {
        window = new JFrame("Ping-Pong");
        ping = new JLabel("P I N G", SwingConstants.CENTER);
        pong = new JLabel("P O N G", SwingConstants.CENTER);
        moves = new JTextArea();
        scroll = new JScrollPane(moves);
        start = new JButton("Iniciar");
        flag = true;
        
        atributos();
        armar();
        escuchas();
        mostrar();
    }

    private void atributos() {
        window.setSize(530, 450);
        window.setResizable(false);
        window.setLayout(null);
        window.setDefaultCloseOperation(3);
        window.setLocationRelativeTo(null);

        ping.setOpaque(true);
        ping.setBounds(50, 30, 100, 40);
        pong.setOpaque(true);
        pong.setBounds(310, 30, 100, 40);
        moves.setEditable(false);
        scroll.setBounds(20, 90, 350, 300);
        start.setBounds(400, 200, 100, 40);
    }

    private void armar() {
        window.add(ping);
        window.add(pong);
        window.add(scroll);
        window.add(start);
    }

    private void escuchas() {
        escBotones eb = new escBotones();
        start.addActionListener(eb);
    }

    private void mostrar() {
        window.setVisible(true);
    }

    private class escBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(start)) {
                Ping ping1 = new Ping("Ping");
                Ping ping2 = new Ping("PingPing");
                Pong pong1 = new Pong("Pong");
                Pong pong2 = new Pong("PongPong");
                
                ExecutorService exec = Executors.newCachedThreadPool();
                exec.execute(ping1);
                exec.execute(ping2);
                exec.execute(pong1);
                exec.execute(pong2);
            }
        }
    }
    
    public synchronized void impPing(String name) {
        String c = moves.getText();
        if(flag == true) {
            moves.setText(c+"\n" + name);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            flag = false;
            ping.setBackground(Color.BLACK);
            ping.setForeground(Color.RED);
            pong.setBackground(Color.WHITE);
            pong.setForeground(Color.BLACK);
        }
        notifyAll();
        try {
            wait(400);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }

    public synchronized void impPong(String name) {
        String c = moves.getText();
        if(flag == false) {
            moves.setText(c+"\n\t\t" + name);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            flag = true;
            pong.setBackground(Color.BLACK);
            pong.setForeground(Color.RED);
            ping.setBackground(Color.WHITE);
            ping.setForeground(Color.BLACK);
        }
        notifyAll();
        try {
            wait(400);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
