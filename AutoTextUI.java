import java.util.concurrent.atomic.AtomicInteger;

public class AutoTextUI implements SimulatorUI {

    private AtomicInteger wins;
    
    public AutoTextUI(AtomicInteger wins) {
        this.wins = wins;
    }

    public void init() { /* do nothing */ }

    public void win() { wins.incrementAndGet(); };
    public void loss() { /* do nothing */ };

    public void reveal(int door) { /* do nothing */ };
    public void change(boolean changed, int guess) { /* do nothing */ };

    public void error(String msg) {
        System.out.println(msg);
    }

}
