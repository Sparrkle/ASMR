package lib.code;

import java.util.*;

public class CodeHistory
{
	ArrayList<List<String>> hisInput;
	ArrayList<List<String>> hisOutput;
	List<String[]> hisVariable;
	List<String> hisCpu;
	List<Integer> hisProgramCounter;
	
	int anchor = 0;
	
	public CodeHistory()
	{
		hisInput = new ArrayList<List<String>>();
		hisOutput = new ArrayList<List<String>>();
		hisVariable = new ArrayList<String[]>();
		hisCpu = new ArrayList<String>();
		hisProgramCounter = new ArrayList<Integer>();
	}
	
	public void setCodeHistory(List<String> inputInp, List<String> outputInp, String[] varInp, String cpuInp, int pcInp)
	{
		hisInput.add(inputInp);
		hisOutput.add(outputInp);
		hisVariable.add(varInp);
		hisCpu.add(cpuInp);
		hisProgramCounter.add(pcInp);
		
		anchor += 1;
	}
	
	public List<String> getHisInput()
	{
		List<String> temp = hisInput.get(anchor);
		hisInput.remove(anchor);
		return temp;
	}
	
	public List<String> getHisOutput()
	{
		List<String> temp = hisOutput.get(anchor);
		hisOutput.remove(anchor);
		return temp;
	}
	
	public String[] getHisVariable()
	{
		String[] temp = hisVariable.get(anchor);
		hisVariable.remove(anchor);
		return temp;
	}
	
	public String getHisCpu()
	{
		String temp = hisCpu.get(anchor);
		hisCpu.remove(anchor);
		return temp;
	}
	
	public int getHisProgramCounter()
	{
		int temp = hisProgramCounter.get(anchor);
		hisProgramCounter.remove(anchor);
		return temp;
	}
	
	public void decAnchor()
	{
		anchor--;
	}
	
	public void clear()
	{
		hisInput.removeAll(hisInput);
		hisOutput.removeAll(hisOutput);
		hisVariable.removeAll(hisVariable);
		hisCpu.removeAll(hisCpu);
		hisProgramCounter.removeAll(hisProgramCounter);
		
		anchor = 0;
	}
}
