package lib.code;

import stage.StageLib;
//import lib.code.*;

public class CodeManager implements CodeConstants
{
	int programCounter = 0;
	
	StageLib stage;
	
	public CodeManager(StageLib stageInput)
	{
		stage = stageInput;
	}
}
