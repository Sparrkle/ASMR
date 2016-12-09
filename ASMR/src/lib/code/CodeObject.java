package lib.code;

import javax.swing.JLabel;

import lib.exception.NotOverrideEssentialMethodException;

public class CodeObject implements Cloneable
{
	private String name = null;
	private boolean defaultObject = false;
	
	public JLabel[] lblOperand = new JLabel[3];
	
	public CodeObject()
	{
		for(int i=0; i<=2; i++)
		{
			lblOperand[i] = new JLabel();
			lblOperand[i].setOpaque(true);
		}
	}
	
	public void run() throws Exception
	{
		// 오버라이딩 하세용
	}
	
	public CodeObject copy()
	{
		// 이것도 오버라이딩
		return null;
	}
	
	public void setFirstOperand(String input)
	{
		lblOperand[0].setText(input);
	}
	
	public void setSecondOperand(String input)
	{
		lblOperand[1].setText(input);
	}
	
	public void setThirdOperand(String input)
	{
		lblOperand[2].setText(input);
	}

	/*
	public final String getFirstOperandValue()
	{
		String tempStr;

		tempStr = getCompareOperand();
		if(tempStr != null)
		{
			System.out.println("Compare Return");
			return tempStr;
		}
		return getSecondOperandValue();
	}
	
	public final String getSecondOperandValue()
	{
		int temp;
		
		temp = getTargetOperand();
		if(temp > -1)
		{
			System.out.println("Target Return");
			return Integer.toString(temp);
		}
		return getThirdOperandValue();
	}
	
	public final String getThirdOperandValue()
	{
		int temp;
		
		temp = getDestinationAddr();
		if(temp > -1)
		{
			System.out.println("Destination Return");
			return Integer.toString(temp);
		}
		else
		{
			System.out.println("Null Return");
			return null;
		}
	}
	*/
	
	public boolean isAvailablePointer() throws NotOverrideEssentialMethodException
	{
		if(getTargetOperand() < 0)
			return false;
		else
		{
			// 이 코드의 Target Operand가 포인터를 사용할수 있는지!
			// TargetOperand는 오버라이드 해서 있는데 
			// 오버라이딩 안하고 쓰면 *에러나용*
			throw new NotOverrideEssentialMethodException(name + " code is not override isAvailablePointer.");
		}
	}
	
	public boolean isCheckedPointer() throws NotOverrideEssentialMethodException
	{
		// Target variable operand가 포인터로 감싸져있는지 boolean 값을 return 하는 메소드에용
		// 오버라이딩 안하고 쓰면 *에러나용*
		throw new NotOverrideEssentialMethodException(name + " code is not override isCheckedPointer.");
	}
	
	public int getTargetOperand()
	{
		// 연산에 사용할 target variable operand를 구하는 메소드에용
		// 오버라이딩 안하면 null값 return 해용
		return -1;
	}
	
	public String getCompareOperand()
	{
		// ifcpu문에서만 써용
		// 오버라이딩 안하면 null값 return 해용
		return null;
	}
	
	public int getDestinationAddr()
	{
		// Code-window에서 Destination 주소를 구하는 메소드에용
		// 오버라이딩 안하면 null값 return 해용
		return -1;
	}
	
	public void setCheckedPointer(boolean input)
	{
		// 포인터 체크할꺼에용?
		// 필요할 때 오버라이딩 하세용
	}
	
	public void setTargetOperand(int operand)
	{
		// 연산에 사용할 target variable operand를 저장하는 메소드에용
		// 필요할 때 오버라이딩 하세용
	}
	
	public void setCompareOperand(int operand)
	{
		// ifcpu문에서만 써용
		// 필요할 때 오버라이딩 하세용
	}
	
	public void setDestinationAddr(int destination)
	{
		// Code-window에서 Destination 주소를 저장하는 메소드에용
		// 필요할 때 오버라이딩 하세용
	}
	
	public boolean getDefaultObject()
	{
		return defaultObject;
	}
	
	public void setDefaultObject(boolean input)
	{
		defaultObject = input;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String input)
	{
		name = input;
	}
}
