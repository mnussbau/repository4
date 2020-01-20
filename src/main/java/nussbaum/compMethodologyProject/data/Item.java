package nussbaum.compMethodologyProject.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Item {
	private final BigDecimal weight;
	private final String description;
	private final BigDecimal costPerPound;

	public Item(String desc, String weight) {
		this.description = desc;
		this.weight = new BigDecimal(weight);
		this.costPerPound = new BigDecimal("1.5");
	}

	public String getWeight() {
		return weight.toString();
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal calculateWeightCost() {
		return weight.multiply(costPerPound);
	}

	public String format() {
		return description + " Weight: " + weight + " lb";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Item that = (Item) obj;
		Object[] thatFields = { that.getDescription(), that.getWeight() };
		Object[] thisFields = { this.getDescription(), this.getWeight() };
		return Arrays.equals(thatFields, thisFields);
	}

}
