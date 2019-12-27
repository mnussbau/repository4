package nussbaum.compMethodologyProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class Shipment 
{
	
private ArrayList <Item> items;
private Address to;
private Address from;
private int serviceType;
private localDate date;


public Shipment(Address to, Address from, int service)
{
	this.to = to;
	this.from=from;
	this.serviceType=service;
	items= new ArrayList<Item>();
}
public Shipment(Address to, Address from)
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
	
	
	if(serviceType==1)
	{
		return today.plusDays(7); 
	}
	
	else if (serviceType==2)
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
	  String numbers = "0123456789";
	  
	  int length=20;
	  
	  StringBuilder sb = new StringBuilder(length);
      for (int i = 0; i < length; i++) 
      { 

          int index   = (int)(numbers.length() * Math.random()); 
          sb.append(numbers .charAt(index)); 
      } 

      return sb.toString(); 
  } 
	  

public double calculateTotalWeightCost()
{
	double sum = 0.0;
	for(Item p : items)
	{
		sum += p.calculateWeightCost();
	}
	
	return sum;
}
public ArrayList<Item> getItems()
{
	ArrayList<Item> itemsCopy = new ArrayList<Item>(items.size());
	for(Item i : items)
	{
		itemsCopy.add(new Item(i.getWeight(), i.getDescription()));
	}
	
	return itemsCopy;
}

public Formatter getFromAddress() {

	return from.format();
}
public Formatter getToAddress() {

	return to.format();
}

public void setServiceType(int serviceType) {
	this.serviceType = serviceType;
	
}
}
