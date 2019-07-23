package com.sundeep.useme;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnFaceDetect, btnScanner, btnTextRecognizer, btnTextSpeech;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFaceDetect = findViewById(R.id.btn_faceDetect);
        btnScanner = findViewById(R.id.btn_scanner);
        btnTextRecognizer = findViewById(R.id.btn_textRecognizer);
        btnTextSpeech = findViewById(R.id.btn_textSpeech);


        btnFaceDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FaceDetect.class);
                startActivity(intent);
            }
        });


        btnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Scanner.class);
                startActivity(intent);
            }
        });

        btnTextRecognizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TextRecognizer.class);
                startActivity(intent);
            }
        });


        btnTextSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TextToSpeech.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public void onBackPressed() {


        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();


    }


}
