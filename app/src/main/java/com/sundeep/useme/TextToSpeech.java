package com.sundeep.useme;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TextToSpeech extends AppCompatActivity {

   EditText edtEntertext;
    Button btnTextTOSpeech;

 android.speech.tts.TextToSpeech textToSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        edtEntertext = findViewById(R.id.edt_enterText);
        btnTextTOSpeech = findViewById(R.id.btn_Speak);



     textToSpeech = new android.speech.tts.TextToSpeech(TextToSpeech.this, new android.speech.tts.TextToSpeech.OnInitListener() {
         @Override
         public void onInit(int status) {

             if(status == android.speech.tts.TextToSpeech.SUCCESS)
             {


                 //Init text to speech

                 int result = textToSpeech.setLanguage(Locale.ENGLISH);
                 if(result == android.speech.tts.TextToSpeech.LANG_MISSING_DATA ||
                 result == android.speech.tts.TextToSpeech.LANG_NOT_SUPPORTED)
                 {
                     Toast.makeText(TextToSpeech.this,"This Language is not Supported", Toast.LENGTH_SHORT).show();
                 }

                 else
                 {
                     btnTextTOSpeech.setEnabled(true);
//                     textToSpeech.setPitch(0.5f);
//                     textToSpeech.setSpeechRate(1.0f);

                     speak();
                 }
             }
         }
     });

   btnTextTOSpeech.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           speak();
       }
   });

    }

    private void speak() {

        String text = edtEntertext.getText().toString();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            textToSpeech.speak(text, android.speech.tts.TextToSpeech.QUEUE_FLUSH,null,null);

        else
        {
            textToSpeech.speak(text, android.speech.tts.TextToSpeech.QUEUE_FLUSH,null);
        }

    }

    @Override
    protected void onDestroy() {
// Do not forget to Shutdown Text to Speech when you close app
        if(textToSpeech != null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
