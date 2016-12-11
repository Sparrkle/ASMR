package lib.variable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

import javax.swing.*;
import javax.swing.border.LineBorder;

import stage.StageLib;
import window.GameScreen;
import lib.code.listener.CodeCentreMouseListener;
import lib.code.listener.CodeVariableMouseListener;
import lib.code.panel.CodePanel;

public class VariablePanel extends JLayeredPane implements ActionListener
{
	JLabel lblCpuStore;
	JLabel lblInput;
	JLabel lblOutput;
	JTextArea txtDescription;
	String defaultDescription;
	JButton btnCpu;
	JButton btnBack;
	public JButton[] btnVariable;
	JPanel pnVariableSub;
	public CodePanel pnCode;
	public VariableManager vm;
	GameScreen gs;
	StageLib stageClass;
	
	ImageIcon imgStageDescription = new ImageIcon("src/img/stageDescription.png");
	ImageIcon imgInput = new ImageIcon("src/img/input.png");
	ImageIcon imgOutput = new ImageIcon("src/img/output.png");
	ImageIcon imgPrevious = new ImageIcon("src/img/previous.png");
	
	public VariablePanel(int x, int y, int w, int h, StageLib stageClassInput, GameScreen gsInput) throws Exception
	{
		System.out.println("Create VariablePanel");
		gs = gsInput;
		this.setBounds(x, y, w, h);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
		stageClass = stageClassInput;
		
		int arrayAmount;
		int avCo;
		boolean avPo;
		
		try
		{
			//ÀÌÁß ÇÏ³ª¶óµµ ¿¹¿ÜÃ³¸®µÇ¸é ½ºÅ×ÀÌÁö »ý¼º ÇÁ·Î±×·¡¹ÖÀÌ Àß¸øµÈ°Å.
			avCo = stageClass.getAvailableCommand();
			arrayAmount = stageClass.getArrayAmount();
			defaultDescription = stageClass.getDescription();
			avPo = stageClass.getAvailablePointer();
		}
		catch (Exception e)
		{
			throw e;
		}
		
		vm = new VariableManager(arrayAmount, this);
		
		btnBack = new JButton("");
		btnBack.setActionCommand("Back");
		btnBack.setBounds(10, 415, 30, 30);
		btnBack.setContentAreaFilled(false);
		btnBack.setRequestFocusEnabled(false);
		btnBack.setIcon(imgPrevious);
		btnBack.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnBack.addActionListener(this);
		this.add(btnBack);
		
		pnCode = new CodePanel(470, 30, 220, 415, this);
		this.add(pnCode);
		this.add(pnCode.createCodeSourcePanel(70, 10, 20, avCo, vm, avPo));
		this.addMouseListener(new CodeCentreMouseListener(pnCode));
			
		JPanel pnDescription = new JPanel();
		pnDescription.setBounds(10, 30, 370, 160);
		pnDescription.setOpaque(false);
		this.add(pnDescription);
		pnDescription.setLayout(null);
		
		JLabel lblImgDescription = new JLabel();
		lblImgDescription.setIcon(imgStageDescription);
		lblImgDescription.setBounds(0, 0, 370, 160);
		pnDescription.add(lblImgDescription);
		
		txtDescription = new JTextArea();
		txtDescription.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		txtDescription.setBounds(5, 30, 360, 125);
		lblImgDescription.add(txtDescription);
		txtDescription.setLineWrap(true);
		txtDescription.setForeground(Color.white);
		txtDescription.setOpaque(false);
		txtDescription.setText(defaultDescription);
		txtDescription.addMouseListener(new CodeCentreMouseListener(pnCode));
		txtDescription.setEditable(false);
		
		JPanel pnInput = new JPanel();
		pnInput.setBounds(10, 200, 370, 45);
		pnInput.setOpaque(false);
		this.add(pnInput);
		pnInput.setLayout(null);
		
		JLabel lblImgInput = new JLabel();
		lblImgInput.setIcon(imgInput);
		lblImgInput.setBounds(0, 0, 370, 45);
		pnInput.add(lblImgInput);
		
		lblInput = new JLabel("");
		lblInput.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblInput.setForeground(Color.white);
		lblInput.setOpaque(false);
		lblInput.setBounds(5, 25, 360, 15);
		lblImgInput.add(lblInput);
		
		JPanel pnOutput = new JPanel();
		pnOutput.setLayout(null);
		pnOutput.setOpaque(false);
		pnOutput.setBounds(10, 365, 370, 45);
		this.add(pnOutput);
		
		JLabel lblImgOutput = new JLabel();
		lblImgOutput.setIcon(imgOutput);
		lblImgOutput.setBounds(0, 0, 370, 45);
		pnOutput.add(lblImgOutput);
		
		lblOutput = new JLabel("");
		lblOutput.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblOutput.setForeground(Color.white);
		lblOutput.setOpaque(false);
		lblOutput.setBounds(5, 25, 360, 15);
		lblImgOutput.add(lblOutput);
		
		JPanel pnVariableMain = new JPanel();
		pnVariableMain.setOpaque(false);
		pnVariableMain.setBounds(10, 250, 370, 110);
		this.add(pnVariableMain);
		pnVariableMain.setLayout(null);
		
		pnVariableSub = new JPanel();
		pnVariableSub.setOpaque(false);
		pnVariableSub.setBounds(50, 0, 320, 110);
		pnVariableMain.add(pnVariableSub);
		pnVariableSub.setLayout(null);
		
		JPanel pnCpu = new JPanel();
		pnCpu.setOpaque(false);
		pnCpu.setBounds(0, 25, 40, 55);
		pnVariableMain.add(pnCpu);
		pnCpu.setLayout(null);
		
		JLabel lblCpu = new JLabel("CPU");
		lblCpu.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblCpu.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		lblCpu.setOpaque(true);
		lblCpu.setBackground(Color.BLACK);
		lblCpu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu.setBounds(0, 0, 40, 15);
		pnCpu.add(lblCpu);
		
		btnCpu = new JButton("");
		btnCpu.setBackground(Color.BLACK);
		btnCpu.setBorder(new LineBorder(Color.WHITE, 2));
		btnCpu.setBounds(0, 15, 40, 40);
		btnCpu.setForeground(Color.WHITE);
		btnCpu.setContentAreaFilled(false);
		btnCpu.setRequestFocusEnabled(false);
		btnCpu.addMouseListener(new CodeVariableMouseListener(pnCode, -1));
		btnCpu.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pnCpu.add(btnCpu);
		
		setVariableButton(arrayAmount);
	}
	
