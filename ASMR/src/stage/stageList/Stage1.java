package stage.stageList;

import stage.StageObject;
import stage.StageInterface;
import lib.variable.VariableManager;

public class Stage1 extends StageObject implements StageInterface
{
	public Stage1()
	{
		super.setDescription(
				"Å×½ºÆ®"
				+ "1"
				+ "2"
				+ "3"
		);
		super.setArrayAmount(1);
		super.setAvailableCommand(0);
		super.setAvailablePointer(false);
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
