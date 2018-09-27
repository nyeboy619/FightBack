package com.rt.fightback;

import android.graphics.*;

public class RectPlayer implements GameObject
{
	Rect2 rec2;
	


	public RectPlayer(){
		rec2= new Rect2();
	}

	@Override
	public void draw(Canvas canvas){
		rec2.draw(canvas);

	}

	@Override
	public void update(){
		

	}

	
	public void update(Point p){
		rec2.update(p.x,p.y);
	}

}

