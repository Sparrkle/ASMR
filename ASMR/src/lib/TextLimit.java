package lib;

import java.awt.event.*;
import java.util.regex.*;
import javax.swing.text.*;


/*
 * JTextComponent들의 글자 수 제한과 패턴으로 한글같은걸 입력받지 못하게 하는 클래스
 * 크.. 만능 클래스 지렸습니다
 */
public class TextLimit implements KeyListener
{
	private JTextComponent tcOrigin;
	private int limit;
	private String pattern = "";
	
	public TextLimit(JTextComponent tcInput, int limit)
	{
		this.tcOrigin = tcInput;
		this.limit = limit;
	}
	
	public TextLimit(JTextComponent tcInput, int limit, String patternInput)
	{
		this.tcOrigin = tcInput;
		this.limit = limit;
		this.pattern = patternInput;
	}

	@Override
	public void keyPressed(KeyEvent ke)
	{
	}
	
	@Override
	public void keyReleased(KeyEvent ke)
	{
	}
	 
	@Override
	public void keyTyped(KeyEvent ke)
	{
		String c = Character.toString(ke.getKeyChar());
		
		try
		{
			if(pattern != "")
			{
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(c);
			
				if(!m.matches())
					ke.setKeyChar('\0');
			}
			if(tcOrigin.getText().length() >= limit)
			{
				ke.setKeyChar('\0');
			}
		}
		catch(Exception e)
		{
		}
	}
}
