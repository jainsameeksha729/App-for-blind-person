package com.example.sameeksha.hackathone;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreFreatureActivity extends AppCompatActivity {
    Button b, b1, b2;
    MediaPlayer songh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_freature);

        songh = MediaPlayer.create(MoreFreatureActivity.this, R.raw.recording3);
        songh.setAudioStreamType(AudioManager.STREAM_MUSIC);
        songh.setLooping(true);
        songh.start();



        b = (Button) findViewById(R.id.button1);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                songh.pause();
                Intent intent = new Intent(MoreFreatureActivity.this, Main24Activity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songh.pause();
                Intent intent = new Intent(MoreFreatureActivity.this, ReadOut.class);
                startActivity(intent);
            }
        });
        //song.reset();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songh.pause();
                Intent intent = new Intent(MoreFreatureActivity.this, MoreFeature2.class);
                startActivity(intent);
            }
        });




    }
    @Override
    protected void onPause(){
        super.onPause();
        songh.pause();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        songh.start();
    }
}
