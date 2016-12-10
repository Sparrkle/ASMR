package lib.code;

import javax.swing.*;

public class CodeHistory
{
	JList<JList<String>> hisInput;
	JList<JList<String>> hisOutput;
	JList<JList<String>> hisVariable;
	JList<String> hisCpu;
	JList<Integer> hisProgramCounter;
	
	DefaultListModel<JList<String>> modelInput;
	DefaultListModel<JList<String>> modelOutput;
	DefaultListModel<JList<String>> modelVariable;
	DefaultListModel<String> modelCpu;
	DefaultListModel<Integer> modelProgramCounter;
	
	int anchor;
	
	public CodeHistory()
	{
		hisInput = new JList<JList<String>>();
		hisOutput = new JList<JList<String>>();
		hisVariable = new JList<JList<String>>();
		hisCpu = new JList<String>();
		hisProgramCounter = new JList<Integer>();
		
		modelInput = new DefaultListModel<JList<String>>();
		modelOutput = new DefaultListModel<JList<String>>();
		modelVariable = new DefaultListModel<JList<String>>();
		modelCpu = new DefaultListModel<String>();
		modelProgramCounter = new DefaultListModel<Integer>();
		
		hisInput.setModel(modelInput);
		hisOutput.setModel(modelOutput);
		hisVariable.setModel(modelVariable);
		hisCpu.setModel(modelCpu);
		hisProgramCounter.setModel(modelProgramCounter);
		
		anchor = 0;
	}
	
	public void setCodeHistory(JList<String> inputInp, JList<String> outputInp, JList<String> varInp, String cpuInp, int pcInp)
	{
		modelInput.add(anchor, inputInp);
		modelOutput.add(anchor, outputInp);
		modelVariable.add(anchor, varInp);
		modelCpu.add(anchor, cpuInp);
		modelProgramCounter.add(anchor, pcInp);
		
		anchor += 1;
	}
	
	public JList<Object> getCodeHistory()
	{
		if(anchor > 0)
		{
			anchor -= 1;
			
			JList<Object> temp = new JList<Object>();
			DefaultListModel<Object> modelTemp = new DefaultListModel<Object>();		
			temp.setModel(modelTemp);
			
			modelTemp.addElement(modelInput.getElementAt(anchor));
			modelTemp.addElement(modelOutput.getElementAt(anchor));
			modelTemp.addElement(modelVariable.getElementAt(anchor));
			modelTemp.addElement(modelCpu.getElementAt(anchor));
			modelTemp.addElement(modelProgramCounter.getElementAt(anchor));

			return temp;
		}
		else
			return null;
	}
	
	public void clear()
	{
		hisInput.removeAll();
		hisOutput.removeAll();
		hisVariable.removeAll();
		hisCpu.removeAll();
		hisProgramCounter.removeAll();
		
		anchor = 0;
	}
}
