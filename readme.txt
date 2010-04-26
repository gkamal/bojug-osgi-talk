
This is a simple application to demonstrates OSGI concepts.
To try it out load the directory named eclipse-worspace into eclipse.
This has three projects
    inventory
    order
    BatchProcessor

The inventory module exposes a service to find the price / availability of an item and to mark it as sold.
The order module exposes a service to place an order. It in turn uses the service exposed by the inventory module.
The BatchProcessor looks for a file with orders in a background thread and processes those by using the order service.

To run it select the BatchProcessor and Run As -> OSGI framework.  This will deploy all the three modules.  
Create a file orders.txt in the home directory.  The file should contain one line per order. Each line should have two 
comma separated fields - first field is the item id and the second the quantity.  
eg.,
1,5 


