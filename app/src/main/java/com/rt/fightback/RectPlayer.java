package com.rt.fightback;

import android.graphics.*;

public class RectPlayer implements GameObject
{
	
	private Rect rectangle;
	private int color;

	private Animation idle;
	private Animation walkRight;
	private Animation walkLeft;

	private AnimationManager animManager;

	public RectPlayer(Rect rectangle, int color){
		this.rectangle = rectangle;
		this.color = color;


		BitmapFactory bf = new BitmapFactory();
		Bitmap idleImg = bg.decodeResource(Constants.CURRENT_CONTEXT.getResource(),R.drawable.idle);
		Bitmap walkLeftImg = bg.decodeResource(Constants.CURRENT_CONTEXT.getResource(),R.drawable.walkLeft);
		Bitmap walkRightImg = bg.decodeResource(Constants.CURRENT_CONTEXT.getResource(),R.drawable.walkRight);

		idle = new Animation(new Bitmap[](idleImg),2);
		walkRight = new Animation(new Bitmap[](walkLeftImg,walkRightImg),0.5f);
		walkLeft = new Animation(new Bitmap[](walkLeftImg,walkRightImg),0.5f);

		Matrix m = new Matrix();
		m.preScale(-1,1);
		walkLeftImg  = Bitmap.createBitmap(walkLeftImg,0,0,walkLeftImg.getWidth(),walkLeftImg.getHeight(),m,false);
		walkRightImg  = Bitmap.createBitmap(walkRightImg,0,0,walkRightImg.getWidth(),walkRightImg.getHeight(),m,false);

		animManager = new AnimationManager(new Animation[](idle,walkLeft,walkRight));


	}

	@Override
	public void draw(Canvas canvas){
		Paint paint = new Paint();
//		paint.setColor(color);
//		canvas.drawRect(rectangle,paint);
		animManager.draw(canvas,rectangle);

	}

	@Override
	public void update(){
		animManager.update();

	}

	
	public void update(Point point){
		float oldLeft = rectangle.left();


		rectangle.set(point.x-rectangle.width()/2,point.y-rectangle.height()/2,point.x+rectangle.width()/2,point.y+rectangle.height()/2);

		int state = 0;
		if(rectangle.left - oldLeft > 5)
			state = 1;
		else if(rectangle.left - oldLeft < -5)
			state = 2;

		animManager.playAnim(state);
		animManager.update();
	}

}