	public void setVariableButton(int arrayAmount)
	{
		btnVariable = new JButton[arrayAmount];
		
		for(int i=0; i<arrayAmount; i++)
		{
			createVariableButton(i);
		}
	}
	
	public void createVariableButton(int index)
	{
		int x = 0;
		int y = 10;
		
		if(index >= 6)
		{
			y += 50;
		}
		x = (index%6)*50;
		
		JLayeredPane pnVarTemp = new JLayeredPane();
		pnVarTemp.setOpaque(false);
		pnVarTemp.setBounds(x, y, 40, 40);
		pnVariableSub.add(pnVarTemp);
		pnVarTemp.setLayout(null);
		
		JLabel lblVar = new JLabel(Integer.toString(index));
		lblVar.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		lblVar.setForeground(UIManager.getColor("InternalFrame.borderHighlight"));
		lblVar.setOpaque(true);
		lblVar.setBackground(Color.BLACK);
		lblVar.setForeground(Color.GRAY);
		lblVar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVar.setBounds(0, 24, 37, 15);
		pnVarTemp.add(lblVar, JLayeredPane.DEFAULT_LAYER);
		
		btnVariable[index] = new JButton("");
		btnVariable[index].setBackground(Color.BLACK);
		btnVariable[index].setBorder(new LineBorder(Color.WHITE, 2));
		btnVariable[index].setBounds(0, 0, 40, 40);
		btnVariable[index].setForeground(Color.WHITE);
		btnVariable[index].setContentAreaFilled(false);
		btnVariable[index].setRequestFocusEnabled(false);
		btnVariable[index].addMouseListener(new CodeVariableMouseListener(pnCode, index));
		btnVariable[index].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pnVarTemp.add(btnVariable[index], JLayeredPane.POPUP_LAYER);
		
		//resetAll();
	}
	
