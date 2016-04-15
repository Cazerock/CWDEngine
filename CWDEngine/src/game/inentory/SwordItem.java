package game.inentory;

import java.util.List;

import entities.Entity;
import entities.Player;

public class SwordItem extends Item {

	public SwordItem(ItemType type) {
		super(ItemType.Sword);
	}
	
	public int getDamage() {
		return super.getDamage();
	}
	
	public void onUse(List<Entity> list, Item item) {
		for (Entity e : list) {
			if(e instanceof Player) {
				System.out.println(e.getPosition());
			}
		}
		
		//Removes object
		if(getDamage() > getMaxDamage()) {
			item = null;
		}
	}
}
