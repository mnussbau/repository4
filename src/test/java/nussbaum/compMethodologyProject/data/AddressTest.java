package nussbaum.compMethodologyProject.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
	private Address address;
	@Before
	public void setup() {
		address = new Address("1904 New York Ave", "Brooklyn", "NEWYORK", "11210");
	}
	
	
	

	@Test
	public void equalsTest() {
		
		Address address2 = new Address("1904 New York Ave", "Brooklyn", "NEWYORK", "11210");
		assertTrue(address2.equals(address));
	}
	@Test
	public void equalsTest2() {
		
		Address address2 = new Address("1905 New York Ave", "Brooklyn", "NEWYORK", "11210");
		assertFalse(address2.equals(address));
	}
	
	@Test
	public void toStringTest() {
		String expected = " Street: 1904 New York Ave City: Brooklyn State: NEWYORK ZipCode: 11210";
		assertEquals(expected, address.toString());
	}
	
	
}
