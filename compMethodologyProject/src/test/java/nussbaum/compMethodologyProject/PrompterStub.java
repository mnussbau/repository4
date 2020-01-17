package nussbaum.compMethodologyProject;

public class PrompterStub implements Prompter {
	
	private final String[] values;
	private int nextIndex;
	
	public  PrompterStub(String[] values) {
		this.values = values;
	}

	@Override
	public String promptForString(String string) {
	
		return values[nextIndex++];
	}

	@Override
	public int promptForInt(String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void println(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String promptForStringNext(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nextLine() {
		// TODO Auto-generated method stub
		return null;
	}
	

 
}
