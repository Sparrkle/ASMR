package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage5 extends StageObject implements StageInterface
{
	int arrayAmount = 4;
	
	public Stage5()
	{
		super.setDescription(
				"input에 들어온 값을 2개씩 더해서 output에 출력하세요!\n"
				+ "ex) 4 6 2 4 -> 10 6\n"
				+ "*새로운 명령어를 배웠습니다.\n"
				+ "\n"
				+ "Add [n] - [n]번째 방에 있는 값과 Cpu의 값을 더한 값을\n"
				+ "Cpu에 저장합니다.\n"
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
		
		output.add(Integer.toString(Integer.parseInt(input.get(0)) + Integer.parseInt(input.get(1))));
		output.add(Integer.toString(Integer.parseInt(input.get(2)) + Integer.parseInt(input.get(3))));
		output.add(Integer.toString(Integer.parseInt(input.get(4)) + Integer.parseInt(input.get(5))));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=5; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(9)+1;
			
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
