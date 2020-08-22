package com.example.suggestions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    ImageView image;
    TextView imageText;
    int[] theimages = {
            R.drawable.amusementpark,
            R.drawable.beach,
            R.drawable.cinema,
            R.drawable.cook,
            R.drawable.football,
            R.drawable.mall,
            R.drawable.nap,
            R.drawable.paint,
            R.drawable.programm,
            R.drawable.skating,
    };
    String[] thetext = {
            "Go To The Amusement Park",
            "Go To The Beach",
            "Go To The Cinema",
            "Cook",
            "Play Football",
            "Go To The Mall",
            "Nap",
            "Paint",
            "Program",
            "Skate",
    };
    int currentIndex = -1;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.theImage);
        imageText = findViewById(R.id.imageText);
        image.setImageDrawable(ContextCompat.getDrawable(this,theimages[0]));
        imageText.setText(thetext[0]);
        random = new Random();
    }

    public void displayBack(View view){
        if ((currentIndex < theimages.length) && (currentIndex>0)){
            currentIndex--;
            Drawable pic = ContextCompat.getDrawable(this,theimages[currentIndex]);
            image.setImageDrawable(pic);
            imageText.setText(thetext[currentIndex]);
        }
        else{
            Toast.makeText(this,"No More",Toast.LENGTH_SHORT).show();
        }
    }

    public void displayNext(View view){
        if (currentIndex < (theimages.length-1)){
            currentIndex++;
            Drawable pic = ContextCompat.getDrawable(this,theimages[currentIndex]);
            image.setImageDrawable(pic);
            imageText.setText(thetext[currentIndex]);
        }
        else{
            Toast.makeText(this,"No More",Toast.LENGTH_SHORT).show();
        }
    }

    public void displayRandom(View view){
        if (currentIndex < (theimages.length)){
            currentIndex=random.nextInt(10);
            Drawable pic = ContextCompat.getDrawable(this,theimages[currentIndex]);
            image.setImageDrawable(pic);
            imageText.setText(thetext[currentIndex]);
        }
        else{
            Toast.makeText(this,"No More",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX,currentIndex);
        Log.i(TAG,"OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
            if (currentIndex != -1){
                Drawable pic = ContextCompat.getDrawable(this,theimages[currentIndex]);
                image.setImageDrawable(pic);
                imageText.setText(thetext[currentIndex]);
            }
        }
        Log.i(TAG,"OnRestoreInstanceState");
    }
}