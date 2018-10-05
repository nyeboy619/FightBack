package com.rt.fightback;

import android.content.*;
import android.graphics.*;

public class RectPlayer implements GameObject
{
	Rect2 rec2;
	Context c;
	


	public RectPlayer(Context c){
		rec2= new Rect2(c);
	}

	@Override
	public void draw(Canvas canvas){
		rec2.draw(canvas);

	}

	@Override
	public void update(){
		rec2.update();

	}

	

}

