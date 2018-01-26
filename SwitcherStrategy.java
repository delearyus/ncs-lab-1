import java.util.Random;

public class SwitcherStrategy implements Strategy {

    private Random randomGen;

    public SwitcherStrategy() {
        this.randomGen = new Random();
    }

    public int guess() {
        return randomGen.nextInt(3); //0, 1, or 2
    }

    public boolean change() {
        return true;
    }

}
