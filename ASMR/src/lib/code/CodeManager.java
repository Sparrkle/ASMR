package lib.code;

import java.awt.Point;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

import sun.misc.VM;
import lib.code.panel.CodePanel;
import lib.variable.VariablePanel;

public class CodeManager implements CodeConstants
{
	public VariablePanel vp;
	public CodeHistory ch;
	CodePanel cp;
	int programCounter = -1;
	int delay = 1000;
	JList<CodeObject> listCode;
	List<String> answerOutput;
	DefaultListModel<CodeObject> listModelCode;
	Timer codeTimer;
	TimerTask codeTask; // Thread의 run 함수처럼 Timer에 run을 선언한다고 생각하면 됨. 파편화.
	boolean started = false;
	
	public CodeManager(JList<CodeObject> listCodeInput, VariablePanel vpInput, CodePanel cpInput)
	{
		cp = cpInput;
		vp = vpInput;
		listCode = listCodeInput;
		listModelCode = (DefaultListModel) listCode.getModel();
		ch = new CodeHistory();
	}
	
	public int getProgramCounter()
	{
		return programCounter;
	}
	
	public void setProgramCounter(int input)
	{
		programCounter = input;
	}
	
	public int getDelay()
	{
		return delay;
	}
	
	public void setDelay(int input)
	{
		delay = input;
		if(isStarted() == true)
		{
			stop();
			start();
		}
	}
	
	public boolean isStarted()
	{
		return started;
	}
	
	public void setStarted(boolean input)
	{
		started = input;
	}
	
	public void setOutputandClear()
	{
		answerOutput = vp.getOutputToInput();
		ch.clear();
	}
	
	public void start()
	{
		codeTimer = new Timer(true);
		codeTask = new TimerTask()
		{
			/*
			 * 이런식으로 클래스를 따로 선언하지 않고 오버라이딩을 할수있다.
			 */
			@Override
			public void run()
			{
				if(listModelCode.getSize() > 1)
				{
					try
					{
						if(programCounter < listModelCode.getSize()-2)
							codeFront();
						else
						{
							stop();
								if(checkOutput() == false)
									errorException(new Exception("오류 ! 출력 되어야 할 값은 : " + answerOutput + "입니다!"));
						}
					}
					catch(Exception e)
					{
						errorException(e);
					}
				}
			}
		};
		setStarted(true);
		codeTimer.schedule(codeTask, 0, delay);
	}
	
	public void codeHistorySave()
	{
		ch.setCodeHistory(vp.vm.getCopyedArrInput(), vp.vm.getCopyedArrOutput(), vp.vm.getArrVar(), vp.vm.getCpuHistory(), programCounter);
	}
	
	public void codeBack()
	{
		if(ch.anchor > 0)
		{
			ch.decAnchor();
			List<String> hisInput = ch.getHisInput();
			List<String> hisOutput = ch.getHisOutput();
			String[] hisVariable = ch.getHisVariable();
			String hisCpu = ch.getHisCpu();
			programCounter = ch.getHisProgramCounter();
			
			vp.vm.historyBackVariables(hisInput, hisOutput, hisVariable, hisCpu);
			if(programCounter == -1)
				vp.pnCode.listMain.clearSelection();
			else
				vp.pnCode.listMain.setSelectedIndex(programCounter);
			
			vp.updateVariableAll();
			
			cp.pnDebug.setBtnFrontGroupEnabled(true);
			if(ch.anchor <= 0)
				cp.pnDebug.setBtnBackEnabled(false);
		}
		setScrollBarValue();
	}
	
	public void codeFront()
	{
		setScrollBarValue();
		if(listModelCode.getSize() > 1)
		{	
			try
			{
				codeHistorySave();
				
				programCounter++;
	
				codeRun();
				
				cp.pnDebug.setBtnStopEnabled(true);
				cp.pnDebug.setBtnBackEnabled(true);
				if(programCounter >= listModelCode.getSize()-2)
				{
					cp.pnDebug.setBtnFrontGroupEnabled(false);
				}
			}
			catch(Exception e)
			{
				errorException(e);
			}
		}
		try
		{
			if(checkOutput() == true)
			{
				//정답
				vp.victory();
				stop();
			}
		}
		catch(Exception e)
		{
			errorException(e);
		}
	}
	
	public void codeRun() throws Exception
	{
		try
		{
			if(programCounter >= listModelCode.getSize()-1)
			{
				programCounter--;
				throw new Exception("오류 ! 출력 되어야 할 값은 : " + answerOutput + "입니다!");
			}
			listModelCode.get(programCounter).run();
			vp.pnCode.listMain.setSelectedIndex(programCounter);
			vp.updateVariableAll();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void setScrollBarValue()
	{
		int temp = listModelCode.getSize();
		if(programCounter <= temp-12)
			cp.spMain.getVerticalScrollBar().setValue(30*programCounter);
		cp.repaint();
	}
	
	public void errorException (Exception e)
	{
		vp.updateDescription(e.getMessage());
		cp.pnDebug.setBtnStopEnabled(true);
		cp.pnDebug.setBtnFrontGroupEnabled(false);
		vp.pnCode.listMain.setSelectedIndex(programCounter);
		stop();
	}
	
	public boolean checkOutput() throws Exception
	{
		List<String> check = vp.vm.getCopyedArrOutput();
		
		if(check.size() > answerOutput.size())
		{
			throw new Exception("오류 ! Output의 총 길이는 " + answerOutput.size() + "여야 합니다! \n현재 Output의 길이 : " + check.size());
		}
		else if(check.size() == answerOutput.size() && vp.vm.getCopyedArrInput().size() == 0)
		{
			for(int i=0; i<check.size(); i++)
			{
				if(!check.get(i).equals(answerOutput.get(i)))
				{
					throw new Exception("오류 ! 출력 값 : " + check.get(i) + "는 답이 아닙니다! 다시 확인해 주세요. \n출력 되어야 할 값 : " + answerOutput.get(i));
				}
			}
			return true;
		}
		else
		{
			for(int i=0; i<check.size(); i++)
			{
				if(!check.get(i).equals(answerOutput.get(i)))
				{
					throw new Exception("오류 ! 출력 값 : " + check.get(i) + "는 답이 아닙니다! 다시 확인해 주세요. \n출력 되어야 할 값 : " + answerOutput.get(i));
				}
			}
			return false;
		}
	}
	
	public void stop()
	{
		if(started == true)
		{
			codeTimer.cancel();
			setStarted(false);
		}
	}
}
