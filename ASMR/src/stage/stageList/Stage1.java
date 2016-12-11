package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage1 extends StageObject implements StageInterface
{
	int arrayAmount = 0;
	
	public Stage1()
	{
		super.setDescription(
				"ASM게임에 오신것을 환영합니다. 이 게임은 코드를 이용하여\n"
				+ "이 게임은 코드를 이용하여 퍼즐을 해결하는 게임입니다.\n"
				+ "우측의 scanData와 printData 코드를 드래그 하고 Code Window에\n"
				+ "붙여넣어 보세요. 그다음, 오른쪽 하단의 재생 버튼을 눌러보세요!\n"
				+ "*새로운 명령어를 배웠습니다.\n"
				+ "scanData - Input의 첫번째 값을 가져와서 cpu에 저장합니다.\n"
				+ "printData - cpu의 첫번째 값을 output에 보냅니다.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add(input.get(0));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		int randTemp;
		randTemp = randomize.nextInt(9)+1;
			
		input.add(Integer.toString(randTemp));
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		return arrayVar;
	}
}
