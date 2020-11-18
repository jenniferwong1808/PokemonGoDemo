import java.util.Random;
/**
 * Represents a WildPokemon that is a Pokemon with a patience, speed, and timesEscapedFromBall
 *
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class WildPokemon extends Pokemon{
    private int patience;
    private int speed;
    private int timesEscapedFromBall;

    /**
     * Constructs a WildPokemon that is set to default values.
     */
    public WildPokemon() {
        super();
        patience = 100;
        speed = 0;
        timesEscapedFromBall = 0;
    }

    /**
     * Constructs a WildPokemon with a name, sound, type, patience, and speed
     *
     * @param name String representing the name of the wild pokemon
     * @param sound String representing the sound of the wild pokemon
     * @param type String representing the type of the wild pokemon
     * @param patience int representing the patience of the wild pokemon
     * @param speed int representing the speed of the wild pokemon
     */
    public WildPokemon(String name, String sound, String type, int patience, int speed){
        super(name,sound,type);
        this.patience = patience;
        this.speed = speed;
    }

    /**
     * gets the wild pokemon's patience
     *
     * @return int representing the patience of the wild pokemon
     */
    public int getPatience() {
        return patience;
    }

    /**
     * sets the patience to the new patience
     *
     * @param patience int representing the patience of the wild pokemon
     */
    public void setPatience(int patience) {
        this.patience = patience;
    }

    /**
     * gets the wild pokemon's speed
     *
     * @return int representing the speed of the wild pokemon
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * sets the speed to the new speed
     *
     * @param speed int representing the speed of the wild pokemon
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * gets the wild pokemon's timesEscapedFromBall
     *
     * @return int representing the timesEscapedFromBall of the wild pokemon
     */
    public int getTimesEscapedFromBall() {
        return timesEscapedFromBall;
    }

    /**
     * sets the timesEscapedFromBall to the new timesEscapedFromBall
     *
     * @param timesEscapedFromBall int representing the timesEscapedFromBall of the wild pokemon
     */
    public void setTimesEscapedFromBall(int timesEscapedFromBall) {
        this.timesEscapedFromBall = timesEscapedFromBall;
    }

    /**
     * Determines whether the wild pokemon is caught using the berry and pokeball
     *
     * @param berry Berry that is used to boost he chances of catching the wild pokemon
     * @param pokeball Pokeball that is used to catch the wildPokemon
     * @return boolean true if the wildPokemon is caught, false otherwise
     */
    public boolean isCaught(Berry berry, Pokeball pokeball) {
        Random rand = new Random(); //instance of random class
        int upperbound = 101;
        //generate random values from 0-100
        int ballSpeed = rand.nextInt(upperbound);
        int currentSpeed = speed - berry.getSpeedDecrement();
        //prints the pokeball's speed and pokemon's speed after the speed decrement
        System.out.println("BallSpeed: "+ballSpeed);
        System.out.println(super.getName()+"'s speed: "+currentSpeed);
        //determines whether the pokeball hits/missed the wild pokemon
        if (ballSpeed > currentSpeed)
        {
            System.out.println("Your "+pokeball.getName()+" hit "+super.getName()+"!");
            System.out.println();
            // determines final patience and the random patience needed
            int finalPatience = patience+berry.getPatienceIncrement()+pokeball.getPerformance();
            int patienceNeed = rand.nextInt(upperbound);
            // prints the patience needed, pokemon's patience, patience increment, 
            // speed decrement, & performance
            System.out.println("Patience need: "+patienceNeed);
            System.out.println(super.getName()+"'s patience: "+patience);
            System.out.println(berry.getName()+"'s patience increment: "+berry.getPatienceIncrement());
            System.out.println(berry.getName()+"'s speed decrement: "+berry.getSpeedDecrement());
            System.out.println(pokeball.getName()+"'s performance: "+pokeball.getPerformance());
            // determines if the pokeball caught the pokemon
            if (finalPatience >= patienceNeed)
            {
                //returns true if pokemon is caught by pokeball
                System.out.println("Your "+pokeball.getName()+" caught "+super.getName()+"!");
                System.out.println();
                return true;
            }
            else
            {
                // returns false if pokemon escapes from pokeball & times escaped is incremented
                System.out.println(super.getName()+" escaped from your "+pokeball.getName()+"!");
                timesEscapedFromBall++;
                System.out.println();
                return false;
            }
        }
        // if pokeball missed wild pokemon, returns false
        else
        {
            System.out.println("Your "+pokeball.getName()+" missed "+super.getName()+"!");
            System.out.println();
            return false;
        }
    }

    /**
     * Prints the name of the wild pokemon and wild pokemon speaks
     */
    public void appear() {
        System.out.println("You encounter a wild "+super.getName());
        super.speak();
    }

    /**
     * determines if the wild pokemon disappears
     *
     * @return boolean true if patience reaches zero or escaped from call over 3 times, otherwise false
     */
    public boolean disappear() {
        if(patience <= 0||timesEscapedFromBall > 3)
        {
            System.out.println(super.getName()+" disappears...");
            System.out.println();
            return true;
        }
        return false;
    }
}

