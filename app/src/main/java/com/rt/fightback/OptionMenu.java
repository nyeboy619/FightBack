package com.rt.fightback;
import android.content.*;
import android.graphics.*;

public class OptionMenu implements GameObject
{
		Context c;

		boolean gameState;
		public OptionMenu(Context c){
				this.c = c;
		}

		@Override
		public void draw(Canvas canvas)
		{
				canvas.drawColor(Color.GRAY);
				// TODO: Implement this method
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
