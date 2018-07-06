package PingPong;

public class Pong implements Runnable {
    String name;
    PingPong pp = new PingPong();
    
    public Pong(String n) {
        name = n;
    }
    
    @Override
    public void run() {
        while(true) {
            pp.impPong(name);
        }
    }
}