package lib.code;

import lib.code.instruction.*;
import lib.variable.VariableManager;

public class CodeCreateDefaultObject
{
	CodeManager cm;
	VariableManager vm;
	boolean availablePointer;
	
	public CodeCreateDefaultObject(CodeManager cmInput, VariableManager vmInput, boolean availablePointerInput)
	{
		cm = cmInput;
		vm = vmInput;
		availablePointer = availablePointerInput;
	}
	
	public CodeObject createScanData()
	{
		return new ScanData(true, vm);
	}
	
	public CodeObject createPrintData()
	{
		return new PrintData(true, vm);
	}
	
	public CodeObject createCopyFrom()
	{
		return new CopyFrom(true, vm, 0, availablePointer);
	}
	
	public CodeObject createJump()
	{
		return new Jump(true, cm, 1);
	}
}
