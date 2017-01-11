package com.example.sinni.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

import static com.example.sinni.app.Multiple_choice.RandomArray;

public class text_multiple extends AppCompatActivity implements TextToSpeech.OnInitListener,View.OnClickListener {
    Button[] button = new Button[4];
    TextView Question,time,a2a;
    int rand, length, count=0, correct=0, wrong=0;;
    String [] vocmean;
    String [] vocabulary;
    String [] buttonAnswer ;
    String Situation, answer;
    Random run=new Random(); //產生亂數
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_multiple);
        findView();
        CountDownTimer(); //倒數計時器
        //setSituation();  //情境選擇
        setSituation();

        tts = new TextToSpeech(this, this);
       // tts.speak(vocabulary[0], TextToSpeech.QUEUE_FLUSH, null);     //發音
        setQuestion();
        for (int i = 0; i < 4; i++) {
            button[i].setOnClickListener((View.OnClickListener) this);
        }
    }
    void setQuestion(){
        length = vocabulary.length;
        rand= (int)(Math.random()*length)+1;
        Question.setText(vocabulary[rand]);
        answer = vocmean[rand];
        tts.speak(vocabulary[rand], TextToSpeech.QUEUE_FLUSH, null);
        SetButton(); // button塞值
    }
    void findView(){
        Question = (TextView) findViewById(R.id.Question);
        button[0] = (Button)findViewById(R.id.button3);
        button[1] = (Button)findViewById(R.id.button4);
        button[2] = (Button)findViewById(R.id.button5);
        button[3] = (Button)findViewById(R.id.button6);
        time = (TextView) findViewById(R.id.time);
        a2a = (TextView) findViewById(R.id.a2a);
    }
    void SetButton(){
        buttonAnswer = new String[4];
        buttonAnswer[0] = answer;
        buttonAnswer[1] = vocmean[run.nextInt(length)];
        buttonAnswer[2] = vocmean[run.nextInt(length)];
        buttonAnswer[3] = vocmean[run.nextInt(length)];
        a2a.setText(answer);
        RandomArray(buttonAnswer);
        for(int i=0;i<4;i++){
            button[i].setText(buttonAnswer[i]);
            button[i].setTag(buttonAnswer[i]);
        }
    }

    @Override
    public void onClick(View v) {
        String a = String.valueOf(v.getTag());
        if (a.equals(answer)) {
            Toast.makeText(getApplicationContext(),"正確",Toast.LENGTH_SHORT).show();
           // showToastMessage("正確",tine );
            correct++;

        }else{
            Toast.makeText(getApplicationContext(),"錯誤",Toast.LENGTH_SHORT).show();
            wrong++;
        }
        count++;
        if(count<10){
            setQuestion();}
        else{
            ResultAction(); //以達到10題，結算
        }
    }
    void CountDownTimer(){
        new CountDownTimer(30000,1000){
    //            CounDownTimer(總共倒數多少秒 , 每次扣多少)
    //            每1000為一秒, 所以30000 = 30 秒 , 1000 = 1秒
            @Override
            public void onFinish() {
                ResultAction();
            }
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished/1000);
            }
        }.start();
    }

    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.TAIWAN);    //設定語言
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                tts.setPitch((float) 1);    //語調(1為正常語調；0.5比正常語調低一倍；2比正常語調高一倍)
                tts.setSpeechRate((float) 0.5);    //速度(1為正常速度；0.5比正常速度慢一倍；2比正常速度快一倍)
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
    @Override
    public void onDestroy() {
        // shutdown tts
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
    void ResultAction(){
//        Intent intent=new Intent();
//        intent.setClass(text_multiple.this,Multiple_choice_score.class);
//        Bundle bundle2=new Bundle();
//        bundle2.putInt("count",count);
//        bundle2.putInt("correct",correct);
//        bundle2.putInt("wrong",wrong);
//        bundle2.putString("Situation", Situation);
//        intent.putExtras(bundle2);
//        startActivity(intent);
//        finish();


        Intent intent = new Intent(text_multiple.this,Multiple_choice_score.class);
        intent.putExtra("count",count);
        intent.putExtra("correct",correct);
        intent.putExtra("wrong",wrong);
        intent.putExtra("Situation", Situation);
        startActivity(intent);
        finish();
    }
    void setSituation(){
        Bundle bundle = this.getIntent().getExtras();
        Situation = bundle.getString("Situation");
        Resources res = getResources();
        switch (Situation){
            case "food":
                vocmean = res.getStringArray (R.array.easy_food_arry);
                vocabulary = res.getStringArray (R.array.easy_food_vocabulary);
                break;
            case "shopping":
                vocmean = res.getStringArray (R.array.easy_shopping_arry);
                vocabulary = res.getStringArray (R.array.easy_shopping_vocabulary);
                break;
            case "car":
                vocmean = res.getStringArray (R.array.easy_car_arry);
                vocabulary = res.getStringArray (R.array.easy_car_vocabulary);
                break;
        }
    }
}
