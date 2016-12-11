package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage8 extends StageObject implements StageInterface
{
	int arrayAmount = 5;
	
	public Stage8()
	{
		super.setDescription(
				"input에 들어온 값의 40배를 출력하세요!\n\n"
				+ "ex) -1 0 3 -> -40 0 120\n"
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
		
		output.add(Integer.toString(Integer.parseInt(input.get(0))*40));
		output.add(Integer.toString(Integer.parseInt(input.get(1))*40));
		output.add(Integer.toString(Integer.parseInt(input.get(2))*40));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=2; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(8)-4;
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
