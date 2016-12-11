package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage2 extends StageObject implements StageInterface
{
	int arrayAmount = 0;
	
	public Stage2()
	{
		super.setDescription(
				"input에 들어온 값을 모두 차례대로 output에 보내세요!\n"
				+ "코드를 삭제할려면 코드를 클릭 한 뒤, 우클릭을 하면 됩니다.\n\n"
				+ "*새로운 명령어를 배웠습니다.\n"
				+ "Jump [n] - Jump 명령어는 무조건 [n]번 라인으로 이동합니다.\n"
				+ "[n]을 클릭하고 라인을 클릭하면 n의 값이 바뀝니다.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		for(int i=0; i<input.size(); i++)
			output.add(input.get(i));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=4; i++)
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
