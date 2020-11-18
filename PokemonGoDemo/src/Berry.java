
/**
 * Represents a Berry that is an Item with a patience increment and speed decrement
 *
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class Berry extends Item {
    private int patienceIncrement;
    private int speedDecrement;
    
    /**
     * Constructs a berry that is an item with 0 patience increment & speed decrement
     */
    public Berry() {
        super();
        patienceIncrement = 0;
        speedDecrement = 0;
    }

    /**
     * Constructs a berry with a name that encompasses patience increment and speed decrement
     *
     * @param name String representing the name of the berry
     * @param patienceIncrement int representing the amount of patience being increment
     * @param speedDecrement int representing the number of speed being decremented
     */
    public Berry(String name, int patienceIncrement, int speedDecrement) {
        super(name);
        this.patienceIncrement = patienceIncrement;
        this.speedDecrement = speedDecrement;
    }

    /**
     * gets the patience increment
     *
     * @return int representing patience increment
     */
    public int getPatienceIncrement() {
        return this.patienceIncrement;
    }

    /**
     * sets the patience increment to the new patience increment
     *
     * @param patienceIncrement int representing the amount of patience being increment
     */
    public void setPatienceIncrement(int patienceIncrement) {
        this.patienceIncrement = patienceIncrement;
    }

    /**
     * gets the speed decrement
     *
     * @return int representing the number of speed being decremented
     */
    public int getSpeedDecrement() {
        return this.speedDecrement;
    }
    
    /**
     * sets the speed decrement to the new speed decrement
     *
     * @param speedDecrement int representing the number of speed being decremented
     */
    public void setSpeedDecrement(int speedDecrement) {
        this.speedDecrement = speedDecrement;
    }
}

