package com.rt.fightback;
import android.content.*;
import android.graphics.*;

public class MainMenu implements GameObject
{

		
		boolean gameState;

		private Context c;
		public MainMenu(Context c){
				this.c = c;
				
				
		}

		@Override
		public void draw(Canvas canvas)
		{
				
				canvas.drawColor(Color.parseColor("ffbbpp"));
				// TODO: Implement this method
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
