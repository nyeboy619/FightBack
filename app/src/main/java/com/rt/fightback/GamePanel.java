
package com.rt.fightback;

import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.os.*;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private MainThread thread;

	
	


	
	int sw,sh;


	Context context;
	ScreenManager setScreen;
	MainMenu main;
	
		int gameState;

		private Paint paint;
	
		Point touchPoint;
	
	public GamePanel(Context context){
		super(context);

		
		this.context = context;
		sw = context.getSystemService(WindowManager.class).getDefaultDisplay().getWidth();
		sh = context.getSystemService(WindowManager.class).getDefaultDisplay().getHeight();
		
		setScreen = new ScreenManager(context);
		main = new MainMenu(context);
		getHolder().addCallback(this);

		thread = new MainThread(getHolder(),this);
	
		setFocusable(true);
		
	
		
		paint = new Paint();
		paint.setColor(Color.RED);
		
		
		touchPoint = new Point();
		
		this.context.getApplicationContext();
	
		Toast.makeText(context,"GameStart",Toast.LENGTH_LONG).show();
		
	
	}

	
	

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder){
			
		thread = new MainThread(getHolder(),this);

		thread.setRunning(true);
		thread.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){

		boolean retry = true;
		while(retry){
			try{
				thread.setRunning(false);
				thread.join();
			}	catch (Exception e) {	e.printStackTrace();}
			retry = false;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
			touchPoint.set((int)event.getX(),(int)event.getY());
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
					
					Vibrator v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
					v.vibrate(500);
					
					
				switch(gameState){
						case 1:
								if(main.playButton.contains(touchPoint.x,touchPoint.y)){
										setScreen.gameState=2;
								}else if(main.optionButton.contains(touchPoint.x,touchPoint.y)){
										setScreen.gameState=3;
								}
								
								
								break;
						case 2:
								
								
								break;
						case 3:
									
									
								break;
				}
					
					
				break;
			case MotionEvent.ACTION_MOVE:
				

						switch(gameState){
								case 1:



										break;
								case 2:


										break;
								case 3:


										break;
						}
					
					
					
				
				break;
			case MotionEvent.ACTION_UP:
		

						switch(gameState){
								case 1:



										break;
								case 2:


										break;
								case 3:


										break;
						}
					
					
				break;

		}

		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
			// TODO: Implement this method

			if(keyCode == KeyEvent.KEYCODE_BACK){
					
			}
			return super.onKeyDown(keyCode, event);
	
	
	}

	public void update(){
	   setScreen.update();
			gameState = setScreen.getGameState();
	}
	

	

	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);

		//canvas.drawColor(Color.YELLOW);
		
		
		
		setScreen.draw(canvas);
	
	}
	
	
	
	
	 
} 
