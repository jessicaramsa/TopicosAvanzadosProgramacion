package PingPong;

public class Ping implements Runnable {
    String name;
    PingPong pp = new PingPong();
    
    public Ping(String n) {
        name = n;
    }
    
    @Override
    public void run() {
        while(true) {
            pp.impPing(name);
        }
    }
}
