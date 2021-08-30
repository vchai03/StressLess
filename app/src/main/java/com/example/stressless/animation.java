package com.example.stressless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class animation extends AppCompatActivity {

    private animation_layout animation_layoutview;
    private Button startPause;
    private boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XmlPullParser parser = getResources().getXml(R.xml.activity_animation);
        AttributeSet attributes = Xml.asAttributeSet(parser);

        animation_layoutview = new animation_layout(this, attributes);
        setContentView(R.layout.activity_animation);

        LinearLayout surface = findViewById(R.id.animation_layout);

        surface.addView(animation_layoutview);

        startPause = findViewById(R.id.button2);

        startPause.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                if(running){
                    onPause();
                }
                else{
                    onResume();
                }
            }
        });

    }

    protected void onPause(){
        super.onPause();
        animation_layoutview.pause();
        startPause.setText("Start");
        running = false;

    }

    protected void onResume(){
        super.onResume();
        animation_layoutview.resume();
        startPause.setText("Restart");
        running = true;

    }
}

