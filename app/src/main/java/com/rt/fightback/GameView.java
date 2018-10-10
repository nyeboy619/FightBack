package com.rt.fightback;
import android.content.*;
import android.graphics.*;

public class GameView implements GameObject
{

		private Context c;
		public GameView(Context c){
				this.c = c;
		}

		boolean gameState;

		public void setGameStateToTrue()
		{
				gameState = true;
				// TODO: Implement this method
		}
		
		@Override
		public void draw(Canvas canvas)
		{
				canvas.drawColor(Color.GREEN);
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
		
}
