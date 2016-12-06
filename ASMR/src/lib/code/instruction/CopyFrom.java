package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.exception.NotOverrideEssentialMethodException;
import lib.variable.VariableManager;

public class CopyFrom extends CodeObject
{
	VariableManager vm;
	int targetOperand = 0;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public CopyFrom(VariableManager vmInput, int inputOperand, boolean inputAvailablePointer)
	{
		this.setName("copyFrom");
		this.setTargetOperand(inputOperand);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public boolean isAvailablePointer()
	{
		return availablePointer;
	}
	
	@Override
	public boolean isCheckedPointer()
	{
		return checkedPointer;
	}
	
	@Override
	public int getTargetOperand()
	{
		return targetOperand;
	}
	
	@Override
	public void setCheckedPointer(boolean input)
	{
		checkedPointer = input;
	}
	
	@Override
	public void setTargetOperand(int operand)
	{
		targetOperand = operand;
		this.setFirstOperand(Integer.toString(targetOperand));
	}
	
	@Override
	public void run() throws InvalidArraySizeException, InvalidValueException, NumberFormatException
	{
		String temp;
		try
		{
			if(checkedPointer == true)
				temp = vm.getVariableAtPointer(targetOperand);
			else
				temp = vm.getVariable(targetOperand);
			
			vm.setCpu(temp);
		}
		catch(InvalidArraySizeException iase)
		{
			throw iase;
		}
		catch(InvalidValueException ive)
		{
			throw ive;
		}
		catch(NumberFormatException nfe)
		{
			throw nfe;
		}
	}
}
