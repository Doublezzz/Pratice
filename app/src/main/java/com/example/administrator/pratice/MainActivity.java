package com.example.administrator.pratice;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.pratice.view.HouseLoadingView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private HouseLoadingView mHouseLoadingView;
    private int mProgress=0;
    private static final  int REFRESH_PROGRESS=0x10;
    Handler mHandler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case REFRESH_PROGRESS:
                    if (mProgress<40){
                        mProgress+=1;
                        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,new Random().nextInt(200));
                        mHouseLoadingView.setProgress(mProgress);
                    }else {
                        mProgress+=1;
                        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,new Random().nextInt(300));
                        mHouseLoadingView.setProgress(mProgress);
                    }
                    break;
                default: break;

            }

            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHouseLoadingView= (HouseLoadingView) findViewById(R.id.longa);
        mHandler.sendEmptyMessageDelayed(REFRESH_PROGRESS,3000);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return true;
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id =item.getItemId();
//
//        if (id==R.id.action_settings){
//            mProgress++;
//            mHouseLoadingView.setProgress(mProgress);
//            return  true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
