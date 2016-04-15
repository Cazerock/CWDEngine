package game.inentory;

import org.lwjgl.util.vector.Vector2f;

import engine.graphics.GuiTexture;
import game.inentory.Item.ItemType;

public abstract class Inventory {
	
	private GuiTexture gui;
	protected Item[][]items;
	
	public Inventory(Vector2f position,int width, int height, GuiTexture gui) {
		this.gui = gui;
	}
	
	protected boolean findNextEmptySlot() {
		boolean found = false;
		outloop:
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				System.out.println(items[i][j]);
				if (items[i][j] == null) {
					found = true;
					break outloop;
				}
			}	
		}
		if (!found) 
			System.out.println("No empty slots found");
		return found;
	}
	
	protected void addItem(ItemType type) {
		Item item = new Item(type);
	
		if (!findNextEmptySlot()) {
			System.out.println("Inventory Full");
			return;
		}
		outside: //This is weird.....
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[i].length; j++) {
				if (items[i][j] != null && items[i][j].getType() == type && 
						items[i][j].stackSize < items[i][j].getType().maxstack) {
					items[i][j].stackSize += 1;
					break outside;
				} else if (items[i][j] == null) {
					items[i][j] = item;
					break outside;
				}
			}	
		}
	}
	
	public void open() {
		
	}
	
	public void printoutSlots() {
		for (int x = 0; x < items.length; x++) {
			for (int y = 0; y < items[x].length; y++) {
					System.out.println(items[x][y].getType() + " : " + items[x][y].stackSize);
			}	
		}
	}
	
	public GuiTexture getImage() {
		return gui;
	}
	
}
