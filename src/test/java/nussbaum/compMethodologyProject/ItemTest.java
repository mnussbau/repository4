package nussbaum.compMethodologyProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import nussbaum.compMethodologyProject.data.Item;

public class ItemTest {

	private Item item;

	@Before
	public void setUp() {
		item = new Item("Iron", "4.0");
	}

	@Test
	public void calculateWeightTest() {
		String string = "6.00";
		BigDecimal weight = new BigDecimal(string);
		assertEquals(weight, item.calculateWeightCost());
	}

	@Test
	public void testEquals() {
		Item item2 = new Item("Iron", "4.0");
		assertTrue(item.equals(item2));
	}

	@Test
	public void testNotEquals() {
		Item item2 = new Item("Toy", "4.0");
		assertFalse(item.equals(item2));

	}

}