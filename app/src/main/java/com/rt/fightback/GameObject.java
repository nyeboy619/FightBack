package com.rt.fightback;

import android.graphics.*;

public interface GameObject
{
	
	public void draw(Canvas canvas);
	public void update();
	public boolean gameState();
	public void setGameStateToTrue();
}
