package lib.code.instruction;

import java.util.List;

import lib.code.CodeObject;
import lib.variable.VariableManager;
import lib.variable.exception.InvalidArraySizeException;

public class ScanData extends CodeObject
{
	VariableManager vm;
	
	public ScanData(VariableManager vmInput)
	{
		this.setName("scanData");
		vm = vmInput;
	}
	
	@Override
	public void run() throws InvalidArraySizeException
	{
		try
		{
			String temp = vm.withdrawInput();
			vm.setCpu(temp);
		}
		catch(InvalidArraySizeException iase)
		{
			throw new InvalidArraySizeException("오류 ! Input에 값이 더이상 존재하지 않습니다.");
		}
	}
}
