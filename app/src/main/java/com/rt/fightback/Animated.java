package com.rt.fightback;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import java.io.*;
import java.util.*;
import android.view.*;

public class Animated implements GameObject
{

		@Override
		public void setGameStateToTrue()
		{
				// TODO: Implement this method
		}


		

		@Override
		public boolean gameState()
		{
				// TODO: Implement this method
				return false;
		}




		int frame=0;
		List<Rect> obs;
		
		Bitmap bmp,temp;
		Bitmap[] animated;
		AssetManager am;
		InputStream is;
		Context c;
		int x=1000,y,sw,sh,h,w,or=0;
		
		public Animated(Context c){
				this.c = c;
				sh= c.getSystemService(WindowManager.class).getDefaultDisplay().getHeight();
				animated = new Bitmap[25];
				obs = new ArrayList<Rect>();
				
				am = c.getAssets();
				try
				{
						is = am.open("download.png");
				}
				catch (IOException e)
				{
						
				}
				bmp = BitmapFactory.decodeStream(is);
				try
				{
						is.close();
				}
				catch (IOException e)
				{}

				int f=0;
				 w= bmp.getWidth()/5;
				 h=bmp.getHeight()/5;
				for(int i = 0;i<5;i++){
						for(int j =0 ;j<5;++j){
								
						
				
				animated[f] = Bitmap.createBitmap(bmp,w*j,h*i,w,h);
				
				f++;
				}
				}
				
				
				for(int i=0;i<10;i++){
						obs.add(new Rect(x,0,200,200));
						x+=1000+new Random().nextInt(1000);
						
				}

		}
		
		
		@Override
		public void draw(Canvas canvas)
		{
	
				
				for(Rect r : obs){
						canvas.drawBitmap(animated[frame],
						r.centerX()-or,sh-h,null);
						updateFire();
				}
				
				
				
		}

		@Override
		public void update()
		{
			
				updateFire();
				updateFrame();
				
				frame++;
			
				if(x<0+w){
						obs.remove(true);
				}
		}
		public void updateFrame(){
				frame++;
				if(frame>=23){
						frame=0;
				}
		}
		public void updateFire(){
				
				or++;
				
		}
}
