package batchprocessor.internal;

import order.OrderService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference orderServiceReference;
	Thread processOrdersThread;

	public void start(BundleContext context) throws Exception {
		orderServiceReference = context.getServiceReference(OrderService.class.getName());
		OrderService orderService = (OrderService) context.getService(orderServiceReference);
		System.out.println("Batch processing started");
		processOrdersThread = new Thread(new ProcessOrders(orderService));
		processOrdersThread.start();
		
	}

	public void stop(BundleContext context) throws Exception {
		processOrdersThread.interrupt();
		processOrdersThread.join();
		System.out.println("Batch processing stoped");
	}

}
