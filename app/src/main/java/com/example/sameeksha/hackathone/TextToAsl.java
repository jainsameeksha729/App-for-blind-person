package com.example.sameeksha.hackathone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/*public class TextToAsl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_asl);
    }
}*/

public class TextToAsl extends Activity {

// View Objects

    Button translate;

    EditText enterText;

    TextView displayText;

    ImageView aslImages;

    MainActivity thisClass;

    // Variables for Translation and Display

    int phraseIndex = 0; // Keep track of the array indexes
    String letters;     // Message to be Translated
    String display;     // Will hold the letters already displayed and show them

    // Array Libraries For Characters and Image References
    char letterIndex [] = { 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p',
            'q', 'r', 's', 't',
            'u', 'v', 'w', 'x',
            'y', 'z'};
    int aslPics [] ={R.drawable.a ,R.drawable.b, R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l,
            R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p,
            R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t,
            R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x,
            R.drawable.y, R.drawable.z};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //thisClass=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_asl);
        //Attach objects to view objects

        translate =(Button) findViewById(R.id.buttonTranslate);
        translate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setString(v);
                translateLetter();
            }
        });
        enterText = (EditText) findViewById(R.id.textInput);
        displayText=(TextView) findViewById(R.id.displayText);
        aslImages=(ImageView) findViewById(R.id.aslViewer);
        aslImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                translateLetter();
            }
        });

        //Select all the Text in the enterText Field
        enterText.setSelectAllOnFocus(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_text_to_asl, menu);
        return true;
    }
    //setString Function
    //Acts when the Translate Button is pressed
    public void setString(View v){
        //Set the text of displayText to'--- '"
        displayText.setText("----");

        // Close Keyboard on lost focus
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        //Reset the Phrase Index
        phraseIndex=0;
        display="";
        //Get the Input Text
        Editable input = enterText.getText();

        //Convert to a string
        String phrase =input.toString();
        letters=phrase.toLowerCase();

    }

    //Displays Image when ImageView Touched.
    // Also displays text of letters already translated
    public void translateLetter(){


        //Checks if letters string is null-displays message
        //If the phrase has not been converted to a string
        if (letters==null){
            displayText.setText("Press the Translate Button ");

        }

        //Checks if letters string is null-will not display
        //ASL letters until translate Button is pressed
        if (letters!=null){
            // Fetch the current Character in the phrase
            char currentLetter = letters.charAt(phraseIndex);

            // add the letter to the display string
            display+=currentLetter;

            //Search for the corresponding ASL image by Index
            for (int i=0; i<letterIndex.length; i++)
            {
                if (letterIndex[i]== currentLetter){
                    //Display the image
                    aslImages.setImageResource(aslPics[i]);

                } //end if
            }// end for
            // Set the text to display the  letters  translated
            displayText.setText(display);

            //Advance to the Next Letter in the Phrase
            phraseIndex++;

            //Check to see if you reach the end of the phrase
            if (phraseIndex > letters.length()-1) {
                // Reset back to the first character
                phraseIndex =0;
                display="";
            } //end if
        }// end Function translateLetter()
    }// end if
}//End Class Main



