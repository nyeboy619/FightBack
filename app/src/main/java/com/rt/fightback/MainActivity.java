package com.rt.fightback;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.Flag_FULLSCREEN,WindowManager.LayoutParams.Flag_FULLSCREEN)
        this.requestWindowFeature(Window.FEATURES_NO_TITLE);
        setContentView(new GamePanel(this);

    }
}
