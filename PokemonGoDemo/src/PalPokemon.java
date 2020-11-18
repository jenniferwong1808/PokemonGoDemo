/**
 * Represents a PalPokemon that is a Pokemon with the name of the pokeball that caught it
 *
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class PalPokemon extends Pokemon{
    private String pokeballName;

    /**
     * Constructs a PalPokemon that is a Pokemon with a undefined name pokeball
     */
    public PalPokemon() {
        super();
        pokeballName = "undefined";
    }

    /**
     * Constructs a PalPokemon from the name, sound, type, and pokeballName
     *
     * @param name String representing the name of the PalPokemon
     * @param sound String representing the sound of the PalPokemon
     * @param type String representing the type of the PalPokemon
     * @param pokeballName String representing the name of the pokeball that caught it
     */
    public PalPokemon(String name, String sound, String type, String pokeballName) {
        super(name,sound,type);
        this.pokeballName = pokeballName;
    }

    /**
     * gets the PalPokemon's name
     *
     * @return String representing the name of the PalPokemon
     */
    public String getPokeballName() {
        return pokeballName;
    }

    /**
     * sets the pokeballName to the new pokeballName
     *
     * @param pokeballName String representing the name of the pokeballName
     */
    public void setPokeballName(String pokeballName) {
        this.pokeballName = pokeballName;
    }

    /**
     * PalPokemon prints its name, pokeball, type, and speaks
     */
    public void comesOutFromBall(){
        System.out.println(super.getName()+" in "+pokeballName+", "
                +super.getType()+" type pokemon.");
        super.speak();
    }
}
