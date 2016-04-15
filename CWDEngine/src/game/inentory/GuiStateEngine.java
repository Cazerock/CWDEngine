package game.inentory;

import java.util.HashMap;

import engine.graphics.GuiRenderer;

public class GuiStateEngine {
	
	public HashMap<Integer, Inventory> guis = new HashMap<Integer, Inventory>();
	
	public int current = 0; 
	public int prev = 0;
	
	public GuiStateEngine() {
		
	}
	
	public void changeGui(int gui) {
		prev = current;
		current = gui;
		try {
			guis.get(current).open();
		} catch (Exception e){
//			e.printStackTrace();
		}
	}
	
	public void renderGui(GuiRenderer batcher) {
		if (current != 0 || guis.get(current) != null)	
			batcher.render(guis.get(current).getImage());
	}
	
}
