package com.rt.fightback

public class RectPlayer implements GameObject{
	
	private Rect rectangle;
	private int color;

	public RectPlayer(Rect rectangle, int color){
		this.rectangle = rectangle;
		this.color = color;
	}

	@Override
	public void draw(Canvas canvas){
		Paint paint = new Paint();
		paint.setColor(color)
		canvas.draw(Rect,paint);

	}

	@Override
	public void update(){

	}

	@Override
	public void update(Point point){
		rectangle.set(point.x-rectangle.width()/2,point.y-rectangle.height()/2,point.x+rectangle.width()/2,point.y+rectangle.height()/2)
	}

}