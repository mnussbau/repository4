package nussbaum.compMethodologyProject;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ShipmentTest {
  
	 @Parameters
	    public static Collection<Object[]> data() {
	    	 LocalDate ld = LocalDate.of(2010, 12, 8);
	    	 LocalDate ld2 = LocalDate.of(2010, 12, 6);
	    	 LocalDate ld3 = LocalDate.of(2010, 12, 2);
	        return Arrays.asList(new Object[][] {     
	                 { 1, ld }, { 2, ld2 }, { 3, ld3 } } );
	    }
	    
	    @Parameter(0)
		public int serviceType;
		private  Shipment shipment;
		@Parameter(1)
		public LocalDate expected;
		public Address address;
		
		public Item item1;
		public Item item2;
		
		public ArrayList<Item> items;
		public ArrayList<Item> expectedArray;
		
		@Before
		public void setup() {
			
			Address to = new Address("Malka", "1904 New York Ave", "Brooklyn", "NEWYORK", "11210");
			Address from = new Address("Chayala", "1890 East 2nd", "Brooklyn", "NEWYORK", "11210");
			shipment = new Shipment(to, from, serviceType);
			localDate clock = new StubLocalDate(LocalDate.of(2010,12,1));
			shipment.setlocalDate(clock);
			item1 = new Item(5.0,"Doll");
			item2 = new Item(3.0,"Toy");

			
		}
		
	
	@Test
	public void EstimatedShippingCalculationTest() {
		
		LocalDate actual = shipment.getEstimatedDeliveryDate();
		assertEquals(expected, actual);
		
		
		
	}
	
	@Test
	public void testCalculateTotalWeightCost() 
	{
		shipment.addPackage(item1);
		shipment.addPackage(item2);
		double cost = shipment.calculateTotalWeightCost();
		assertEquals(12.0, cost,0);
	}

	@Test
	public void testGetItems() 
	{
		shipment.addPackage(item1);
		shipment.addPackage(item2);
		ArrayList<Item> expectedArray = new ArrayList<Item>();
		expectedArray.add(new Item(5.0, "Doll"));
		expectedArray.add(new Item(3.0, "Toy"));
		assertArrayEquals(expectedArray.toArray(),shipment.getItems().toArray());
	}

}
