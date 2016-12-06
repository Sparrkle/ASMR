package lib.variable;

/*
 * 게임 화면에서 배열과 CPU 변수를 관리해주는 클래스
 */

import java.util.*;

import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;

public class VariableManager
{
	List<Object> arrInput;
	List<Object> arrOutput;
	String[] arrVar;
	String cpu;
	String test;
	
	public VariableManager(int arrAmount)
	{
		arrInput = new ArrayList<Object>();
		arrOutput = new ArrayList<Object>();
		arrVar = new String[arrAmount];
		cpu = new String();
	}
	
	public List<Object> getArrInput()
	{
		return arrInput;
	}
	
	public List<Object> getArrOutput()
	{
		return arrOutput;
	}
	
	public String withdrawInput() throws InvalidArraySizeException
	{
		if(arrInput.size() > 0)
		{
			String temp;
			temp = (String) arrInput.get(0);
			arrInput.remove(0);
			return temp;
		}
		else
			throw new InvalidArraySizeException("withdrawInput - arrInput size is 0");
	}
	
	public List<Object> depositOutput(Object input)
	{
		arrOutput.add(0, input);
		return arrOutput;
	}
	
	public String getVariable(int num) throws InvalidArraySizeException, InvalidValueException
	{
		if(num >= 0 && num < arrVar.length)
		{
			if(arrVar[num] != null)
				return arrVar[num];
			else
				throw new InvalidValueException("getVariable - invalid value to arrVar : " + num);
		}
		else
			throw new InvalidArraySizeException("getVariable - invalid get arrVar : " + num);
	}
	
	public String getVariableAtPointer(int num) throws InvalidArraySizeException, InvalidValueException, NumberFormatException
	{
		String targetAddress = "";
		try
		{
			targetAddress = getVariable(num);
			return getVariable(Integer.parseInt(targetAddress));
		}
		catch(InvalidArraySizeException e)
		{
			throw new InvalidArraySizeException(e.getMessage());
		}
		catch(InvalidValueException e)
		{
			throw new InvalidValueException(e.getMessage());
		}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("getVariableAtPointer - invalid operand : " + targetAddress);
		}
	}
	
	public void setVariable(String input, int num) throws InvalidArraySizeException
	{
		if(num >= 0 && num < arrVar.length)
			arrVar[num] = input;
		else
			throw new InvalidArraySizeException("setVariable - invalid set arrVar : " + num);
	}
	
	public String getCpu() throws InvalidValueException
	{
		if(cpu != null)
			return cpu;
		else
			throw new InvalidValueException("getCpu - invalid value to cpu");
	}
	
	public void setCpu(String input)
	{
		cpu = input;
	}
}