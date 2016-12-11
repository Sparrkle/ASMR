package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage10 extends StageObject implements StageInterface
{
	int arrayAmount = 4;
	
	public Stage10()
	{
		super.setDescription(
				"input에 들어온 값 중에 음수가 있다면, 양수로 바꾸고\n"
				+ "output에 보내세요!\n"
				+ "ex) 2 3 -4 1 -> 2 3 4 1\n\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_ADD +
				CodeConstants.CODE_SUB +
				CodeConstants.CODE_IFCPU +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		for(int i=0; i<input.size(); i++)
		{
			if(Integer.parseInt(input.get(i)) < 0)
				output.add(Integer.toString(Integer.parseInt(input.get(i))*-1));
			else
				output.add(input.get(i));
		}
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=7; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(11)-4;
			input.add(Integer.toString(randTemp));
		}
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		arrayVar[3] = "0";
		
		return arrayVar;
	}
}
