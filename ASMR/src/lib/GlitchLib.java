package lib;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * 글리치 효과를 가진 애니메이션을 자동으로 출력해주는 클래스
 * 
 * GlitchLib에 ImageIcon으로 이루어진 배열과 대상 label을 넣어주면된다.
 * ImageIcon 배열의 첫번째는 기본 이미지이고 나머지가 글리치 효과를 준 이미지이다.
 * delayTime은 글리치 효과의 딜레이를 저장하는 변수.
 * effectTime은 글리치 애니메이션의 시간을 저장하는 변수.
 * effectCount는 글리치 애니메이션이 몇번 실행되는지 저장하는 변수.
 */

public class GlitchLib extends TimerTask
{
	/*
	 *  class에서 사용할 변수 선언
	 */
	ImageIcon[] glitchImage;
	JLabel lblTarget;
	Timer glitchTimer; // Timer는 Thread와 비슷하다. Background에서 작업한다.
	Timer effectTimer;
	TimerTask effectTask; // Thread의 run 함수처럼 Timer에 run을 선언한다고 생각하면 됨. 파편화.
	static int count = 0;
	static int effectTime = 0;
	static int effectCount = 0;
	
	public GlitchLib(ImageIcon[] imagesTemp, JLabel lblTemp, int delayTime, int effectTimeTemp, int effectCountTemp)
	{
		glitchImage = imagesTemp;
		lblTarget = lblTemp;
		effectTime = effectTimeTemp;
		effectCount = effectCountTemp;

		glitchTimer = new Timer(true);
		glitchTimer.schedule(this, delayTime, delayTime);
	}
	
	public void run()
	{
		count = 0;
		
		effectTimer = new Timer(true);
		effectTask = new TimerTask()
		{
			/*
			 * 이런식으로 클래스를 따로 선언하지 않고 오버라이딩을 할수있다.
			 */
			@Override
			public void run()
			{
				if(count < effectCount)
				{
					glitchEffect();
					count++;
				}
				else
				{
					lblTarget.setIcon(glitchImage[0]);
					//Timer를 제거한다. 다른 방법이 있을까...
					effectTimer.cancel();
				}
			}
		};
		effectTimer.schedule(effectTask, 0, effectTime);
	}
	
	void glitchEffect()
	{
		Random effectRandom = new Random();
		
		lblTarget.setIcon(glitchImage[effectRandom.nextInt(glitchImage.length-1)+1]);
	}
}
