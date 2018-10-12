package com.rt.fightback;

import android.content.*;
import android.graphics.*;

public class ScreenManager
{

		private Context c;

		private OptionMenu option;

		
		public void update()
		{
				// TODO: Implement this method
				checkGameState();
		}
		
		MainMenu menu;
		GameView game;
		
		int gameState;
		
		
		
		public ScreenManager(Context c){
			this.c= c;
			gameState = 1;
			menu = new MainMenu(c);
			game = new GameView(c);
			option = new OptionMenu(c);
			
		}
	
		
		public void draw(Canvas canvas){
				if(menu.gameState()){
						menu.draw(canvas);
				}
			else	if(game.gameState()){
						game.draw(canvas);
				}
			else	if(option.gameState()){
						option.draw(canvas);
				}
				
				//canvas.drawColor(Color.RED);
		}
		
		public int getGameState(){
				
				return gameState;
		}
		
		public void checkGameState(){
				switch(gameState){
						
						case 1:
								menu.setGameStateToTrue();
								game.gameState = false;
								option.gameState = false;
								
								break;
								
						case 2:
								game.setGameStateToTrue();
								menu.gameState = false;
								option.gameState = false;
								
								break;
								
						case 3:
								option.setGameStateToTrue();
								menu.gameState = false;
								game.gameState = false;
								
								break;
				}
		}
		
		
}
