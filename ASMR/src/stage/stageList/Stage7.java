package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage7 extends StageObject implements StageInterface
{
	int arrayAmount = 3;
	
	public Stage7()
	{
		super.setDescription(
				"input에 들어온 값의 3배를 출력하세요!\n\n"
				+ "ex) 4 6 7 -> 12 18 21\n"
				+ "\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_ADD +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add(Integer.toString(Integer.parseInt(input.get(0))*3));
		output.add(Integer.toString(Integer.parseInt(input.get(1))*3));
		output.add(Integer.toString(Integer.parseInt(input.get(2))*3));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=2; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(20)-5;
			input.add(Integer.toString(randTemp));
		}
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		return arrayVar;
	}
}
