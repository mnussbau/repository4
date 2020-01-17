package nussbaum.compMethodologyProject;

public interface Prompter {
	void println(String message);
	String promptForString(String string);
	int promptForInt(String message);
	String promptForStringNext (String message);
	String next ();
	String nextLine();
}
