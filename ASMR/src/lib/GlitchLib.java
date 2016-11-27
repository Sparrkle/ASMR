package lib;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GlitchLib extends TimerTask
{
	ImageIcon[] glitchImage;
	JLabel lblTarget;
	Timer glitchTimer;
	Timer effectTimer;
	TimerTask effectTask;
	static int count = 0;
	
	public GlitchLib(ImageIcon[] imagesTemp, JLabel lblTemp)
	{
		glitchImage = imagesTemp;
		lblTarget = lblTemp;

		glitchTimer = new Timer(true);
		glitchTimer.schedule(this, 2000, 2000);
	}
	
	public void run()
	{
		count = 0;
		
		effectTimer = new Timer(true);
		effectTask = new TimerTask()
		{
			@Override
			public void run()
			{
				if(count < 5)
				{
					glitchEffect();
					count++;
				}
				else
				{
					lblTarget.setIcon(glitchImage[0]);
					effectTimer.cancel();
				}
			}
		};
		effectTimer.schedule(effectTask, 0, 50);
	}
	
	void glitchEffect()
	{
		Random effectRandom = new Random();
		
		lblTarget.setIcon(glitchImage[effectRandom.nextInt(glitchImage.length-1)+1]);
	}
}
