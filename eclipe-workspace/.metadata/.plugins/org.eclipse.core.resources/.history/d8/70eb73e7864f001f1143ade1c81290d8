package order.internal;

public class Order {

	private static long sequence = 0;
	private Long id;
	private Long itemId;
	private int quantity;

	public Order(Long itemId, Long qty) {
		this.id = Order.sequence++;
		this.itemId = itemId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
