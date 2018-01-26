import java.util.concurrent.atomic.AtomicInteger;

public class MonteHall {

    public static void main(String[] args) {
        if (args.length != 1) { printHelp(); return; }
        switch (args[0]) {
            case "interactive":
            case "i":
                runInteractive();
                return;
            default:
                try {
                    runTests(Integer.parseInt(args[0]));
                } catch (Exception e) {
                    printHelp();
                }
                return;
        }
    }

    public static void printHelp() {
        System.out.println("usage: ./main (n|[i]nteractive)");
        System.out.println("./main (n) runs tests n times each");
        System.out.println("./main i or ./main interactive runs interactively");
    }

    public static void runInteractive() {

        Simulator s = new Simulator(
                new InteractiveTextUI(),
                new PlayerStrategy());

        while (true) {
            try {
                s.run();
            } catch (Exception e) {
                System.out.println("Simulator encountered an error:");
                System.out.println(e);
                return;
            }
            System.out.println("starting new game...");
        }
    }

    public static void runTests(int count) {

        AtomicInteger stayWins = new AtomicInteger();
        AtomicInteger switchWins = new AtomicInteger();

        Simulator s1 = new Simulator(new AutoTextUI(stayWins),new StayerStrategy());
        Simulator s2 = new Simulator(new AutoTextUI(switchWins),new SwitcherStrategy());

        System.out.println("starting simulation");

        for (int i = 0; i < count; i++) {
            s1.run();
            s2.run();
        }

        System.out.println("simulation finished");
        System.out.printf("win percent (stay):   %f\n",stayWins.floatValue() / count);
        System.out.printf("win percent (switch): %f\n",switchWins.floatValue() / count);

    }
}

