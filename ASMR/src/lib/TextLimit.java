package lib;

import java.util.regex.*;

import javax.swing.text.*;

public class TextLimit extends PlainDocument
{
	private int limit;
	private String pattern = "";
	
	public TextLimit(int limit)
	{
		super();
		this.limit = limit;
	}
	
	public TextLimit(int limit, String patternInput)
	{
		super();
		this.limit = limit;
		this.pattern = patternInput;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
	{
		try
		{
			boolean check = true;
			if(pattern != "")
			{
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(str);
			
				if(!m.matches())
					return;
			}
			if(str == null)
				return;
			if(getLength() + str.length() <= limit)
				super.insertString(offset, str, attr);
		}
		catch(Exception e)
		{
		}
	} 
}
