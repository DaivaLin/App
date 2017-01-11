package com.example.sinni.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Multiple_choice_score extends AppCompatActivity {
    TextView count,correct,wrong;
    int count1,correct1,wrong1;
    Button go_back;
    String Situation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_score);

        count=(TextView)findViewById(R.id.count);
        correct=(TextView)findViewById(R.id.correct);
        wrong=(TextView)findViewById(R.id.wrong);
        go_back=(Button)findViewById(R.id.go_back);
        Bundle bundle = this.getIntent().getExtras();

            Situation = bundle.getString("Situation");
            count1=bundle.getInt("count");
            correct1 =bundle.getInt("correct");
            wrong1=bundle.getInt("wrong");

//        count.setText(getText(count1).toString());
//        correct.setText(getText(correct1).toString());
//        wrong.setText(getText(wrong1).toString());
            count.setText(String.valueOf(count1));
            correct.setText(String.valueOf(correct1));
            wrong.setText(String.valueOf(wrong1));

//        go_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent();
//                intent.setClass(Multiple_choice_score.this,Home_page.class);
//                //intent.putExtra("Situation", Situation);
//                startActivity(intent);
//                //finish();
//            }
//        });
    }
}
