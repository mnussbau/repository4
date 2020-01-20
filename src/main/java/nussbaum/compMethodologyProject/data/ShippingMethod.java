package nussbaum.compMethodologyProject.data;

import java.math.BigDecimal;

public enum ShippingMethod {
	STANDARD, EXPEDITED, OVERNIGHT;
	
	public BigDecimal getBasePrice() {
		switch(this) {
		case STANDARD:
			return new BigDecimal("5");
		case EXPEDITED:
			return new BigDecimal("10");
		case OVERNIGHT:
			return new BigDecimal("15");
		}
		throw new RuntimeException();
	}
}
