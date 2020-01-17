package nussbaum.compMethodologyProject;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

public class Shipment {

	private List<Item> items;
	private Customer to;
	private final Customer from;
	private ShippingMethod shippingMethod;
	private LocalDateInterface date;
	private BigDecimal costPerMile;
	private final double STANDARDBASEPRICE = 5.0;
	private final double EXPEDITEDBASEPRICE = 10.0;
	private final double OVERNIGHTBASEPRICE = 15.0;
	private DistanceApi distanceCalculator;
	private String trackingNumber;
	private Prompter prompter;

	public Shipment(Customer from, Customer to, String shippingMethod) {
		this.from = from;
		this.to = to;
		this.shippingMethod = ShippingMethod.valueOf(shippingMethod);
		items = new ArrayList<Item>();
		costPerMile = new BigDecimal(2.5);
		distanceCalculator = new DistanceApi(to.getAddress().getZipCode(), from.getAddress().getZipCode());
		trackingNumber = generateTrackingNumber();
		prompter = new PrompterImpl();
		date = new LocalDateImpl();
	}

	public void addItem(String trackingNum, Item i) {
		if (trackingNumber.equals(trackingNum)) {
			items.add(i);
			prompter.println("Item Added to Shipment");
		}

		else {
			prompter.println("Invalid Tracking Number");
		}
	}

	public LocalDate getEstimatedDeliveryDate() {
		LocalDate today = date.getCurrentDate();

		if (shippingMethod.equals(ShippingMethod.STANDARD)) {
			return today.plusDays(7);
		}

		else if (shippingMethod.equals(ShippingMethod.EXPEDITED)) {
			return today.plusDays(5);
		}

		else {
			return today.plusDays(1);
		}

	}


	public String generateTrackingNumber() {

		String numbers = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		int length = 13;

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {

			int index = (int) (numbers.length() * Math.random());
			sb.append(numbers.charAt(index));
		}

		return sb.toString();

	}

	public BigDecimal calculateTotalWeightCost() {
		BigDecimal sum = new BigDecimal(0.0);
		for (Item i : items) {
			sum = sum.add(i.calculateWeightCost());
		}

		return sum;
	}

	public BigDecimal calculateTotalDistanceCost() {
		BigDecimal distance = new BigDecimal(0.0);
		distance = distanceCalculator.calculateDistance();

		return distance.multiply(costPerMile);
	}

	public BigDecimal getTotalShipmentCost() {
		BigDecimal distanceCost = calculateTotalDistanceCost();
		BigDecimal weightCost = calculateTotalWeightCost();

		if (shippingMethod.equals(ShippingMethod.STANDARD)) {
			return distanceCost.add(weightCost).add(new BigDecimal(STANDARDBASEPRICE));
		}

		else if (shippingMethod.equals(ShippingMethod.EXPEDITED)) {
			return distanceCost.add(weightCost).add(new BigDecimal(EXPEDITEDBASEPRICE));
		}

		else {
			return distanceCost.add(weightCost).add(new BigDecimal(OVERNIGHTBASEPRICE));

		}

	}

	public List<Item> getItems() {
		List<Item> itemsCopy = new ArrayList<Item>(items.size());
		for (Item i : items) {
			itemsCopy.add(new Item(i.getDescription(), i.getWeight()));
		}

		return itemsCopy;
	}

	public void setlocalDate(LocalDateInterface ld) {
		this.date = ld;
	}

	public String getFromAddress() {

		return from.getAddress().toString();
	}

	public String getToAddress() {

		return to.getAddress().toString();
	}

	public String getTofirstName() {
		return to.getFirstName();
	}

	public String getTolastName() {
		return to.getLastName();
	}

	public String getFromlastName() {
		return from.getLastName();
	}

	public String getFromfirstName() {
		return from.getFirstName();
	}

	public String getFromPhoneNumber() {
		return from.getPhoneNumber();
	}

	public String getToPhoneNumber() {
		return to.getPhoneNumber();
	}

	public void setServiceType(String serviceType) {
		this.shippingMethod = ShippingMethod.valueOf(serviceType);

	}

	public  double getStandardbaseprice() {
		return STANDARDBASEPRICE;
	}

	public String getShippingMethod() {
		return shippingMethod.toString();
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public double getExpeditedbaseprice() {
		return EXPEDITEDBASEPRICE;
	}

	public  double getOvernightbaseprice() {
		return OVERNIGHTBASEPRICE;
	}
	
	public String getTrackingNumber() {
		return trackingNumber;
	}
}
