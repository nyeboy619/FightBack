package com.rt.fightback;
import android.content.*;
import android.graphics.*;
import android.view.*;

public class MainMenu implements GameObject
{

		
		boolean gameState;

		private Context c;

		private int sh;

		private int sw;
		
		Rect playButton,optionButton;
		
		Paint p;
		public MainMenu(Context c){
				this.c = c;
				
				Display d =c.getSystemService(WindowManager.class).getDefaultDisplay();
				sw = d.getWidth();
				sh = d.getHeight();
				
				playButton = new Rect((sw/2)-100,(sh/2)-50,(sw/2)+100,(sh/2)+50);
				
				optionButton = new Rect((sw/2)-100,(sh/2)+100,(sw/2)+100,(sh/2)+200);
				p = new Paint();
				p.setColor(Color.BLACK);
				
		}

		@Override
		public void draw(Canvas canvas)
		{
				
				canvas.drawColor(Color.rgb(255,187,0));
				// TODO: Implement this method
				canvas.drawRect(playButton,p);
				canvas.drawRect(optionButton,p);
				
		}

		@Override
		public void update()
		{
				// TODO: Implement this method
		}
		
		public boolean gameState(){
				return gameState;
		}
		
		public void setGameStateToTrue(){
				gameState=true;
		}
		
		
}
