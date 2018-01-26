public class InteractiveTextUI implements SimulatorUI {

    public void init() {
        System.out.println("welcome to Let's Make a Deal!");
    }

    public void win() {
        System.out.println("you open the door, and...");
        try { Thread.sleep(2000); } catch (Exception e) {}
        System.out.println("congratulations! you've won a brand new car!");
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    public void loss() {
        System.out.println("you open the door, and...");
        try { Thread.sleep(2000); } catch (Exception e) {}
        System.out.println("congratulations! you've won a brand new goat!");
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    public void reveal(int door) {
        System.out.printf("Monty opens door number %d, and reveals that it contains a goat.\n",door);
    }

    public void change(boolean changed, int guess) {
        if (changed) {
            System.out.printf("you have chosen to switch to door number %d!\n",guess);
        } else {
            System.out.printf("you've decided to stick with door number %d.\n",guess);
        }
        System.out.println("lets see if you've won anything...");
    }

    public void getWins() { /* do nothing */ };

    public void error(String msg) {
        System.out.println(msg);
    }
}


