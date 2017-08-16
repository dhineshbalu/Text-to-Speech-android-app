package com.example.texttospeech;

import java.util.Locale;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	 TextToSpeech tts;
	  EditText et;
	 Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button1);
        et=(EditText) findViewById(R.id.editText1);
        tts=new TextToSpeech(this, new OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status!=TextToSpeech.ERROR)
				{
					tts.setLanguage(Locale.CHINESE);
				}
			}
		});
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String text=et.getText().toString();
				
				tts.speak(text, TextToSpeech.QUEUE_FLUSH,null);
			}
		});
    }
 public void onPause()
 {
	 if(tts!=null)
	 {
		 tts.stop();
		 tts.shutdown();
		 
	 }
	 super.onPause();
 }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
