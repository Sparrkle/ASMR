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
	
	public List<String> getArrInput()
	{
		return arrInput;
	}
	
	public List<String> getArrOutput()
	{
		return arrOutput;
	}
	
	public void reprintInput()
	{
		String temp = "";
		for(int i=0; i<arrInput.size(); i++)
		{
			temp += (String) arrInput.get(i);
		}
		vp.lblInput.setText(temp);
	}
	
	public void reprintOutput()
	{
		String temp = "";
		for(int i=0; i<arrInput.size(); i++)
		{
			temp += (String) arrOutput.get(i);
		}
		vp.lblOutput.setText(temp);
	}
	
	public String withdrawInput() throws InvalidArraySizeException
	{
		if(arrInput.size() > 0)
		{
			String temp;
			temp = (String) arrInput.get(0);
			arrInput.remove(0);
			reprintInput();
			return temp;
		}
		else
			throw new InvalidArraySizeException("withdrawInput - arrInput size is 0");
	}
	
	public List<String> depositOutput(String input)
	{
		arrOutput.add(0, input);
		reprintOutput();
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
		{
			arrVar[num] = input;
			vp.btnVariable[num].setText(arrVar[num]);
		}
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
		vp.btnCpu.setText(cpu);
	}
}