package stage;

public class StageObject
{
	private String description;
	private int arrayAmount;
	private int availableCommand;
	private boolean availablePointer;

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
	
	public void setDescription(String input)
	{
		description = input;
	}
	public void setArrayAmount(int input)
	{
		arrayAmount = input;
	}
	public void setAvailableCommand(int input)
	{
		availableCommand = input;
	}
	public void setAvailablePointer(boolean input)
	{
		availablePointer = input;
	}
}
