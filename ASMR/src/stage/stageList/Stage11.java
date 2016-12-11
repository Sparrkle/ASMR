package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage11 extends StageObject implements StageInterface
{
	int arrayAmount = 3;
	
	public Stage11()
	{
		super.setDescription(
				"input에 들어온 값을 받아 0이 될때까지 output에 보내세요!\n"
				+ "ex) 4 2 -> 4 3 2 1 0 2 1 0\n\n"
				+ "*새로운 명령어를 얻었습니다.\n"
				+ "inc [n] - [n]번째 방의 값을 1 증가시킵니다.\n"
				+ "dec [n] - [n]번째 방의 값을 1 감소시킵니다.\n"
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
				CodeConstants.CODE_INC +
				CodeConstants.CODE_DEC +
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
			for(int j=Integer.parseInt(input.get(i)); j>=0; j--)
			{
				output.add(Integer.toString(j));
			}
		}
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=1; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(4)+1;
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
