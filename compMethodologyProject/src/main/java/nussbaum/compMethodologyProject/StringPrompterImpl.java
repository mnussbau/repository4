package nussbaum.compMethodologyProject;

import java.util.Scanner;

public class StringPrompterImpl implements StringPrompter{

	@Override
	public String promptUser(String prompt) {
		Scanner scan = new Scanner(System.in);
		System.out.println(prompt);
		return scan.nextLine();
	}
	

}
