/*MAIN TASKS: stores attributes of each item 
 *			: getters and setters 
 */

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

/** 
  * Stores and operates on item details like name, calories, standalone status, price, and stock.
  */
public class Item {
    protected final String name;
    private final double calories;
    private final boolean standalone;
    private int price;
	private int grid;

	/** 
      * A constructor that creates an item instance given complete attributes.
	  * @param name 		The item's name
	  * @param calories		The decimal amount of calories the item contains
	  * @param standalone	Whether or not the item can be sold alone
	  * @param price		The cost of the item
	  * @param stock 		The quantity of the item available for sale
      */
    public Item(String name, double calories, boolean standalone, int price, int grid) { 
        this.name = name;
        this.calories = calories;
		this.standalone = standalone;
        this.price = price;
		this.grid
    }

	/** 
      * Gets and returns the item's name.
	  * @return The item's name
      */
    public String getName() {
        return this.name;
    }

	/** 
      * Gets and returns the item's calorie measurement.
	  * @return The item's decimal calorie measurement
      */
    public double getCalories() {
        return this.calories;
    }

	/** 
      * Gets and returns the item's standalone status.
	  * @return Whether or not the item can be sold alone
      */
    public boolean getStandalone() {
        return this.standalone;
    }

	/** 
      * Gets and returns the item's price.
	  * @return The item's price
      */
    public int getPrice() {
        return this.price;
    }
	
	public int getGrid() {
		return this.grid;
	}

	/** 
      * Changes the item's current price to a new amount
	  * @param newPrice The updated cost of the item
      */
    public void setPrice(int newPrice){
        this.price = newPrice;   
    }
	
	public ImageIcon getImageIcon() {
		try{
			Url spriteSheet = Item.class.getResource("Item_Sprite_Sheet.png");
			
			ImageIcon spriteSheet = new ImageIcon(spriteSheet);

			int x = this.grid * 32; //each ingredient image is 32x32 pixels in size
			int width = 32;
			int height = 32;

			// Extract the ingredient's image from the sprite sheet and create a new ImageIcon
			return new ImageIcon(spriteSheet.getImage().getSubimage(x, width, height));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}