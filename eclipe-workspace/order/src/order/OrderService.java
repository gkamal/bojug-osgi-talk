package order;

public interface OrderService {
	Receipt placeOrder(Long itemId,int qty);
	void cancelOrder(Long orderId);
}
