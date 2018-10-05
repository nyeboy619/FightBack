package com.rt.fightback;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		
		
		new AudioPool(this);
		new Rect2(this);
		new Animated(this);
        super.onCreate(savedInstanceState);
				
		   
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GamePanel(this));
		
		
		
	

    }

		@Override
		protected void onPause()
		{
				// TODO: Implement this method
				super.onPause();
			
		
				
		}
		
		
}