	public void updateDescription(String input)
	{
		txtDescription.setText(input);
	}
	
	public void updateVariable()
	{
		for(int i=0; i<btnVariable.length; i++)
			btnVariable[i].setText(vm.arrVar[i]);
	}
	
	public void updateCPU()
	{
		btnCpu.setText(vm.cpu);
	}
	
	public void updateInput()
	{
		String temp = "";
		for(int i=0; i<vm.arrInput.size(); i++)
			temp += vm.arrInput.get(i) + " ";
		lblInput.setText(temp);
	}
	
	public void updateOutput()
	{
		String temp = "";
		for(int i=0; i<vm.arrOutput.size(); i++)
			temp += vm.arrOutput.get(i) + " ";
		lblOutput.setText(temp);
	}
	
	public void resetAll()
	{
		updateDescription(defaultDescription);
		vm.resetVariables();
		
		String[] temp;
		
		try
		{
			vm.arrInput = stageClass.setInput(vm.arrInput);
			temp = stageClass.impliedArraySet();
			vm.arrVar = temp.clone();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		updateVariableAll();
		
		pnCode.pnDebug.setBtnBackEnabled(false);
		pnCode.pnDebug.setBtnStopEnabled(false);
		pnCode.pnDebug.setBtnFrontGroupEnabled(true);
	}
	
	public List<String> getOutputToInput()
	{
		try
		{
			return stageClass.getOutputToInput(vm.arrInput);
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public void victory()
	{
		JLayeredPane pnVictory = new JLayeredPane();
		pnVictory.setBounds(-10, -10, 720, 480);
		pnVictory.setOpaque(false);
		this.add(pnVictory, JLayeredPane.POPUP_LAYER);
		
		ImageIcon imgClear = new ImageIcon("src/img/clear.gif");
		imgClear.getImage().flush();
		
		JLabel lblImgClear;
		lblImgClear = new JLabel();
		lblImgClear.setBounds(0, 0, 720, 480);
		lblImgClear.setOpaque(false);
		pnVictory.add(lblImgClear, new Integer(1));
		lblImgClear.setIcon(imgClear);
		
		JLabel lblBgClear = new JLabel();
		lblBgClear.setBounds(0, 0, 720, 480);
		lblBgClear.setOpaque(true);
		lblBgClear.setBackground(new Color(0, 0, 0, 60));
		pnVictory.add(lblBgClear, new Integer(0));
		
		pnCode.pnDebug.setBtnBackEnabled(false);
		pnCode.pnDebug.setBtnFrontGroupEnabled(false);
		pnCode.pnDebug.setBtnSpeedDownEnabled(false);
		pnCode.pnDebug.setBtnSpeedUpEnabled(false);
		pnCode.pnDebug.setBtnStopEnabled(false);
		btnBack.setEnabled(false);
		
		gs.ss.updateStageNum(gs.stageNum);
		
		Timer victoryTimer = new Timer(true);
		TimerTask victoryTask = new TimerTask()
		{
			@Override
			public void run()
			{
				goToStage();
			}
		};
		victoryTimer.schedule(victoryTask, 2500);
	}
	
	public void updateVariableAll()
	{
		updateCPU();
		updateVariable();
		updateInput();
		updateOutput();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() == "Back")
		{
			goToStage();
		}
	}
	
	public void goToStage()
	{
		gs.setVisible(false);
		gs.ss.setStageButton();
	}
}
