package batchprocessor.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import order.OrderService;
import order.Receipt;


public class ProcessOrders implements Runnable {

	private static final String FILE_LOC = 
			System.getProperty("user.home")
			+ "/orders.txt";
	private OrderService orderService;
	
	public ProcessOrders(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public void run() {
		System.out.println("Processing started");
		while(true) {
			if (Thread.currentThread().isInterrupted()) {
				break;
			}
			
			processFile();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				break;
			}
			
		}
		System.out.println("Processing ended");
	}

	private void processFile() {
		File file = new File(FILE_LOC);
		if (file.exists()) {
			System.out.println("File + " + FILE_LOC + " found - processing it");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(file)));
				
				while(true) {
					String line = reader.readLine();
					if (line == null) break;
					String[] fields = line.split(",");
					Long itemId = Long.parseLong(fields[0]); 
					Integer qty = Integer.parseInt(fields[1]);
					
					System.out.println("Place Order for " + itemId + " " + qty );
					processOrder(itemId,qty);
				}
			} catch (Exception e) {
				System.out.println("Exception processing file ");
			}
			file.delete();
		} else {
			System.out.println("File + " + FILE_LOC + " not found");
		}
	}

	private void processOrder(Long itemId, int qty) {
		Receipt receipt = orderService.placeOrder(itemId, qty);
		System.out.println("Placed order successfully - order id " + receipt.getOrderId() + " total price " + receipt.getPrice());
	}

}
