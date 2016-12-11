package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class CopyTo extends CodeObject
{
	VariableManager vm;
	int targetOperand = 0;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public CopyTo(boolean defaultObjectInput, VariableManager vmInput, int inputOperand, boolean inputAvailablePointer)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("copyTo");
		this.setTargetOperand(inputOperand);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public CopyTo copy()
	{
		CopyTo copyObj = null;
		try
		{
			copyObj = (CopyTo) super.clone();
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
		try
		{
			temp = vm.getCpu();
			
			if(checkedPointer == true)
				vm.setVariableAtPointer(temp, targetOperand);
			else
				vm.setVariable(temp, targetOperand);
		}
		catch(InvalidArraySizeException iase)
		{
			throw new InvalidArraySizeException("오류 ! " + iase.getExtra() + "번 변수는 존재하지 않습니다.");
		}
		catch(InvalidValueException ive)
		{
			if(ive.getExtra() != null)
				throw new InvalidValueException("오류 ! " + ive.getExtra() + "번 변수에는 값이 존재하지 않습니다.");
			else
				throw new InvalidValueException("오류 ! CPU에 값이 존재하지 않습니다.");
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("오류 ! 주소 값은 문자를 참고 하실 수 없습니다.");
		}
	}
}
