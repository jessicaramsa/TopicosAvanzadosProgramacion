package ProductorConsumidor;

public class Productor implements Runnable {
    private String name;
    BardeTraje b = new BardeTraje();
    
    public Productor(String n) {
        this.name = n;
    }
    
    @Override
    public void run() {
        int quant = b.randomQ(b.unit);
        while(quant < b.scoreMax) {
            b.introduce(b.iP, quant, name);
        }
    }
    
    public void waitT() {
        b.indexP--;
        try {
            this.wait();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}