package nussbaum.compMethodologyProject;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class Shipment 
{
	
private List <Item> items;
private Customer to;
private final Customer from;
private ShippingMethod shippingMethod;
private localDate date;
private final static double COSTPERPOUND = 1.5;
private final static double STANDARDBASEPRICE = 5.0;
private final static double EXPEDITEDBASEPRICE = 10.0;
private final static double OVERNIGHTBASEPRICE = 15.0;

public Shipment(Customer to, Customer from,  String service)
{
	this.to = to;
	this.from=from;
	this.shippingMethod=ShippingMethod.valueOf(service);
	items= new ArrayList<Item>();
}
public Shipment(Customer to, Customer from)
{
	this.to = to;
	this.from=from;
	
	items= new ArrayList<Item>();
}

public void setlocalDate(localDate ld) {
	this.date = ld;
}

public void addPackage(Item p)
{
	items.add(p);	
}
public LocalDate getEstimatedDeliveryDate() 
{
	LocalDate today = date.getCurrentDate();
	
	
	if(shippingMethod.equals(ShippingMethod.STANDARD))
	{
		return today.plusDays(7); 
	}
	
	else if (shippingMethod.equals(ShippingMethod.EXPEDITED))
	{
		return today.plusDays(5); 
	}
	
	else 
	{
		return  today.plusDays(1); 
	}
	
	

}

public String generateTrackingNumber()
{
 
String numbers = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
 int length=13;
 
 StringBuilder sb = new StringBuilder(length);
      for (int i = 0; i < length; i++)
      {

          int index   = (int)(numbers.length() * Math.random());
          sb.append(numbers .charAt(index));
      }

      return sb.toString();
	  

public BigDecimal calculateTotalWeightCost()
{
	BigDecimal sum = new BigDecimal(0.0);
	for(Item p : items)
	{
	 sum= sum.add(p.calculateWeightCost());
	}
	
	return sum;
}
public List<Item> getItems()
{
	List<Item> itemsCopy = new ArrayList<Item>(items.size());
	for(Item i : items)
	{
		itemsCopy.add(new Item(i.getWeight(), i.getDescription()));
	}
	
	return itemsCopy;
}

public String getFromAddress() {

	return from.getAddress().toString();
}
public String getToAddress() {

	return to.getAddress().toString();
}



public void setServiceType(String serviceType) {
	this.shippingMethod = ShippingMethod.valueOf(serviceType);
	
}

public String displayReceipt()
{
StringBuilder sb = new StringBuilder();
sb.append("Sender's Address:" + from.getAddress());
sb.append("\nRecepient's Address:" + to.getAddress());
sb.append("\n_________________________________________________________________________________________________");
sb.append("\nItems in shipment:\n");
for(Item i: items)
{
	sb.append(i.getDescription() + " Cost:" + i.calculateWeightCost() + "\n");
}
sb.append("-----------------------------");
sb.append("\nTotal Cost: " + calculateTotalWeightCost());
sb.append("\nEstimated Delivery Date - On or Before: " + getEstimatedDeliveryDate());
sb.append("\nTracking Number: " + generateTrackingNumber());
sb.append("\n\nThank you for using our service!");


return sb.toString();
}

}
