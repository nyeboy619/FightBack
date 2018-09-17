
package com.rt.fightback;

import android.content.*;
import android.graphics.*;
import android.view.*;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private MainThread thread;

	
	private Point playerPoint;

	private ArrayList<RectPlayer> Player;
	private RectPlayer player;



	public GamePanel(Context context){
		super(context);

		getHolder().addCallback(this);

		thread = new MainThread(getHolder(),this);

		player = new RectPlayer(new Rect(100,100,200,200),Color.WHITE);
		playerPoint = new Point(150,150);

		setFocusable(true);
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
			case MotionEvent.ACTION_MOVE:
				playerPoint.set((int)event.getX(),(int)event.getY());
				Player.add(player);

		}

		return true;
	}

	public void update(){
		player.update(playerPoint);
	}

	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);

		canvas.drawColor(Color.RED);

		player.draw(canvas);
	}
}
