package game.inventory;

public class InventoryStack {

	public void stackItems(Item item, Inventory inventory){
		Item[][] items = inventory.getItems();
		for (int i = 0; i < inventory.getNumRows(); i++){
			for (int j = 0; j < inventory.getNumColumns(); j++){
				if (item.getId() == items[i][j].getId()){
					inventory.getItem(i, j).increaseNumber();
					item.dispose(inventory);
				}
			}
		}
	}
}