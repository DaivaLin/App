package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Learn_or_test extends AppCompatActivity {

    TextView Learn,Test ;
    String Situation,Word_or_Voc;
    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_or_test);

        intent = new Intent();
        bundle = this.getIntent().getExtras();
        Word_or_Voc = bundle.getString("Word_or_Voc");
        Situation = bundle.getString("Situation");
        bundle = new Bundle();


        Learn = (TextView) findViewById(R.id.Learn);
        Learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
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

            }
        });

        Test = (TextView) findViewById(R.id.Test);
        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("Situation", Situation);
                bundle.putString("Word_or_Voc", Word_or_Voc);
                bundle.putString("Learn_or_Test", "Test");
                switch (Word_or_Voc){
                    case "Word":
                        intent = new Intent(Learn_or_test.this,Learn_word.class);
                        break;
                    case "Voc":
                        intent = new Intent(Learn_or_test.this,TextMultiple.class);
                        break;
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
