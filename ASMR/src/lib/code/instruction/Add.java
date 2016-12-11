package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class Add extends CodeObject
{
	VariableManager vm;
	int targetOperand = 0;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public Add(boolean defaultObjectInput, VariableManager vmInput, int inputOperand, boolean inputAvailablePointer)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("add");
		this.setTargetOperand(inputOperand);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public Add copy()
	{
		Add copyObj = null;
		try
		{
			copyObj = (Add) super.clone();
		}
		catch(CloneNotSupportedException cnse){};
		
		copyObj.vm = this.vm;
		copyObj.targetOperand = this.targetOperand;
		copyObj.availablePointer = this.availablePointer;
		copyObj.checkedPointer = this.checkedPointer;
		
		return copyObj;
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
	}
	
	@Override
	public void run() throws InvalidArraySizeException, InvalidValueException, NumberFormatException
	{
		String temp;
		String cpuTemp;
		try
		{
			if(checkedPointer == true)
				temp = vm.getVariableAtPointer(targetOperand);
			else
				temp = vm.getVariable(targetOperand);
		}
		catch(InvalidArraySizeException iase)
		{
			throw new InvalidArraySizeException("오류 ! " + iase.getExtra() + "번 변수는 존재하지 않습니다.");
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("오류 ! " + ive.getExtra() + "번 변수에는 값이 존재하지 않습니다.");
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("오류 ! 주소 값은 문자를 참고 하실 수 없습니다.");
		}
		
		try
		{
			cpuTemp = vm.getCpu();
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("오류 ! CPU에 저장된 값이 존재하지 않습니다.");
		}
		
		try
		{
			temp = Integer.toString(Integer.parseInt(temp) + Integer.parseInt(cpuTemp));
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("오류 ! 문자를 더할 수는 없습니다.");
		}
		
		if(Integer.parseInt(temp) > 999)
		{
			throw new NumberFormatException("오버플로우 오류 ! 999 이상의 수를 다루실 수 없습니다.");
		}
		
		vm.setCpu(temp);
	}
}
