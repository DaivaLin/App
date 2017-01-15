package com.example.sinni.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class word_and_voc extends AppCompatActivity {
    TextView Vocabulary,Word;
    String Situation;
    Bundle bundle;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_and_voc);
        setTitle("Choose");
        bundle = getIntent().getExtras();
        Situation = bundle.getString("Situation");

        Vocabulary = (TextView) findViewById(R.id.Vocabulary);
        Vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(word_and_voc.this,Learn_voc.class);
                bundle = new Bundle();
                bundle.putString("Situation", Situation);

                // Toast.makeText(getApplicationContext(), "你選擇" +Situation, Toast.LENGTH_SHORT).show();

                intent.putExtras(bundle);


                startActivity(intent);
            }
        });

        Word = (TextView) findViewById(R.id.Word);
        Word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(word_and_voc.this,Learn_word.class);
                bundle = new Bundle();
                bundle.putString("Situation", Situation);


                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
