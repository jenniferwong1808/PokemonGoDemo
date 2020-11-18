import java.util.Scanner;
/**
 * The program simulates the Pokemon Go app. This program let's the user encounter 
 * wild pokemons in which the user can use different berries and/or pokeballs to catch it.
 * 
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class Play {
	private static String[] pokeballNames = {"pokeball", "superball", "ultraball"};
	private static int[] pokeballPerformance = {0, 10, 30};



	private static String[] berryNames = {"Razz Berry", "Nanap Berry", "Golden Razz Berry"};
	private static final int RAZZ_BERRY_PATIENCE_INC = 10;
	private static final int NANAP_BERRY_SPEED_DEC = 10;
	private static final int GOLDEN_RAZE_BERRY_PATIENCE_INC = 30;

	private static String[] pokemonNames = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Mew"};
	private static String[] pokemonSounds = {"pikapika", "bulb", "char", "squir", "mew"};
	private static String[] pokemonTypes = {"electric", "grass", "fire", "water", "psychic"};
	private static int[] pokemonPatienceStats = {60, 50, 50, 50, 15};
	private static int[] pokemonSpeedStats = {25, 5, 20, 10, 50};

	private static final int PATIENCE_DEC_EACH_ESCAPE = 5; //the amount of patience the wild pokemon decreases if escaped from a pokeball
	private static final String PROMPT_MSG_START =
			"This is the start of your pokemon trainer journey.\n" +
			"You will encounter different pokemons.\n" +
			"You can throw different poke balls to catch them.\n" +
			"You can use Razz Berry or Golden Razz Berry to increase the catch rate.\n" +
			"You can use Nanap Berry to make the ball hit more easily.\n" +
			"Up to one berry per throw. Use the berry before your ball throw.\n";

	private static final String PROMPT_MSG_BERRY = "Which berry do you want to use? " +
			"Type skip if you are confident. (Razz Berry, Nanap Berry, Golden Razz Berry, skip)";
	private static final String PROMPT_MSG_BERRY_WRONG_INPUT = "Your berry input was not recognized. " +
			"Choose one from the following four options: Razz Berry, Nanap Berry, Golden Razz Berry, skip";
	private static final String PROMPT_MSG_POKEBALL =
			"Which pokeball do you want to use? (pokeball, superball, ultraball)";
	private static final String PROMPT_MSG_POKEBALL_WRONG_INPUT = "Your pokeball input was not recognized. " +
			"Choose one from the following four options: pokeball, superball, ultraball";
	private static final String PROMPT_MSG_CHECK_CAUGHT_POKEMONS = "Now let's check who're your pals now!\n";


	/**
	 * Let's the user play the game by interacting with the command-line to determine which
	 * berry and/or pokeball to use to catch the wild pokemons they encounter. Prints all the
	 * PalPokemons it caught at the end.
	 */
	public static void startYourJourney() {

		PalPokemon[] myPalPokemons = {new PalPokemon(), new PalPokemon(), 
		        new PalPokemon(),new PalPokemon(),new PalPokemon()};
		// Start the user-machine interaction below
		Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
		System.out.println(PROMPT_MSG_START); // Prompt user
		//iterates through all the wild pokemon names
		for (int i = 0; i < pokemonNames.length; i++) {
		    //instantiates the wild pokemon in the order of the pokemon appearance
		    WildPokemon wildPokemon = new WildPokemon(pokemonNames[i],pokemonSounds[i],pokemonTypes[i],
		            pokemonPatienceStats[i],pokemonSpeedStats[i]);
		    wildPokemon.appear();
		    boolean isCaught = false;
		    //keeps looping until the wild pokemon is not caught
		    while(!isCaught)
		    {
		        System.out.println(PROMPT_MSG_BERRY);
		        boolean validBerry = false;
		        Berry berry = new Berry();
		        //keeps looping until input for berry is valid
		        while (!validBerry)
		        {
		            String inputBerry = myScanner.nextLine();
		            System.out.println();
		            // initialize the berry if input is one of the names in array
		            if (inputBerry.equals(berryNames[0]))
		            {
		                berry = new Berry(berryNames[0],RAZZ_BERRY_PATIENCE_INC,0);
		                validBerry = true;
		            }
		            else if(inputBerry.equals(berryNames[1]))
		            {
		                berry = new Berry(berryNames[1],0,NANAP_BERRY_SPEED_DEC);
		                validBerry = true;
		            }
		            else if(inputBerry.equals(berryNames[2]))
		            {
		                berry = new Berry(berryNames[2],GOLDEN_RAZE_BERRY_PATIENCE_INC,0);
		                validBerry = true;
		            }
		            // initializes the berry with no-arg constructor if skip is inputed
		            else if(inputBerry.equals("skip"))
		            {
		                validBerry = true;
		            }
		            // if input is not a valid input then error message printed & prompts user for input
		            else
		            {
		                System.out.println(PROMPT_MSG_BERRY_WRONG_INPUT);
		            }
		        }
		        // instantiates the arguments for the pokeball
		        String pokeballName = "";
		        int pokeballPerf = 0;
		        boolean pokeballMade = false;
		        System.out.println(PROMPT_MSG_POKEBALL);
		        // loops until the input a valid for the pokeball
		        while (!pokeballMade)
		        {
		            String inputPokeball = myScanner.nextLine();
		            System.out.println();
		            // iterates through valid pokeball names
		            for (int j = 0; j<pokeballNames.length; j++)
		            {
		                // if the input is a valid pokeball name, then name and performance is recorded
		                if (inputPokeball.equals(pokeballNames[j]))
		                {
		                    pokeballName = pokeballNames[j];
		                    pokeballPerf = pokeballPerformance[j];
		                    pokeballMade = true;
		                    break;
		                }
		            }
		            //if input does not exist in the list, then error message printed & prompts user for input
		            if (!pokeballMade)
		                System.out.println(PROMPT_MSG_POKEBALL_WRONG_INPUT);
		        }
		        //pokeball is instantiated with the recorded name and performance
		        Pokeball pokeball = new Pokeball(pokeballName,pokeballPerf);
		        //determines if the wild pokemon is caught with berry and pokeball
		        isCaught = wildPokemon.isCaught(berry,pokeball);
		        if(isCaught)
		        {
		            //wild pokemon becomes a pal pokemon when it is caught
		            //is added into the corresponding position of list
		            myPalPokemons[i] = new PalPokemon(wildPokemon.getName(),wildPokemon.getSound()
		                    ,wildPokemon.getType(),pokeball.getName());
		        }
		        else
		        {
		            //prints the times wild pokemon has escaped if it is not caught
		            System.out.println(wildPokemon.getName()+"'s times escaped from the ball: "
		                    +wildPokemon.getTimesEscapedFromBall());
		            System.out.println();
		            //deduct 5 patience everytime wild pokemon escapes
		            wildPokemon.setPatience(pokemonPatienceStats[i]-
		                    (5*wildPokemon.getTimesEscapedFromBall()));
		            //determines whether wild pokemon will disappear
		            if(wildPokemon.disappear())
		            {
		                //encounters next pokemon if this pokemon disppears
		                break; 
		            }
		        }
		    }
		}
		//after encountering all wild pokemons, it prints all the user's palpokemons
		System.out.println(PROMPT_MSG_CHECK_CAUGHT_POKEMONS);
		for (int i = 0; i < myPalPokemons.length; i++)
		{
		    //only prints the palpokemons that are caught
		    if (!myPalPokemons[i].getPokeballName().equals("undefined"))
		        myPalPokemons[i].comesOutFromBall();
		}
	}
	
	/**
	 * Tests all the test cases for the methods 
     * 
     * Precondition: none
     * Postcondition: Returns true if all test cases pass. If one or
     * more test cases fail, 
     * returns false.
     * 
     * @return true or false depending if all test cases are passed.
     */
	public static boolean unitTests() {
	    // Test case for palPokemon.getPokeballName()
	    // test case 1: pokeballName = "superDuperBall"
	    String expectedName = "superDuperBall";
	    PalPokemon pal = new PalPokemon("pal","grr","pet","superDuperBall");
	    if (!pal.getPokeballName().equals(expectedName))
	    {
	        return false;
	    }
	    
	    // Test case for wildPokemon.getName()
        // test case 1: name = "piglet"
        expectedName = "piglet";
        WildPokemon piglet = new WildPokemon("piglet","honk","fat",50,5);
        if (!piglet.getName().equals(expectedName))
        {
            return false;
        }
        
        // Test case for wildPokemon.getTimesEscapedFromBall()
        // test case 1: timesEscapedFromBall = 4
        int expectedTimes = 4;
        WildPokemon pig = new WildPokemon("pig","honk","fat",50,5);
        pig.setTimesEscapedFromBall(4);
        if (pig.getTimesEscapedFromBall()!=expectedTimes)
        {
            return false;
        }
        
        // Test case for wildPokemon.setPatience()
        // test case 1: patience = 50
        int expectedPatience = 50;
        WildPokemon giggle = new WildPokemon("giggle","hehe","funny",40,5);
        giggle.setPatience(50);
        if (giggle.getPatience()!=expectedPatience)
        {
            return false;
        }
        
        // Test case for wildPokemon.disappear()
        // test case 1: disappear() = true
        boolean expected = true;
        WildPokemon jiggle = new WildPokemon("giggle","hehe","funny",0,5);
        if (jiggle.disappear()!=expected)
        {
            return false;
        }
        
        // Test case for berry.setSpeedDecrement()
        // test case 1: speed = 20
        int expectedSpeed = 20;
        Berry bear = new Berry("bear",10,10);
        bear.setSpeedDecrement(20);
        if (bear.getSpeedDecrement()!=expectedSpeed)
        {
            return false;
        }
		return true;
	}

	/**
     * This is the main method which makes use of the unitTests method that 
     * will determine whether all test cases in the UnitTests method will be passed. 
     * Simulates the Pokemon Go game and lets the user play the game.
     * 
     * Precondition: All test cases has to pass for the game to be played.
     * Postcondition: The game play process is printed to the command-line.
     */
	public static void main(String[] args) {

		// Perform unitTests first
		if(unitTests()) {
			System.out.println("All unit tests passed.\n");
		} else {
			System.out.println("Failed test.\n");
			return;
		}
		startYourJourney();
	}
}
