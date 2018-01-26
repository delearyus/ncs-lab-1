import java.util.Random;

public class StayerStrategy implements Strategy {

    private Random randomGen;

    public StayerStrategy() {
        this.randomGen = new Random();
    }

    public int guess() {
        return randomGen.nextInt(3);
    }

    public boolean change() {
        return false;
    }

}
