package order.internal;

import inventory.InventoryService;

import java.util.HashMap;
import java.util.Map;

import order.OrderService;
import order.Receipt;

public class OrderServiceImpl implements OrderService {

	Map<Long,Order> orders = new HashMap<Long, Order>();
	private InventoryService inventoryService;
	
	public OrderServiceImpl(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@Override
	public void cancelOrder(Long orderId) {
		Order order = orders.remove(orderId);
		inventoryService.returned(order.getItemId(),order.getQuantity());
	}

	@Override
	public Receipt placeOrder(Long itemId, int qty) {
		Order order = new Order(itemId,qty);
		orders.put(order.getId(),order);
		double price = inventoryService.getPrice(itemId)*qty;
		inventoryService.sold(itemId, qty);
		
		return new Receipt(order.getId(),price);
	}

}
