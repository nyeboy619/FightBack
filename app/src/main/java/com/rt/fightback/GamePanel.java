public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{
	private MainThread thread;

	public GamePanel(Context context){
		super(context);

		getHolder().addCallback(this);

		thread = new MainThread(getHolder(),this);

		setFocusable(true);
	}

	@Override
	public surfaceChange(SurfaceHolder holder, int format, int width, int height){

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder){
		thread = new MainThread(getHolder(),this);

		thread.setRunning(true);
		thread.start(;)
	}

	@Override
	public void SurfaceDestroyed(SurfaceHolder holder){

		boolean retry = true;
		while(true){
			try{
				thread.setRunning(false);
				thread.join();
			}	catch (Exception e) {	e.printStackTrace()}
			retry = false
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event){
		return super.onTouchEvent(event);
	}

	public void update(){

	}

	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);
	}
}