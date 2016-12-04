package stage;
import stage.StageInterface;
import lib.variable.VariableManager;

public class Stage1 implements StageInterface
{
	private String description =
			"Å×½ºÆ®"
			+ "1"
			+ "2"
			+ "3";
	private int arrayAmount = 1;
	private int availableCommand = 0;
	private boolean availablePointer = false;
	
	public String getDescription()
	{
		return description;
	}
	public int getArrayAmount()
	{
		return arrayAmount;
	}
	public int getAvailableCommand()
	{
		return availableCommand;
	}
	public boolean getAvailablePointer()
	{
		return availablePointer;
	}
	public int[] getOutputToInput(int[] input)
	{
		input[0] += 10;
		return input;
	}
	public void setInput()
	{
		
	}
}
