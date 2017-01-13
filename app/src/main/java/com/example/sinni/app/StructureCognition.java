package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
public class StructureCognition extends AppCompatActivity {
    //結構學習選擇畫面
    Button a,b;
   // Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_cognition);
        setTitle("Home Page");
        a = (Button) findViewById(R.id.button7);
        b=(Button)findViewById(R.id.button8);
        // bundle = new Bundle();
        intent = new Intent();
//結構學習
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(StructureCognition.this,StructureTeaching.class);
            //bundle.putString("Situation", "food");
           // intent.putExtras(bundle);
            startActivity(intent);
            }
        });
  //快拼快打
        b.setOnClickListener(new View.OnClickListener() {
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
