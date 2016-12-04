package stage;

interface StageInterface
{
	public abstract String getDescription();
	public abstract int getArrayAmount();
	public abstract int getAvailableCommand();
	public abstract boolean getAvailablePointer();
	public abstract int[] getOutputToInput(int[] input);
	public abstract void setInput();
}
