public interface Strategy {
    public int guess(); //between 0 and 2, represents the chosen door
    public boolean change(); //decide whether to switch doors or not
}
