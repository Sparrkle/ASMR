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
	
	public CodeObject createCopyTo()
	{
		return new CopyTo(true, vm, 0, availablePointer);
	}
	
	public CodeObject createInc()
	{
		return new Inc(true, vm, 0, availablePointer);
	}
	
	public CodeObject createDec()
	{
		return new Dec(true, vm, 0, availablePointer);
	}
	
	public CodeObject createAdd()
	{
		return new Add(true, vm, 0, availablePointer);
	}
	
	public CodeObject createSub()
	{
		return new Sub(true, vm, 0, availablePointer);
	}
	
	public CodeObject createIfCpu()
	{
		return new IfCpu(true, vm, cm, ">=", 0, 1, availablePointer);
	}
	
	public CodeObject createJump()
	{
		return new Jump(true, cm, 1);
	}
}
