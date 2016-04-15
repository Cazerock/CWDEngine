package game.inventory;

import engine.graphics.GuiTexture;

public abstract class Item {
	
	public enum ItemType {
		Poptart,
		Roofies,
		Bullets,
		Vodka44oz
	}
	
	private int maxDamage = 0;
	private int damage;
	private ItemType type;
	private String name;
	private int maxStackSize;
	private GuiTexture icon;
	private int id;
	private int number;
	
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

	public int getMaxStackSize() {
		return maxStackSize;
	}

	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = maxStackSize;
	}

	public GuiTexture getIcon() {
		return icon;
	}

	public void setIcon(GuiTexture icon) {
		this.icon = icon;
	}
	
	private void setId(int i){
		id = damage + i;
	}
	
	public int getId(){
		return id;
	}
	
	public void increaseNumber(){
		number++;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void dispose(Inventory i){
		for (int r = 0; r < i.getNumRows(); r++){
			for (int c = 0; c < i.getNumColumns(); c++){
				if (i.getItem(r, c).getId() == this.getId()){
					this.id = 0;
					this.number = 0;
					this.name = "";
					this.icon = null;
				}
			}
		}
	}
	
}
