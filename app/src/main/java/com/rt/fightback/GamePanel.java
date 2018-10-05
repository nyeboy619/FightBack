
package com.rt.fightback;

import android.content.*;
import android.graphics.*;
import android.view.*;
import java.util.*;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private MainThread thread;

	
	private Point playerPoint;


	private RectPlayer player;

	private AudioPool audioPool;
	
	private Animated a;
	private boolean gameStarted = false;
	private boolean spawnChar= false;


	Context context;
	public GamePanel(Context context){
		super(context);

		
		this.context = context;
		
		a= new Animated(context);
		getHolder().addCallback(this);

		thread = new MainThread(getHolder(),this);

		player = new RectPlayer(context);
		

		
		setFocusable(true);
		
		audioPool = new AudioPool(context);
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
		while(true){
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
					spawnChar=true;
					
					break;
			case MotionEvent.ACTION_MOVE:
				
				
				break;
			case MotionEvent.ACTION_UP:
				gameStarted=true;
					
				break;

		}

		return true;
	}

	public void update(){
		player.update();
		a.update();
		
	}

	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);

		
		canvas.drawColor(Color.YELLOW);
	
		if(spawnChar){
				player.draw(canvas);
		
		}
		
		if(gameStarted){
		a.draw(canvas);
	

		
		
		
		}
	}
}
