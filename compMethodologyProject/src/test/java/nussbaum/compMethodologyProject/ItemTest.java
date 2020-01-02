package nussbaum.compMethodologyProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class ItemTest {
	
	
	@Test
	public void calculateWeighttest() {
		Item item = new Item(4.0, "Iron");
		
		double weight = 6.0;
		assertEquals(weight, item.calculateWeightCost(), 0);
	 	
	}

	@Test
	public void calculateWeightTest() {
		Item item = new Item(51.0, "Iron");
		
		try {
			item.calculateWeightCost();
			fail("Expected Overweight Exception");
		}
		catch(OverweightException e){
			
		}
	}
}
