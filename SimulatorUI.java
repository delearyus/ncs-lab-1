public interface SimulatorUI {

    // what to do on success or failure
    public void win();
    public void loss();

    public void init(); // called at the start of a game

    public void reveal(int door);
    // called when a door is revealed (door ranges from 0-2)

    public void change(boolean changed, int newGuess);
    // called after the user decides whether or not to change
    
    public void error(String msg);
    // called when something goes wrong
    
}
