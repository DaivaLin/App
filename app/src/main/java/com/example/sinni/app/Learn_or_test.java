package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Learn_or_test extends AppCompatActivity {

    TextView Learn,Test ;
    String Situation,Word_or_Voc;
    Bundle bundle,bundle1;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_or_test);
        if(this.getIntent().getExtras()!=null) {
            bundle1 = this.getIntent().getExtras();
            Word_or_Voc = bundle1.getString("Word_or_Voc");
            Situation = bundle1.getString("Situation");
        }

        Learn = (TextView) findViewById(R.id.Learn);
        Learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                bundle = new Bundle();
                bundle.putString("Situation", Situation);
                bundle.putString("Word_or_Voc", Word_or_Voc);
                bundle.putString("Learn_or_Test", "Learn");
               // Toast.makeText(getApplicationContext(), "你選擇" +Word_or_Voc+Situation, Toast.LENGTH_SHORT).show();
                switch (Word_or_Voc){
                    case "Word":
                        intent = new Intent(Learn_or_test.this,Learn_word.class);
                        break;
                    case "Voc":
                        intent = new Intent(Learn_or_test.this,Learn_voc.class);
                        break;
                }
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }});

        Test = (TextView) findViewById(R.id.Test);

        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Word_or_Voc){
                    case "Word":
                        bundle = new Bundle();
                        bundle.putString("Situation", Situation);
                        bundle.putString("Word_or_Voc", Word_or_Voc);
                        bundle.putString("Learn_or_Test", "Test");
                        intent = new Intent(Learn_or_test.this,StructureExercise.class);

                        break;
                    case "Voc":
                        bundle = new Bundle();
                        bundle.putString("Situation", Situation);
                        bundle.putString("Word_or_Voc", Word_or_Voc);
                        bundle.putString("Learn_or_Test", "Test");
                        intent = new Intent(Learn_or_test.this,TextMultiple.class);
                        intent.putExtras(bundle);
                        break;
                }
                startActivity(intent);
                finish();
            }});
    }
}
