package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage4 extends StageObject implements StageInterface
{
	int arrayAmount = 6;
	
	public Stage4()
	{
		super.setDescription(
				"MAMAMOO를 출력해보세요!\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add("M");
		output.add("A");
		output.add("M");
		output.add("A");
		output.add("M");
		output.add("O");
		output.add("O");
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		input.add(Integer.toString(-999));
		input.add(Integer.toString(-999));
		input.add(Integer.toString(-999));
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		arrayVar[0] = "M";
		arrayVar[1] = "B";
		arrayVar[2] = "A";
		arrayVar[3] = "H";
		arrayVar[4] = "P";
		arrayVar[5] = "O";
		
		return arrayVar;
	}
}
