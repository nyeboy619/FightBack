package com.rt.fightback;
import android.graphics.*;
import android.content.*;
import java.io.*;
import android.content.res.*;
import android.view.*;

public class Rect2 implements GameObject
{

	Context c;
	Bitmap bmp;
	

	InputStream is;
	AssetManager am;
	float x=100,y=1;
	int sh,sw;
	Point p;


	public Rect2(Context c){
			this.c= c;
			am = c.getAssets();
			
			
			sh=c.getSystemService(WindowManager.class).getDefaultDisplay().getHeight();
			sw= c.getSystemService(WindowManager.class).getDefaultDisplay().getWidth();
			
			try
			{
					is = am.open("ic_launcher.png");
			}
			catch (IOException e)
			{}
			bmp = BitmapFactory.decodeStream(is);
			try
			{
					is.close();
			}
			catch (IOException e)
			{}
			
	
	}

	@Override
	public void draw(Canvas canvas)
	{
		
		
		canvas.drawBitmap(bmp,x,y,null);
	
		// TODO: Implement this method
	}

	
	public void update()
	{
			
		
			checkBounds();
		
		
	}
	
	public void checkBounds(){
			if(x+bmp.getHeight()<sh){
					y+=1.5f*(y/10);
			}
		if(y+bmp.getHeight()>=sh){
				y= sh-bmp.getHeight();
		}
	}
	
	
}
