package com.winkey.winFrame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.winkey.winFrame.event.Event;
import com.winkey.winlib.event.EventManage;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceived(EventManage eventManage){
        if(Event.EVENT_LOGIN .equals(eventManage.event)){

        }
    }
}
