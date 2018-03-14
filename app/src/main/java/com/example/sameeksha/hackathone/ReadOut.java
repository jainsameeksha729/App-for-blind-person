package com.example.sameeksha.hackathone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.UUID;

/*public class ReadOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_out);
    }
}*/

public class ReadOut extends Activity implements
        TextToSpeech.OnInitListener {
    //Called when the activity is first created.

    private TextToSpeech tts;
    private Button btnSpeak,b2;
    // private TextView v;
    String text = "";
    long len;
    EditText editText;
    String aBuffer = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_out);

        tts= new TextToSpeech(this,this);

        btnSpeak = (Button) findViewById(R.id.bt);
        b2=(Button) findViewById(R.id.btnPase);
        // v = (TextView) findViewById(R.id.tv);
        editText = (EditText)findViewById(R.id.tv);

        try {
            InputStream is = getAssets().open("placeholder.txt");
            InputStreamReader r=new InputStreamReader(is);
            BufferedReader myReader = new BufferedReader(r);
            String aDataRow = "";
            int size=is.available();
            editText.setFilters(new InputFilter[] {
                    new InputFilter.LengthFilter(size)
            });
            int count=0;
            while ((aDataRow = myReader.readLine()) != null&&aDataRow.length()!=0) {
                aBuffer += aDataRow;
            }
            editText.setText(aBuffer, TextView.BufferType.EDITABLE);


        } catch (IOException e) {
            e.printStackTrace();
        }
        // speakOut();
        // button on click event
        // text = editText.getText().toString();
        //len=editText.getText().length();
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(tts.isSpeaking()){
                    btnSpeak.setText("Speak");
                    //tts.stop();
                    //tts.playSilence(1000, TextToSpeech.QUEUE_FLUSH, null);
                    tts.stop();
                    // tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_ADD, null, UUID.randomUUID().toString());
                    // tts.playSilentUtterance(400, TextToSpeech.QUEUE_ADD, UUID.randomUUID().toString());
                }
            }

        });
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();

        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                b2.setEnabled(true);
                //speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {
        text = editText.getText().toString();
        len=editText.getText().length();

        for(long i=0;i<len;i=i+500){
            String t= text.substring((int)i, (int)i+500);
            tts.speak(t, TextToSpeech.QUEUE_ADD, null);
            String s=text.substring((int)i+500);
            text=s;
            len=text.length();
        }

       /* btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // speakOut();
                if(tts.isSpeaking()==true){
                    btnSpeak.setText("Speak");
                    tts.playSilence(1000,TextToSpeech.QUEUE_ADD,null);
                }else{
                    btnSpeak.setText("Speak");
                }
            }
        });*/


    }

}

