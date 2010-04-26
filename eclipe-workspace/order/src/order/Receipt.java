package order;

public class Receipt {
	private Long orderId;
	private double price;

	public Receipt(Long orderId, double price) {
		this.orderId = orderId;
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
