package com.rt.fightback;
import android.content.*;
import android.content.res.*;
import android.media.*;
import android.util.*;
import java.io.*;

public class AudioPool
{
	SoundPool soundPool;
	Context c;

	int x;
	AssetFileDescriptor descriptor;
	
	
	public AudioPool(Context c){
		this.c=c;
		
		soundPool = new SoundPool(20,AudioManager.STREAM_MUSIC,0);
		if(c!=null){
		try
		{
		AssetManager assetManager = c.getAssets();
		descriptor = assetManager.openFd("crunch.ogg");
			
			x = soundPool.load(descriptor, 0);
		}
		catch ( IOException e)
		{
		   
		}
		}else{}
		 
	}

	
	public void play(){
		soundPool.play(x,1.0f,1.0f,1,0,1);
		Log.i("i"," Sound played");
	}
	

}
