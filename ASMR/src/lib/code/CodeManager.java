package lib.code;

import javax.swing.*;

public class CodeManager implements CodeConstants
{
	int programCounter = 0;
	JList<CodeObject> listCode;
	
	public CodeManager(JList<CodeObject> listCodeInput)
	{
		listCode = listCodeInput;
	}
	
	public int getProgramCounter()
	{
		return programCounter;
	}
	
	public void setProgramCounter(int input)
	{
		programCounter = input;
	}
}
