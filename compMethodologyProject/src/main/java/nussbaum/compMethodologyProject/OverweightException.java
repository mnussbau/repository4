package nussbaum.compMethodologyProject;

public class OverweightException extends RuntimeException 
{
public OverweightException(String s)
{
	super("Your package exceeds the weight limit");
}
}
