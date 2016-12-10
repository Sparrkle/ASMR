package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class PrintData extends CodeObject
{
	VariableManager vm;
	
	public PrintData(boolean defaultObjectInput, VariableManager vmInput)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("printData");
		vm = vmInput;
	}
	
	@Override
	public PrintData copy()
	{
		PrintData copyObj = null;
		try
		{
			copyObj = (PrintData) super.clone();
		}
		catch(CloneNotSupportedException cnse){};
		
		copyObj.vm = this.vm;
		
		return copyObj;
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
