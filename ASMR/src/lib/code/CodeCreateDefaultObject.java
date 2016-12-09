package lib.code;

import lib.code.instruction.*;
import lib.variable.VariableManager;

public class CodeCreateDefaultObject
{
	VariableManager vm;
	boolean availablePointer;
	
	public CodeCreateDefaultObject(VariableManager vmInput, boolean availablePointerInput)
	{
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
}
