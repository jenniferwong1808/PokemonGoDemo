/**
 * Represents a Pokemon with a name, sound, and type.
 *
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class Pokemon {

	private String name;
	private String sound;
	private String type;

	/**
     * Constructs a Pokemon with default values
     */
	public Pokemon() {
		name = "Pokemon";
		sound = "sound";
		type = "unknown";
	}

	/**
     * Constructs a Pokemon with a name, sound, and type
     *
     * @param name String representing the name of the pokemon
     * @param sound String representing the sound of the pokemon
     * @param type String representing the type of the pokemon
     */
	public Pokemon(String name, String sound, String type) {
		this.name = name;
		this.sound = sound;
		this.type = type;
	}

	/**
     * gets the pokemon name
     *
     * @return String representing the name of the pokemon
     */
	public String getName() {
		return name;
	}

	/**
     * sets the name to the new name
     *
     * @param name String representing the name of the pokemon
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * gets the pokemon sound
     *
     * @return String representing the sound of the pokemon
     */
	public String getSound() {
		return sound;
	}

	/**
     * sets the sound to the new sound
     *
     * @param sound String representing the sound of the pokemon
     */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
     * gets the pokemon type
     *
     * @return String representing the type of the pokemon
     */
	public String getType() {
		return type;
	}

	/**
     * sets the type to the new type
     *
     * @param type String representing the type of the pokemon
     */
	public void setType(String type) {
		this.type = type;
	}

	/**
     * Prints the pokemon's name and sound
     */
	public void speak() {
		System.out.println(this.name + ": " + this.sound + "!\n");
	}

}