
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
	
		int gameState;

		private Paint paint;
	
	
	public GamePanel(Context context){
		super(context);

		
		this.context = context;
		sw = context.getSystemService(WindowManager.class).getDefaultDisplay().getWidth();
		sh = context.getSystemService(WindowManager.class).getDefaultDisplay().getHeight();
		
		setScreen = new ScreenManager(context);
		getHolder().addCallback(this);

		thread = new MainThread(getHolder(),this);
	
		setFocusable(true);
		
	
		
		paint = new Paint();
		paint.setColor(Color.RED);
		
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
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
					
					Vibrator v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
					v.vibrate(500);
					
					
				switch(gameState){
						case 1:
								setScreen.gameState++;
								
								
								break;
						case 2:
								setScreen.gameState++;
								
								break;
						case 3:
									setScreen.gameState-=2;
									
								break;
				}
					
					
				break;
			case MotionEvent.ACTION_MOVE:
				
				
				break;
			case MotionEvent.ACTION_UP:
		
				break;

		}

		return true;
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
