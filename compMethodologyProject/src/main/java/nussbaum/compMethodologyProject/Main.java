package nussbaum.compMethodologyProject;

public class Main {
	public static void main(String[] args) {
		Prompter prompter = new PrompterImpl();
		
		ShipmentForm sf = new ShipmentForm(prompter);
		ItemForm iF = new ItemForm(prompter);

		Program program = new Program(prompter,sf,iF);
		program.showMenu();

	}

	
}
