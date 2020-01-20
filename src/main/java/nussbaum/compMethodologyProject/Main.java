package nussbaum.compMethodologyProject;

import nussbaum.compMethodologyProject.calc.CostCalculator;
import nussbaum.compMethodologyProject.calc.DeliveryDateEstimator;
import nussbaum.compMethodologyProject.calc.DeliveryDateEstimatorImpl;
import nussbaum.compMethodologyProject.calc.DistanceCalculator;
import nussbaum.compMethodologyProject.calc.DistanceCalculatorFake;
import nussbaum.compMethodologyProject.form.ItemForm;
import nussbaum.compMethodologyProject.form.ShipmentForm;
import nussbaum.compMethodologyProject.io.Prompter;
import nussbaum.compMethodologyProject.io.PrompterImpl;

public class Main {
	public static void main(String[] args) {
		Prompter prompter = new PrompterImpl();
		
		ShipmentForm shipmentForm = new ShipmentForm(prompter);
		ItemForm itemForm = new ItemForm(prompter);
		DistanceCalculator distanceCalculator = new DistanceCalculatorFake();
		CostCalculator costCalculator = new CostCalculator(distanceCalculator);
		DeliveryDateEstimator deliveryDateEstimator = new DeliveryDateEstimatorImpl();
		ReceiptGenerator receiptGenerator = new ReceiptGenerator(costCalculator, deliveryDateEstimator);
		
		Program program = new Program(prompter, shipmentForm, itemForm, receiptGenerator);
		program.showMenu();

	}

	
}
