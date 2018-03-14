package com.example.sameeksha.hackathone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
MediaPlayer mysong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysong= MediaPlayer.create(MainActivity.this,R.raw.recording1);
           mysong.start();

        new CountDownTimer(5000,1000) {
            public void onFinish() {
                Intent startActivity = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(startActivity);
                finish();
            }

            public void onTick(long millisUntilFinished) {
            }

        }.start();



       /* Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                 final Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }

        },5000);*/
    }

   /* void testToast(){
        Toast.makeText(this,"I am delayed",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    } */

    @Override
    protected void onPause(){
        super.onPause();
        mysong.pause();
    }

    /*@Override
    public void onStop() {
        super.onStop();
        mysong.release();
    }*/
}
