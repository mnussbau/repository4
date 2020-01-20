package nussbaum.compMethodologyProject.io;

import java.util.Scanner;

public class PrompterImpl implements Prompter {

	private final Scanner scanner = new Scanner(System.in);

	public String promptForString(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}

	public String promptForStringNext(String prompt) {
		System.out.println(prompt);
		return scanner.next();
	}

	public void println(String message) {
		System.out.println(message);

	}

	public int promptForInt(String message) {
		return scanner.nextInt();

	}

	public String next() {
		return scanner.next();
	}

	public String nextLine() {
		return scanner.nextLine();
	}

}
