public class AnimationManager{
	private Animation[] animation;
	private in animationIndex;

	public AnimationManager(Animation[] animation){
		this.animation = animation;
	}

	public void playAnim(int index){
		for(int i; i < animation.length ; i++){
			if(i==index){
				if(!animation[index].isPlaying())
			animation[i].play();
		}
		else
			animation[i].stop();
		}
	}

	public void draw(Canvas canvas, Rect rect){
		if(animation[animationIndex].isPlaying())
			animation[animationIndex].drawC(cavas,rect);
	}

	public void update(){
		if(animation[animationIndex].isPlaying()){
			animation[animationIndex].update();
		}
	}




}