package nussbaum.compMethodologyProject;

import java.util.Formatter;

public class Item 
{
private double weight;
private String description;
private final static double BASEPRICE = 5.0;
private final static double COSTPERPOUND = 1.5;

public Item(double weight, String desc)
{
	this.weight=weight;
	this.description =desc;
}


public double getWeight() {
	return weight;
}


public void setWeight(double weight) {
	this.weight = weight;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}

public double calculateWeightCost()
{
	if(weight> 50)
	{
		throw new OverweightException("Your Package Exceeds the weight limit");
	}
	return (weight * COSTPERPOUND) + BASEPRICE;
}

public Formatter format()
{
Formatter formatter = new Formatter();
return formatter.format(description + " Weight: " + "%.2f", weight + " lb");
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	long temp;
	temp = Double.doubleToLongBits(weight);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
		return false;
	return true;
}

}
