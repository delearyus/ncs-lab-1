
public class PlayerStrategy implements Strategy {

    public int guess() {
        System.out.println("please choose a door (0 - 2):");
        String response = System.console().readLine();

        int choice;

        try {
            choice = Integer.parseInt(response);
        } catch (NumberFormatException e) {
            System.out.println("Error: cannot parse resonse");
            return guess();
        }

        if (choice >= 0 && choice < 3) {
            return choice;
        } else {
            System.out.println("Error: number must be between 0 and 2");
            return guess();
        }
    }

    public boolean change() {
        System.out.println("would you like to switch? (y/n)");
        String response = System.console().readLine();

        switch (response) {
            case "y":
                return true;
            case "n":
                return false;
            default:
                System.out.println("please enter y or n.");
                return change();
        }
    }
}
