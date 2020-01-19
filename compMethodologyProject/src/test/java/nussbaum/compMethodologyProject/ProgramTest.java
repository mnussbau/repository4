package nussbaum.compMethodologyProject;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
public class ProgramTest 
{
	
	private Prompter prompter;
	
	@Before
	public void setup()
	{	
		 prompter = Mockito.mock(Prompter.class);
	}

	@Test
	public void testOptionOne()
	{
		
		
	  	ShipmentForm sf = new ShipmentForm(prompter);
		ItemForm iF= new ItemForm(prompter);
	  	
	  	Program program = Mockito.spy( new Program(prompter, sf, iF));
	  	
	  	Mockito.when(prompter.promptForInt(Mockito.anyString())).thenReturn(1,4);
	  	
	  	Mockito.doNothing().when(program).createShipment();
	  	
	 	program.showMenu();
		
	 	Mockito.verify(program, times(1)).createShipment();
	 	
	 	Mockito.verify(prompter).println("\nThank you for using our service!");
		
	}
	
	
	@Test
	public void testOptionTwo()
	{
		
		
	  	ShipmentForm sf = new ShipmentForm(prompter);
		ItemForm iF= new ItemForm(prompter);
	  	
	  	Program program = Mockito.spy( new Program(prompter, sf, iF));
	  	
	  	Mockito.when(prompter.promptForInt(Mockito.anyString())).thenReturn(2,4);
	  	
	  	Mockito.doNothing().when(program).addItem();
	  	
	 	program.showMenu();
		
	 	Mockito.verify(program, times(1)).addItem();
	 		
	 	Mockito.verify(prompter).println("\nThank you for using our service!");

	}
	
	
	@Test
	public void testOptionThree()
	{
		
		
	  	ShipmentForm sf = new ShipmentForm(prompter);
		ItemForm iF= new ItemForm(prompter);
	  	
	  	Program program = Mockito.spy( new Program(prompter, sf, iF));
	  	
	  	Mockito.when(prompter.promptForInt(Mockito.anyString())).thenReturn(3,4);
	  	
	  	Mockito.doNothing().when(program).completeShipment();
	  	
	 	program.showMenu();
		
	 	Mockito.verify(program, times(1)).completeShipment();
		
	 	Mockito.verify(prompter).println("\nThank you for using our service!");

	}
	
}