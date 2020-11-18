/**
 * Represents a Pokeball that is an Item with the performance
 *
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class Pokeball extends Item{
    private int performance;

    /**
     * Constructs a Pokeball with 0 performance
     */
    public Pokeball() {
        super();
        performance = 0;
    }

    /**
     * Constructs a Pokeball with a name and performance
     *
     * @param name String representing the name of the pokeball
     * @param performance int representing the performance of the pokeball
     */
    public Pokeball(String name, int performance) {
        super(name);
        this.performance = performance;
    }

    /**
     * gets the Pokeball's performance
     *
     * @return int representing the performance of the Pokeball
     */
    public int getPerformance() {
        return performance;
    }

    /**
     * sets the performance to the new performance
     *
     * @param performance int representing the performance of the pokeball
     */
    public void setPerformance(int performance) {
        this.performance = performance;
    }
}

