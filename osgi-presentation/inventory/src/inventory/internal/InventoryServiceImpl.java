package inventory.internal;

import java.util.HashMap;
import java.util.Map;

import inventory.InventoryService;

public class InventoryServiceImpl implements InventoryService {

	private Map<Long,Item> items = new HashMap<Long, Item>();
	
	{
		addItem(new Item(1l,"Pencils",100,1));
		addItem(new Item(2l,"Pencils",100,1));
	}

	
	@Override
	public int getAvailableQty(Long itemId) {
		return findItem(itemId).getQuantity();
	}

	@Override
	public double getPrice(Long itemId) {
		return findItem(itemId).getPrice();
	}

	@Override
	public void procured(Long itemId, int quatity) {
		findItem(itemId).procured(quatity);
	}
	
	

	@Override
	public void returned(Long itemId, int quantity) {
		findItem(itemId).returned(quantity);
	}

	private Item findItem(Long itemId) {
		return items.get(itemId);
	}
	
	public void sold(Long itemId,int quatity) {
		Item item = findItem(itemId);
		item.sold(quatity);
	}

	private void addItem(Item item) {
		items.put(item.getId(),item);
	}
}
