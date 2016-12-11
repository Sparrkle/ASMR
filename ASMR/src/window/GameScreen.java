package window;

import java.awt.*;

import javax.swing.*;

import lib.variable.VariablePanel;
import stage.StageLib;

public class GameScreen extends JPanel
{
	public int stageNum;
	VariablePanel pnVariable;
	public StageScreen ss;
	
	public GameScreen(int stageNumInput, StageScreen ssInput)
	{
		ss = ssInput;
		stageNum = stageNumInput;
		
		this.setBounds(0, 0, 720, 480);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		StageLib stageClass = new StageLib(stageNum);
		try
		{
			pnVariable = new VariablePanel(0, 0, 720, 480, stageClass, this);
			this.add(pnVariable);
			pnVariable.resetAll();
			pnVariable.pnCode.cm.setOutputandClear();
		}
		catch(Exception e)
		{
			//스테이지 화면으로 가는 이벤트
		}
	}
}
