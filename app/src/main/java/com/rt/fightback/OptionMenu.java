package com.rt.fightback;
import android.content.*;
import android.graphics.*;
import android.view.*;

public class OptionMenu implements GameObject
{
		Context c;
		int sw,sh;

		Paint p;
		Rect soundSwitch,musicSwitch;
		RectF backButton;
		boolean gameState;
		public OptionMenu(Context c){
				this.c = c;
				Display d = c.getSystemService(WindowManager.class).getDefaultDisplay();
				sw= d.getWidth();
				sh= d.getHeight();
				
				soundSwitch = new Rect((sw/2)-250,(sh/2)-100,(sw/2)-50,(sh/2)+100);
				musicSwitch = new Rect((sw/2)+50,(sh/2)-100,(sw/2)+250,(sh/2)+100);
				backButton =  new RectF(50,50,100,100);
				p = new Paint();
				p.setAntiAlias(true);
				p.setColor(Color.BLACK);
		}

		@Override
		public void draw(Canvas canvas)
		{

				canvas.drawColor(Color.rgb(255,187,0));
				canvas.drawRect(soundSwitch,p);
				canvas.drawRect(musicSwitch,p);
				canvas.drawOval(backButton,p);
		}

		@Override
		public void update()
		{
				// TODO: Implement this method
		}

		@Override
		public boolean gameState()
		{
				// TODO: Implement this method
				return gameState;
		}

		@Override
		public void setGameStateToTrue()
		{
				gameState = true;
				// TODO: Implement this method
		}
		
}
