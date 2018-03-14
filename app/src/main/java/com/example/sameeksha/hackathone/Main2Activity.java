package com.example.sameeksha.hackathone;
/*import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.util.*;*/
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main2Activity extends AppCompatActivity {
    Button b, b1, b2;
    MediaPlayer song;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        song = MediaPlayer.create(Main2Activity.this, R.raw.recording2);
        song.setAudioStreamType(AudioManager.STREAM_MUSIC);
        song.setLooping(true);
        song.start();




        //change ();

        b = (Button) findViewById(R.id.button);
        // v = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.pause();
                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                startActivity(intent);
            }
        });*/


        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                song.pause();
                Intent intent = new Intent(Main2Activity.this, AadharNo.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.pause();
                Intent intent = new Intent(Main2Activity.this, Main22Activity.class);
                startActivity(intent);
            }
        });
        //song.reset();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.pause();
                Intent intent = new Intent(Main2Activity.this, MoreFreatureActivity.class);
                startActivity(intent);
            }
        });

       // song.reset();
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }
    @Override
    protected void onPause(){
        super.onPause();
        song.pause();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        song.start();
    }

}
   /* @Override
    public void onStop() {
        super.onStop();
        mysong.release();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }


}
 /* class RetrivePdfBytes extends AsyncTask<String,Void,byte[]>{
        @Override
        protected byte[] doInBackground(String... strings){
            InputStream inputStream =null;
            try{
                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(urlConnection.getInputStream());
                }
            }catch(IOException e){
                return null;
            }
            try{
                return IOUtils.toByteArray(inputStream);
            }catch(IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(byte[] bytes){
            pdfView.fromBytes(bytes).load();
        }
    }*/

   /* class RetrivePdfStream extends AsyncTask<String,Void,InputStream>{
        @Override
        protected InputStream doInBackground(String... strings){
            InputStream inputStream =null;
            try{
                URL url=new URL(strings[0]);
                HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(urlConnection.getInputStream());
                }
            }catch(IOException e){
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream){
            pdfView.fromStream(inputStream).load();
        }
    }*/
