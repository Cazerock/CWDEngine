package game.inentory;

import java.util.List;

import engine.graphics.GuiTexture;
import entities.Entity;

public  class Item {
	
	public enum ItemType {
		
		Poptart(32, 0),
		Coins(32, 1),
		Sword(1, 2);
		private ItemType(int maxStackSize, int id) {
			maxstack = maxStackSize;
			this.id = id;
		}
		int id;
		int maxstack;
			
	}
	
	public int stackSize = 1;
	private int maxDamage = 0;
	private int damage;
	private ItemType type;
	private String name;
	private GuiTexture icon;
	
	public Item(ItemType type) {
		this.type = type;
	}

	public void setMaxDamage(int damage) {
		this.maxDamage = damage;
	}
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		
	}
	
	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GuiTexture getIcon() {
		return icon;
	}

	public void setIcon(GuiTexture icon) {
		this.icon = icon;
	}
	
	/**
	 * 
	 * @param entity
	 * On right click action
	 */
	public void onUse(List<Entity> list) {
		
	}
	
}
