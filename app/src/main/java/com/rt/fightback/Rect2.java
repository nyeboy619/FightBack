package com.rt.fightback;
import android.graphics.*;
import android.content.*;

public class Rect2 implements GameObject
{

	Context c;
	
	private Rect rectangle;

	

	public Rect2(){
		rectangle = new Rect(100,100,200,200);
	
	}

	@Override
	public void draw(Canvas canvas)
	{
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		canvas.drawRect(rectangle,paint);
	
		// TODO: Implement this method
	}

	
	public void update(int x, int y)
	{
		Thread t = new Thread();
		try
		{
			t.sleep(1000);
			rectangle.set(x - rectangle.width() / 2, y - rectangle.height() / 2, x + rectangle.width() / 2, y + rectangle.height() / 2);
			
			
		}
		catch (InterruptedException e)
		{}
		
		
	}
	@Override
	public void update(){
		
	}
	
}
