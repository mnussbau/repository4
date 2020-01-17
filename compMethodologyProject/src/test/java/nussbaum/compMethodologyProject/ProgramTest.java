package nussbaum.compMethodologyProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProgramTest {

private Prompter prompter;
	
	@Before
	public void setup()
	{
		
		 prompter = Mockito.mock(Prompter.class);
	
	}

	@Test
	public void testOptionOne()
	{
		
		//AddressForm af = new AddressForm(prompter);
		//CustomerForm cf = new CustomerForm(prompter);
	//	ShipmentForm sf = new ShipmentForm(prompter);
		//ItemForm iF= new ItemForm(prompter);
	
		
		
		
		
	//Mockito.when(prompter.promptForStringNext(Mockito.eq("Enter Sender's address"), Mockito.any(ShipmentForm.class)))
	//	.thenReturn();
		
		
		
		
		
	  	Mockito.when(prompter.promptForInt(Mockito.anyString())).thenReturn(1,3);
	  	ShipmentForm sf = new ShipmentForm(prompter);
		ItemForm iF= new ItemForm(prompter);
	  	
	  	Program program = new Program(prompter, sf, iF);
	 	
	 	program.showMenu();
		
		Mockito.verify(prompter).promptForStringNext(Mockito.eq("Enter Sender's address"), Mockito.any(ShipmentForm.class)
	 	//Mockito.verify(prompter).println("Enter Sender's address");
		
	}
	
	
	@Test
	public void testOptionTwo()
	{
		
			

		
	}
	
	
	@Test
	public void testOptionThree()
	{
		
		
		
		
	}

}
