package ProductorConsumidor;

public class Consumidor implements Runnable {
    private String name;
    BardeTraje b = new BardeTraje();
    
    public Consumidor(String n) {
        this.name = n;
    }
    
    @Override
    public void run() {
        int quant = b.randomQ(b.unit);
        while(quant < b.scoreMax) {
            b.remove(b.iC, quant, name);
        }
    }
    
    public void waitT() {
        b.indexC--;
        try {
            this.wait();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}