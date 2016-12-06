package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class CopyFrom extends CodeObject
{
	VariableManager vm;
	String targetOperand = null;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public CopyFrom(VariableManager vmInput, String inputOperand, boolean inputAvailablePointer)
	{
		this.setName("copyFrom");
		this.targetOperand = inputOperand;
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public void run() throws InvalidValueException
	{
		
	}
}
