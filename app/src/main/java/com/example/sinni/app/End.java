package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class End extends AppCompatActivity {
    TextView count,correct,wrong;
    int count1,correct1,wrong1;
    String Situation,Word_or_Voc;
    ImageView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        count=(TextView)findViewById(R.id.count);
        correct=(TextView)findViewById(R.id.correct);
        wrong=(TextView)findViewById(R.id.wrong);
        re=(ImageView)findViewById(R.id.re);
        if(getIntent().getExtras()!=null){
            Bundle bundle3=getIntent().getExtras();
            Situation = bundle3.getString("Situation");
            Word_or_Voc = bundle3.getString("Word_or_Voc");
            count1=bundle3.getInt("count");
            correct1 =bundle3.getInt("correct");
            wrong1=bundle3.getInt("wrong");
            count.setText(String.valueOf(count1));
            correct.setText(String.valueOf(correct1));
            wrong.setText(String.valueOf(wrong1));
        }
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(End.this,word_and_voc.class);
                Bundle bundle4=new Bundle();
                bundle4.putString("Situation",Situation);
                bundle4.putString("Word_or_Voc",Word_or_Voc);
                intent.putExtras(bundle4);
                startActivity(intent);
                finish();
            }
        });
    }
}
