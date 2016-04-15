package game.inventory;

import engine.graphics.GuiTexture;

public abstract class Inventory {
	
	GuiTexture gui;
	GuiTexture[][] slots;
	Item[][]items;
	int r; //rows
	int c; //columns
	
	public Inventory(int width, int height, GuiTexture gui) {
		r = width;
		c = height;
		items = new Item[width][height];
		slots = new GuiTexture[width][height];
	}
	
	public int getNumRows(){
		return r;
	}
	
	public int getNumColumns(){
		return c;
	}
	
	public Item[][] getItems(){
		return items;
	}
	
	public Item getItem(int row, int column){
		return items[row][column];
	}
	
	public boolean isSlotOccupied(int row, int column){
		if (this.getItem(r, c).getId()%10 != 0){
			return true;
		}else {
			return false;
		}
	}
	
}
