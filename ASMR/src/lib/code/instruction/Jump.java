package lib.code.instruction;

import lib.code.CodeManager;
import lib.code.CodeObject;

public class Jump extends CodeObject
{
	CodeManager cm;
	int destination = 1;
	
	public Jump(boolean defaultObjectInput, CodeManager cmInput, int destinationInput)
	{
		cm = cmInput;
		super.setDefaultObject(defaultObjectInput);
		this.setName("jump");
		setDestinationAddr(destinationInput);
	}
	
	@Override
	public Jump copy()
	{
		Jump copyObj = null;
		try
		{
			copyObj = (Jump) super.clone();
		}
		catch(CloneNotSupportedException cnse){};
		
		copyObj.destination = this.destination;
		
		return copyObj;
	}
	
	@Override
	public int getDestinationAddr()
	{
		return destination;
	}

	@Override
	public void setDestinationAddr(int destinationInput)
	{
		destination = destinationInput;
	}
	
	@Override
	public void run() throws Exception
	{
		try
		{
			if(destination-1 == cm.getProgramCounter())
				throw new Exception ("���� ! Jump �ڵ尡 ��ġ�� ������ �̵��ؾ� �� ���ΰ� ��ġ�ϸ� \n�ȵ˴ϴ�.");
			cm.setProgramCounter(destination-1);
			cm.codeRun();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}