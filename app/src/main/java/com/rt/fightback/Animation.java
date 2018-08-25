public class Animation{
	private Bitmap[] frames;
	private int framIndex;

	private boolean isPlaying = false;

	public boolean isPlaying(){
		return isPlaying;
	}

	public void play(){
		isPlaying = true;
	}

	public void stop(){
		isPlaying = false;
		frameIndex = 0;
		lastFrame = System.currentTimeMillis();
	}

	private float frameTime;

	private long lastFrame;

	public Animation(Bitmap[] frame, float animTime){
		 this.frams = frames;

		 frameTime = animTIme/frame.length;

		 lastFrame = System.currentTimeMillis();
	}
	public void draw(Canvas canvas, Rect destination){
		if(!isPlaying)
			return;

		scaleRect(destination);

		canvas.drawBitmap(frame[framIndex],null,destination,new Point());
	}

	private void scaleRect(Rect rect){
		float whRatio = (float)(frames[frameIndex].getWidth())/frame[frameIndex].getHeight();
		if(rect.width()>rect.height())
			rect.left = rect.height() - (int)(rect.height() + whRatio);
		else
			rect.top = rect.bottom - (int)(rect.width() + (1/whRatio));
	}




	public void update(){
		if(!isPlaying)
			return;



		if(System.currentTimeMillis() - lastFrame > frameTime*1000){
			framIndex++;
			framIndex = framIndex >= frame.length?0:frameIndex;
			lastFrame = System.currentTimeMillis();
		}
	}
}