package stage;

import java.util.List;

public interface StageInterface
{
	public abstract List<String> getOutputToInput(List<String> input);
	public abstract List<String> setInput (List<String> input);
}
