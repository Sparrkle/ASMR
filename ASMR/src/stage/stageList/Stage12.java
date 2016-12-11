package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage12 extends StageObject implements StageInterface
{
	String[] arrayVar;
	int arrayAmount = 7;
	
	public Stage12()
	{
		super.setDescription(
				"input에 들어온 값의 번호를 가진 방의 문자열을\n"
				+ "output에 출력해주세요!\n"
				+ "ex) 1 4 5 3 -> O R ♥ A\n\n"
				+ "*n번째 방의 값을 가져올 때, n을 마우스 우클릭하면\n"
				+ "대괄호가 쳐지면서 n번째 방의 값의 번호를 가진 방의\n"
				+ "값을 가져올 수 있습니다!\n"
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
		super.setAvailablePointer(true);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		for(int i=0; i<input.size(); i++)
		{
			output.add(arrayVar[Integer.parseInt(input.get(i))]);
		}
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=5; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(6);
			input.add(Integer.toString(randTemp));
		}
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		arrayVar = new String[arrayAmount];
		
		arrayVar[0] = "S";
		arrayVar[1] = "O";
		arrayVar[2] = "L";
		arrayVar[3] = "A";
		arrayVar[4] = "R";
		arrayVar[5] = "♥";
		
		return arrayVar;
	}
}
