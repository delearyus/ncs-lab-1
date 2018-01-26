import java.util.Random;
import java.util.Arrays;

public class Simulator {

    private Random r;
    private SimulatorUI ui;
    private Strategy s;

    private int carDoor;

    public Simulator(SimulatorUI ui,Strategy s) {
        this.r = new Random();
        this.ui = ui;
        this.s = s;
    }

    public void run() {
        resetDoors();
        ui.init();
        int firstChoice = s.guess();
        int revealedDoor;
        switch (firstChoice) {
            case 0:
                revealedDoor = carDoor == 1 ? 2 : 1;
                break;
            case 1:
                revealedDoor = carDoor == 0 ? 2 : 0;
                break;
            case 2:
                revealedDoor = carDoor == 0 ? 1 : 0;
                break;
            default:
                ui.error("guess() returned an invalid function");
                return;
        }
        ui.reveal(revealedDoor);
        boolean change = s.change();

        int secondChoice = firstChoice;

        if (change) {
            switch (firstChoice) {
                case 0:
                    secondChoice = revealedDoor == 1 ? 2 : 1;
                    break;
                case 1:
                    secondChoice = revealedDoor == 0 ? 2 : 0;
                    break;
                case 2:
                    secondChoice = revealedDoor == 0 ? 1 : 0;
                    break;
                default:
                    ui.error("something is horribly wrong.");
                    return;
            }
        }
        ui.change(change, secondChoice);

        if (secondChoice == carDoor) {
            ui.win();
        } else {
            ui.loss();
        }

    }

    public void resetDoors() {
        carDoor = r.nextInt(3);
    }
}

