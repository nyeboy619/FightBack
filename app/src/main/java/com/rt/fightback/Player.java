package com.rt.fightback;

import android.content.*;
import android.graphics.*;

public class Player
{
		Rect r;
		Paint p;
		public Player(Context c){
				
				
				r = new Rect(0,0,150,200);
				p = new Paint();
				p.setColor(Color.BLACK);
		}
		
		public void draw(Canvas c){
				
				c.drawRect(r,p);
		}
		
	
}
