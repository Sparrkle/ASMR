package lib.code.instruction;

import lib.code.CodeObject;
import lib.variable.VariableManager;
import lib.variable.exception.InvalidValueException;

public class PrintData extends CodeObject
{
	VariableManager vm;
	
	public PrintData(VariableManager vmInput)
	{
		this.setName("printData");
		vm = vmInput;
	}
	
	@Override
	public void run() throws InvalidValueException
	{
		try
		{
			String temp = vm.getCpu();
			vm.setCpu("");
			vm.depositOutput(temp);
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("오류 ! CPU에 저장된 값이 존재하지 않습니다.");
		}
	}
}
