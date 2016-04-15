package game.inentory;

import engine.graphics.GuiTexture;

public interface IInventory {
	
	public void setName(String name);
	public String getName();
	
	public void setBackground(GuiTexture texture);
	public GuiTexture getBackground();

	
}
