package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage3 extends StageObject implements StageInterface
{
	int arrayAmount = 4;
	
	public Stage3()
	{
		super.setDescription(
				"input에 들어온 값을 2개씩 순서가 바뀌도록 output에 보내세요!\n"
				+ "ex) 4 6 2 4 -> 6 4 4 2\n"
				+ "*새로운 명령어를 배웠습니다.\n"
				+ "Copyto [n] - Cpu가 들고 있는 값을 [n]번째 방에 복사합니다.\n"
				+ "CopyFrom [n] - [n]번째 방에 있는 값을 Cpu에 복사합니다.\n"
				+ "[n]을 클릭하고 CPU 왼쪽에 위치한 방을 클릭하면 \n"
				+ "해당 방을 가리킵니다.\n"
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
		
		output.add(input.get(1));
		output.add(input.get(0));
		output.add(input.get(3));
		output.add(input.get(2));
		output.add(input.get(5));
		output.add(input.get(4));
		
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
