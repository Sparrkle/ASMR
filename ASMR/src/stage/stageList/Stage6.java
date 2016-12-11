package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage6 extends StageObject implements StageInterface
{
	int arrayAmount = 6;
	
	public Stage6()
	{
		super.setDescription(
				"input에 들어온 값중에 0이 아닌 값만 출력하세요!\n\n"
				+ "*새로운 명령어를 배웠습니다.\n"
				+ "ifCpu [o] [n] [l] - Cpu의 값과 [n]번째 방의 값을 [o]로 비교해서\n"
				+ "조건이 맞으면 [l] 라인으로 이동하고, 아니면 ifCpu의 다음\n"
				+ "라인으로 이동합니다.\n"
				+ "[o]는 클릭하면 바뀝니다.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_ADD +
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
			if(Integer.parseInt(input.get(i)) != 0)
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
			randTemp = randomize.nextInt(9)+1;
			
			if(randTemp%4 == 0 && i<6)
				input.add("0");
			else
				input.add(Integer.toString(randTemp));
		}
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		arrayVar[0] = "0";
		
		return arrayVar;
	}
}
