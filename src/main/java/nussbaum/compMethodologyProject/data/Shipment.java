package nussbaum.compMethodologyProject.data;

import java.util.ArrayList;
import java.util.List;

import nussbaum.compMethodologyProject.calc.TrackingNumberGenerator;

public class Shipment {

	private final Customer fromCustomer;
	private final Customer toCustomer;
	private final String trackingNumber;
	private final List<Item> items;
	
	private ShippingMethod shippingMethod;

	public Shipment(Customer fromCustomer, Customer toCustomer, String shippingMethod) {
		this.fromCustomer = fromCustomer;
		this.toCustomer = toCustomer;
		this.shippingMethod = ShippingMethod.valueOf(shippingMethod);
		this.trackingNumber = TrackingNumberGenerator.generateTrackingNumber();
		this.items = new ArrayList<>();
	}

	public void addItem(Item i) {
		items.add(i);
	}

	public List<Item> getItems() {
		List<Item> itemsCopy = new ArrayList<>(items.size());
		for (Item i : items) {
			itemsCopy.add(new Item(i.getDescription(), i.getWeight()));
		}

		return itemsCopy;
	}

	public Address getFromAddress() {
		return fromCustomer.getAddress();
	}

	public Address getToAddress() {
		return toCustomer.getAddress();
	}

	public String getTofirstName() {
		return toCustomer.getFirstName();
	}

	public String getToLastName() {
		return toCustomer.getLastName();
	}

	public String getFromLastName() {
		return fromCustomer.getLastName();
	}

	public String getFromFirstName() {
		return fromCustomer.getFirstName();
	}

	public String getFromPhoneNumber() {
		return fromCustomer.getPhoneNumber();
	}

	public String getToPhoneNumber() {
		return toCustomer.getPhoneNumber();
	}

	public void setShippingMethod(String serviceType) {
		setShippingMethod(ShippingMethod.valueOf(serviceType));
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

}
