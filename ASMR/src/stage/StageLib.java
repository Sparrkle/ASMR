package stage;

import java.lang.reflect.*;

/*
 * Stage의 동적 함수 실행을 위한 클래스.
 * stageNum에 1이 들어오면 stage.stageList.Stage1를 load하고 return 할 수 있다.
 * 
 * 아래는 예시.
 * 
 * StageLib stageClass = new StageLib(1); <-- 이러면 stage1을 불러온다.
 *				
 *	int[] a = {50, 30};
 *	a = stageClass.getOutputToInput(a);
 *	System.out.println("desc : " + stageClass.getDescription());
 *	System.out.println("arra : " + stageClass.getArrayAmount());
 *	System.out.println("avcm : " + stageClass.getAvailableCommand());
 *	System.out.println("goti : " + a[0]);
 */

public class StageLib
{
	boolean stageLoaded = false;
	Class<?> stageClass = null;
	Object obj = null;
	Method getDesMethod = null;
	Method getArrMethod = null;
	Method getAvCoMethod = null;
	Method getAvPoMethod = null;
	Method getOutMethod = null;
	
	public StageLib(int stageNum)
	{
		try
		{
			stageClass = Class.forName("stage.stageList.Stage"+stageNum);
			obj = stageClass.newInstance();
			
			getDesMethod = obj.getClass().getMethod("getDescription");
			getArrMethod = obj.getClass().getMethod("getArrayAmount");
			getAvCoMethod = obj.getClass().getMethod("getAvailableCommand");
			getAvPoMethod = obj.getClass().getMethod("getAvailablePointer");
			getOutMethod = obj.getClass().getMethod("getOutputToInput", new Class[]{int[].class});
			
			System.out.println("Success load stage" + stageNum);
		}
		catch(ClassNotFoundException cnfe)
		{
			System.err.print("** could not found : " + cnfe.getMessage());
		}
		catch(InstantiationException ie)
		{
			System.err.println("** cannot Instantiation : " + ie.getMessage());
		}
		catch(IllegalAccessException iae)
		{
			System.err.println("** cannot access method : " + iae.getMessage());
		}
		catch(NoSuchMethodException nsme)
		{
			System.err.println("** could not found method : " + nsme.getMessage());
		}
	}
	
	public String getDescription() throws Exception
	{
		if(getDesMethod != null)
		{
			try
			{
				return (String) getDesMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getDesMethod is null");
	}
	
	public int getArrayAmount() throws Exception
	{
		if(getArrMethod != null)
		{
			try
			{
				return (int) getArrMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getArrMethod is null");
	}
	
	public int getAvailableCommand() throws Exception
	{
		if(getAvCoMethod != null)
		{
			try
			{
				return (int) getAvCoMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getAvCoMethod is null");
	}
	
	public boolean getAvailablePointer() throws Exception
	{
		if(getAvCoMethod != null)
		{
			try
			{
				return (boolean) getAvPoMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getAvPoMethod is null");
	}
	
	public int[] getOutputToInput(int[] input) throws Exception
	{
		if(getOutMethod != null)
		{
			try
			{
				return (int[]) getOutMethod.invoke(obj, input);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getOutMethod is null");
	}
}