package nussbaum.compMethodologyProject;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import nussbaum.compMethodologyProject.data.Address;
import nussbaum.compMethodologyProject.data.Customer;
import nussbaum.compMethodologyProject.data.Item;
import nussbaum.compMethodologyProject.data.Shipment;

public class ShipmentTest {

	@Parameters
	public static Collection<Object[]> data() {
		LocalDate ld = LocalDate.of(2010, 12, 8);
		LocalDate ld2 = LocalDate.of(2010, 12, 6);
		LocalDate ld3 = LocalDate.of(2010, 12, 2);
		BigDecimal cost1 = new BigDecimal("39.50");
		BigDecimal cost2 = new BigDecimal("44.50");
		BigDecimal cost3 = new BigDecimal("49.50");

		return Arrays.asList(
				new Object[][] { { "STANDARD", ld, cost1 }, { "EXPEDITED", ld2, cost2 }, { "OVERNIGHT", ld3, cost3 } });
	}

	@Parameter(0)
	public String shippingMethod;
	@Parameter(1)
	public LocalDate expectedDate;
	@Parameter(2)
	public BigDecimal expectedCost;

	public Customer cust1;
	public Customer cust2;
	public Address address1;
	public Address address2;
	public Shipment shipment;
	public Item item1;
	public Item item2;
	public List<Item> expected;

	@Before

	public void setup() {

		address1 = new Address("1111 east 1st street", "Brooklyn", "NEWYORK", "11210");
		address2 = new Address("1111 east 1st street", "Brooklyn", "NEWYORK", "11219");
		cust1 = new Customer("Joe", "Shmoe", "1112223333", address1);
		cust2 = new Customer("Mary", "Jane", "1234567891", address2);
		shipment = new Shipment(cust1, cust2, shippingMethod);
		item1 = new Item("Doll", "5.0");
		item2 = new Item("Toy", "3.0");

	}

	@Test
	public void addPackage() {
		String trackingNum = shipment.getTrackingNumber();
		List<Item> expected = new ArrayList<Item>();
		expected.add(new Item("Doll", "5.0"));
		expected.add(new Item("Toy", "3.0"));
		shipment.addItem(trackingNum, item1);
		shipment.addItem(trackingNum, item2);
		assertArrayEquals(expected.toArray(), shipment.getItems().toArray());

	}

	@Test
	public void testCalculateTotalWeightCost() {
		String trackingNum = shipment.getTrackingNumber();
		shipment.addItem(trackingNum, item1);
		shipment.addItem(trackingNum, item2);
		String string = "12.00";
		BigDecimal weightCost = new BigDecimal(string);
		assertEquals(weightCost, shipment.calculateTotalWeightCost());
	}

	@Test
	public void testGetItems() {
		String trackingNum = shipment.getTrackingNumber();
		List<Item> expected = new ArrayList<Item>();
		expected.add(new Item("Doll", "5.0"));
		expected.add(new Item("Toy", "3.0"));
		shipment.addItem(trackingNum, item1);
		shipment.addItem(trackingNum, item2);
		assertArrayEquals(expected.toArray(), shipment.getItems().toArray());
	}

	@Test
	public void testCalculateTotalDistanceCost() {
		String string = "22.5";
		BigDecimal distanceCost = new BigDecimal(string);
		assertEquals(distanceCost, shipment.calculateTotalDistanceCost());
	}

	@Test
	public void testTotalShipmentCost() {
		String trackingNum = shipment.getTrackingNumber();
		shipment.addItem(trackingNum, item1);
		shipment.addItem(trackingNum, item2);
		BigDecimal actualTotalShipmentCost = shipment.getTotalShipmentCost();
		assertEquals(expectedCost, actualTotalShipmentCost);
	}

	@Test
	public void estimatedDeliveryDate() {

		shipment = new Shipment(cust1, cust2, shippingMethod);
		LocalDateInterface clock = new StubLocalDate(LocalDate.of(2010, 12, 1));
		shipment.setlocalDate(clock);
		LocalDate actual = shipment.getEstimatedDeliveryDate();
		assertEquals(expectedDate, actual);

	}

}
