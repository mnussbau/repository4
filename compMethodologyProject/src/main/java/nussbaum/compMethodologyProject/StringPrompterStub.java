package nussbaum.compMethodologyProject;

public class StringPrompterStub implements StringPrompter {
	
	private final String[] values;
	private int nextIndex;
	
	public StringPrompterStub(String[] values) {
		this.values = values;
	}
	
	@Override
	public String promptUser(String prompt) {
		return values[nextIndex++];
		
	}
 
}
