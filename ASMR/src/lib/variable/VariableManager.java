package lib.variable;

import java.util.*;

public class VariableManager
{
	List<Object> arrInput;
	List<Object> arrOutput;
	String[] arrVar;
	String cpu;
	
	public VariableManager(int arrAmount)
	{
		arrInput = new ArrayList<Object>();
		arrOutput = new ArrayList<Object>();
		arrVar = new String[arrAmount];
		cpu = new String();
	}
	
	public String getVariable(int num)
	{
		return arrVar[num];
	}
	
	public void setVariable(String input, int num)
	{
		arrVar[num] = input;
	}
	
	public String getCpu()
	{
		return cpu;
	}
	
	public void setCpu(String input)
	{
		cpu = input;
	}
}