package com.rt.fightback;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;

public class MainActivity extends Activity 
{
		Toast t;
		GamePanel gp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		
		
		new AudioPool(this);
		new Rect2(this);
		new Animated(this);
		
		gp = new GamePanel(this);
        super.onCreate(savedInstanceState);
				
		   
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(gp);
		
		
		
				
	

    }
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event)
		{
				if(keyCode==4){
						event = KeyEvent.changeFlags(event,KeyEvent.FLAG_FROM_SYSTEM);
						switch(gp.gameState){
								case 1:
										Toast.makeText(this,"Click Exit button!",Toast.LENGTH_LONG).show();
										finish();
										break;
								case 2:
										gp.setState(1);
										break;
								case 3:
										gp.setState(1);
										break;
						}

						
						}
				return super.onKeyDown(keyCode, event);
		}

		
		
		
		
		

		@Override
		protected void onPause()
		{
				// TODO: Implement this method
				super.onPause();
			
		
				
		}
		
		
}
