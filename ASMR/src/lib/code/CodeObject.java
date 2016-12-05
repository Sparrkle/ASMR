package lib.code;

import lib.exception.NotOverrideEssentialMethodException;

public class CodeObject
{
	private String name;
	
	public void run() throws Exception
	{
		// 오버라이딩 하세용
	}
	
	public boolean isCheckedPointer() throws NotOverrideEssentialMethodException
	{
		// Target variable operand가 포인터로 감싸져있는지 boolean 값을 return 하는 메소드에용
		// 오버라이딩 안하고 쓰면 *에러나용*
		throw new NotOverrideEssentialMethodException(name + " code is not override isCheckedPointer.");
	}
	
	public String getTargetOperand()
	{
		// 연산에 사용할 target variable operand를 구하는 메소드에용
		// 오버라이딩 안하면 null값 return 해용
		return null;
	}
	
	public String getCompareOperand()
	{
		// ifcpu문에서만 써용
		// 오버라이딩 안하면 null값 return 해용
		return null;
	}
	
	public String getDestinationAddr()
	{
		// Code-window에서 Destination 주소를 구하는 메소드에용
		// 오버라이딩 안하면 null값 return 해용
		return null;
	}
	
	public void setTargetOperand()
	{
		// 연산에 사용할 target variable operand를 저장하는 메소드에용
		// 오버라이딩 하세용
	}
	
	public void setCompareOperand()
	{
		// ifcpu문에서만 써용
		// 오버라이딩 하세용
	}
	
	public void setDestinationAddr()
	{
		// Code-window에서 Destination 주소를 저장하는 메소드에용
		// 오버라이딩 하세용
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
