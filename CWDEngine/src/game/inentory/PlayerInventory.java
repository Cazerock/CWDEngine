package game.inentory;

import org.lwjgl.util.vector.Vector2f;

import engine.graphics.GuiTexture;
import game.inentory.Item.ItemType;

public class PlayerInventory extends Inventory {

	public PlayerInventory(Vector2f position, int width, int height,
			GuiTexture gui) {
		super(position, width, height, gui);
		items = new Item[width][height];
	}
	
	public void open() {
		addItem(ItemType.Coins);
		addItem(ItemType.Poptart);
		
		printoutSlots();
	}
	
}
