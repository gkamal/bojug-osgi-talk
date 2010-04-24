package inventory.internal;


public class Item {
	private Long id;
	private String name;
	private int quantity;
	private double price;

	public Item(Long id, String name, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void sold(int quatity) {
		this.quantity -= quatity;		
	}

	public void procured(int quatity) {
		this.quantity += quatity;
	}

	public void returned(int quantity) {
		this.quantity += quantity;
	}

}