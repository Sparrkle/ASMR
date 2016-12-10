package lib.variable;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import stage.StageLib;
import lib.code.listener.CodeCentreMouseListener;
import lib.code.listener.CodeVariableMouseListener;
import lib.code.panel.CodePanel;

public class VariablePanel extends JPanel
{
	JLabel lblCpuStore;
	JLabel lblInput;
	JLabel lblOutput;
	JTextArea txtDescription;
	JButton btnCpu;
	public JButton[] btnVariable;
	JPanel pnVariableSub;
	CodePanel pnCode;
	VariableManager vm;
	
	public VariablePanel(int x, int y, int w, int h, StageLib stageClass) throws Exception
	{
		System.out.println("Create VariablePanel");
		this.setBounds(x, y, w, h);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		
		int arrayAmount;
		int avCo;
		String strDescription;
		boolean avPo;
		
		try
		{
			//ÀÌÁß ÇÏ³ª¶óµµ ¿¹¿ÜÃ³¸®µÇ¸é ½ºÅ×ÀÌÁö »ý¼º ÇÁ·Î±×·¡¹ÖÀÌ Àß¸øµÈ°Å.
			avCo = stageClass.getAvailableCommand();
			arrayAmount = stageClass.getArrayAmount();
			strDescription = stageClass.getDescription();
			avPo = stageClass.getAvailablePointer();
		}
		catch (Exception e)
		{
			throw e;
		}
		
		vm = new VariableManager(arrayAmount, this);
		
		JButton btnBack = new JButton("");
		btnBack.setActionCommand("Back");
		btnBack.setBounds(10, 415, 30, 30);
		btnBack.setContentAreaFilled(false);
		btnBack.setRequestFocusEnabled(false);
		btnBack.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		this.add(btnBack);
		
		pnCode = new CodePanel(470, 30, 220, 415, this);
		this.add(pnCode);
		this.add(pnCode.createCodeSourcePanel(70, 10, 20, avCo, vm, avPo));
		this.addMouseListener(new CodeCentreMouseListener(pnCode));
			
		JPanel pnDescription = new JPanel();
		pnDescription.setBounds(10, 30, 370, 160);
		this.add(pnDescription);
		pnDescription.setLayout(null);
		
		txtDescription = new JTextArea();
		txtDescription.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		txtDescription.setBounds(5, 30, 360, 125);
		pnDescription.add(txtDescription);
		txtDescription.setLineWrap(true);
		txtDescription.setText(strDescription);
		txtDescription.addMouseListener(new CodeCentreMouseListener(pnCode));
		txtDescription.setEditable(false);
		
		JPanel pnInput = new JPanel();
		pnInput.setBounds(10, 200, 370, 45);
		this.add(pnInput);
		pnInput.setLayout(null);
		
		lblInput = new JLabel("");
		lblInput.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblInput.setBounds(5, 25, 360, 15);
		pnInput.add(lblInput);
		
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
		
		/*
		JPanel pnCpuStore = new JPanel();
		pnCpuStore.setBackground(Color.BLACK);
		pnCpuStore.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		pnCpuStore.setBounds(0, 15, 40, 40);
		pnCpu.add(pnCpuStore);
		pnCpuStore.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCpuStore = new JLabel("900");
		lblCpuStore.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblCpuStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpuStore.setForeground(Color.WHITE);
		pnCpuStore.add(lblCpuStore, BorderLayout.CENTER);
		*/
		
		JPanel pnOutput = new JPanel();
		pnOutput.setLayout(null);
		pnOutput.setBounds(10, 365, 370, 45);
		this.add(pnOutput);
		
		lblOutput = new JLabel("");
		lblOutput.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblOutput.setBounds(5, 25, 360, 15);
		pnOutput.add(lblOutput);
		
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
		System.out.println("created button : " + index);
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
	}
}
