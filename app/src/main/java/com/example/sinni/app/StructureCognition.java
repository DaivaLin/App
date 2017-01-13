package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class StructureCognition extends AppCompatActivity {
    ImageView a1,b2;
   // Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_cognition);
        setTitle("Home Page");

        a1 = (ImageView) findViewById(R.id.imageView2);
        b2 = (ImageView) findViewById(R.id.imageView8);
        // bundle = new Bundle();
        intent = new Intent();
        //結構學習
        a1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               intent = new Intent(StructureCognition.this,StructureTeaching.class);
               //bundle.putString("Situation", "food");
               // intent.putExtras(bundle);
               startActivity(intent);
           }
       });
  //快拼快打
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(StructureCognition.this, StructureExercise.class);
                //bundle.putString("Situation", "shopping");
                //intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
