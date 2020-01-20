package nussbaum.compMethodologyProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import nussbaum.compMethodologyProject.data.Item;
import nussbaum.compMethodologyProject.form.ItemForm;
import nussbaum.compMethodologyProject.io.Prompter;

public class ItemFormTest {

	@Test
	public void testEnterItem() {
		
		Prompter prompter  = Mockito.mock(Prompter.class);

		Mockito.when(prompter.promptForString("Please enter a description for your item: ")).thenReturn("Toy");
		Mockito.when(prompter.promptForStringNext("Please enter the weight of the item: ")).thenReturn("5");

		
		ItemForm form = new ItemForm(prompter);
		Item item = form.enterItemMethod();
		assertEquals("Toy", item.getDescription());
		assertEquals("5", item.getWeight());
		
	}
}
