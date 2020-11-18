/**
 * Represents an Item with a name
 *
 * Bugs: N/A
 *
 * @author Jennifer Wong
 */
public class Item{
	private String name;
	
	/**
     * Constructs a item with the name "item"
     */
	public Item () {
	    name = "item";
	}

	/**
     * Constructs a berry with a name that encompasses patience increment and speed decrement
     *
     * @param name String representing the name of the item
     */
	public Item(String name) {
	    this.name = name;
	}
	
	/**
     * gets the item name
     *
     * @return String representing the name of the item
     */
	public String getName() {
		return name;
	}
	
	/**
     * sets the name to the new name
     *
     * @param name String representing the name of the item
     */
	public void setName(String name) {
		this.name = name;
	}

}
