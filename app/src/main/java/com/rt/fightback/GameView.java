package com.rt.fightback;
import android.content.*;
import android.graphics.*;
import android.view.*;

public class GameView
{ 
		RectF startButton;
		int sw,sh;
		private Context c;
		Paint p;
		Player dino;
		boolean gameStart;
		
		
		public GameView(Context c){
				this.c = c;
				Display d = c.getSystemService(WindowManager.class).getDefaultDisplay();
				sw=d.getWidth();
				sh=d.getHeight();
				startButton = new RectF((sw/2)-150,(sh/2)-150,(sw/2)+150,(sh/2)+150);
				p = new Paint();
				p.setColor(Color.BLACK);
				dino = new Player(c);
				gameStart=false;
		}

		boolean gameState;

		public void setGameStateToTrue()
		{
				gameState = true;
				
		}
		
		
		public void draw(Canvas canvas)
		{
				canvas.drawColor(Color.rgb(255,187,0));
				
				if(gameStart==false){
				canvas.drawOval(startButton,p);
				}
				else if(gameStart==true){
						
						dino.draw(canvas);
						
						
						
						
						
						
				}
				
		}

		
		public void update()
		{
				
		}
		
		public boolean gameState(){
				return gameState;
		}
		
		
}
