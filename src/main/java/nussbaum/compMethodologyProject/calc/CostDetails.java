package nussbaum.compMethodologyProject.calc;

import java.math.BigDecimal;

public class CostDetails {

	private final BigDecimal baseCost;
	private final BigDecimal distanceCost;
	private final BigDecimal weightCost;
	private final BigDecimal totalCost;
	
	public CostDetails(BigDecimal baseCost, BigDecimal distanceCost, BigDecimal weightCost, BigDecimal totalCost) {
		this.baseCost = baseCost;
		this.distanceCost = distanceCost;
		this.weightCost = weightCost;
		this.totalCost = totalCost;
	}

	public BigDecimal getBaseCost() {
		return baseCost;
	}

	public BigDecimal getDistanceCost() {
		return distanceCost;
	}

	public BigDecimal getWeightCost() {
		return weightCost;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

}
