package lib.variable;

/*
 * 게임 화면에서 배열과 CPU 변수를 관리해주는 클래스
 */

import java.util.*;

import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;

public class VariableManager
{
	List<String> arrInput;
	List<String> arrOutput;
	String[] arrVar;
	String cpu;
	VariablePanel vp;

	public VariableManager(int arrAmount, VariablePanel vpInput)
	{
		vp = vpInput;
		arrInput = new ArrayList<String>();
		arrOutput = new ArrayList<String>();
		arrVar = new String[arrAmount];
		cpu = new String();
	}
	
	public void historyBackVariables(List<String> arrInputVal, List<String> arrOutputVal, String[] arrVarVal, String cpuVal)
	{
		arrInput = arrInputVal;
		arrOutput = arrOutputVal;
		arrVar = arrVarVal;
		cpu = cpuVal;
	}
	
	public void resetVariables()
	{
		arrInput.removeAll(arrInput);
		arrOutput.removeAll(arrOutput);
		cpu = null;
	}
	
	public List<String> getCopyedArrInput()
	{
		List<String> temp = new ArrayList<String>();
		temp.addAll(arrInput);
		return temp;
	}
	
	public List<String> getCopyedArrOutput()
	{
		List<String> temp = new ArrayList<String>();
		temp.addAll(arrOutput);
		return temp;
	}
	
	public String[] getArrVar()
	{
		String[] temp = new String[arrVar.length];
		temp = arrVar.clone();
		return temp;
	}
	
	public String getCpuHistory()
	{
		return cpu;
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
	
	public List<String> depositOutput(String input)
	{
		arrOutput.add(input);
		return arrOutput;
	}
	
	public String getVariable(int num) throws InvalidArraySizeException, InvalidValueException
	{
		if(num >= 0 && num < arrVar.length)
		{
			if(arrVar[num] != null && !arrVar[num].equals(""))
				return arrVar[num];
			else
				throw new InvalidValueException("getVariable - invalid value to arrVar : " + num, Integer.toString(num));
		}
		else
			throw new InvalidArraySizeException("getVariable - invalid get arrVar : " + num, Integer.toString(num));
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
			throw e;
		}
		catch(InvalidValueException e)
		{
			throw e;
		}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("getVariableAtPointer - invalid operand : " + targetAddress);
		}
	}
	
	public void setVariable(String input, int num) throws InvalidArraySizeException
	{
		if(num >= 0 && num < arrVar.length)
		{
			arrVar[num] = input;
		}
		else
			throw new InvalidArraySizeException("setVariable - invalid set arrVar : " + num, Integer.toString(num));
	}
	
	public void setVariableAtPointer(String input, int num) throws InvalidArraySizeException, InvalidValueException, NumberFormatException
	{
		String targetAddress = "";
		try
		{
			targetAddress = getVariable(num);
			setVariable(input, Integer.parseInt(targetAddress));
		}
		catch(InvalidArraySizeException e)
		{
			throw e;
		}
		catch(InvalidValueException e)
		{
			throw e;
		}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException("setVariableAtPointer - invalid operand : " + targetAddress);
		}
	}
	
	public String getCpu() throws InvalidValueException
	{
		if(cpu != null && !cpu.equals(""))
			return cpu;
		else
			throw new InvalidValueException("getCpu - invalid value to cpu");
	}
	
	public void setCpu(String input)
	{
		cpu = input;
	}
}