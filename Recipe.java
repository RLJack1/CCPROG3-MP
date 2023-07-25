/*MAIN TASKS: contain recipe data
			: getters and setters
 */
 
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class Recipe {
	 private String name;
	 private ArrayList<Ingredient> ingredientList;
	 private int grid;
	 
	 public Recipe(String name, int grid) {
		 this.ingredientList = new ArrayList<Ingredient>();
		 this.grid = grid;
	 }
	 
	 public void addIngredient(Ingredient i) {
		 this.ingredientList.add(i);
	 }
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public ArrayList<Ingredient> getIngredientList() {
		 return this.ingredientList;
	 }
	 
	 public ImageIcon getImageIcon() {
		try{
			Url spriteSheet = Item.class.getResource("Burger_Sprite_Sheet.png");
			
			ImageIcon spriteSheet = new ImageIcon(spriteSheet);

			int x = this.grid * 32; //each burger image is 32x32 pixels in size
			int width = 32;
			int height = 32;

			// Extract the ingredient's image from the sprite sheet and create a new ImageIcon
			return new ImageIcon(spriteSheet.getImage().getSubimage(x, width, height));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
 }