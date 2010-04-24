package batchprocessor.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class ProcessOrders implements Runnable {

	private static final String FILE_LOC = "/home/kamal/Desktop/orders.txt";
	
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
			System.out.println("File found - processing it");
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(file)));
				
				while(true) {
					String line = reader.readLine();
					if (line == null) break;
					String[] fields = line.split(",");
					Long itemId = Long.parseLong(fields[0]); 
					Long qty = Long.parseLong(fields[1]);
					
					System.out.println("Place Order for " + itemId + " " + qty );
					processOrder(itemId,qty);
				}
			} catch (Exception e) {
				System.out.println("Exception processing file ");
			}
			file.delete();
		} else {
			System.out.println("File doesn't exists");
		}
	}

	private void processOrder(Long itemId, Long qty) {
		// TODO invoke order service
		
	}

}
