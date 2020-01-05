package nussbaum.compMethodologyProject;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Formatter;

public class Item 
{
private final BigDecimal weight;
private final String description;
private final static double BASEPRICE = 5.0;
private final static double COSTPERPOUND = 1.5;

public Item(String weight, String desc)
{
	this.weight=new BigDecimal(weight);
	this.description =desc;
}


public String getWeight() {
	return weight.toString();
}





public String getDescription() {
	return description;
}




public BigDecimal calculateWeightCost()
{

return (weight.multiply(new BigDecimal(COSTPERPOUND)) );
}

public String format()
{

return description + " Weight: " + weight.toString() + " lb";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
	Item that = (Item) obj;
	Object[] thatFields = {that.getDescription(),that.getWeight()};
	Object[] thisFields = {this.getDescription(),this.getWeight()};
	return Arrays.equals(thatFields, thisFields);
}



}
