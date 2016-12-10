package stage.stageList;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage1 extends StageObject implements StageInterface
{
	public Stage1()
	{
		super.setDescription(
				"Å×½ºÆ®\n"
				+ "1\n"
				+ "2\n"
				+ "3\n"
		);
		super.setArrayAmount(12);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(true);
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
