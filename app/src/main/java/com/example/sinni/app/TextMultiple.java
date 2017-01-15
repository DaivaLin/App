package com.example.sinni.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.sinni.app.Multiple_choice.RandomArray;

public class TextMultiple extends AppCompatActivity implements View.OnClickListener {
    Button[] button = new Button[4];
    TextView Question,a2a,time;
    int rand, count=0, correct=0, wrong=0,cou=30;
    String [] vocmean=new String[]{null};
    String [] vocabulary=new String[]{null};
    String [] buttonAnswer=new String[]{null};
    String Situation=null, answer=null;
    Handler handler=new Handler();
    Random run=new Random();
    //private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_multiple);
        findView();
        setSituation();
       // tts = new TextToSpeech(this, this);
        // tts.speak(vocabulary[0], TextToSpeech.QUEUE_FLUSH, null); //發音
        setQuestion();
        setButton(); // button塞值
        //countDownTimer(); //倒數計時器
        for (int i = 0; i < 4; i++) {
            button[i].setOnClickListener(this);
        }
        handler.post(runnable);
    }
    void findView(){
        Question = (TextView) findViewById(R.id.Question);
        a2a = (TextView) findViewById(R.id.a2a);
        time = (TextView) findViewById(R.id.time);
        button[0] = (Button)findViewById(R.id.button3);
        button[1] = (Button)findViewById(R.id.button4);
        button[2] = (Button)findViewById(R.id.button5);
        button[3] = (Button)findViewById(R.id.button6);
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
    void setQuestion(){
        rand=run.nextInt(vocabulary.length);
        Question.setText(vocabulary[rand]);
        answer=vocmean[rand];
    }
    void setButton(){
        buttonAnswer = new String[4];
        buttonAnswer[0] = answer;
        buttonAnswer[1] = vocmean[run.nextInt(vocmean.length)];
        buttonAnswer[2] = vocmean[run.nextInt(vocmean.length)];
        buttonAnswer[3] = vocmean[run.nextInt(vocmean.length)];
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
        setQuestion();
        setButton();
        if(count==10){
            resultAction(); //以達到10題，結算
        }
    }
    private Runnable runnable = new Runnable() {
        public void run() {
            if (cou > 0) {
                time.setText(Integer.toString(cou - 1));
                cou--;
                handler.postDelayed(runnable, 1000);
            }else{
                resultAction();
            }
        }
    };
   /* public void onInit(int status) {
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
        }else{
            Log.e("TTS", "Initilization Failed!");
        }
    }
    @Override
    public void onDestroy() {
        // shutdown tts
        if (tts != null){
            tts.stop();
            tts.shutdown();
        }
    }*/
    void resultAction(){
        Intent intent=new Intent();
        intent.setClass(TextMultiple.this,word_and_voc.class);
        Bundle bundle2=new Bundle();
        bundle2.putInt("count",count);
        bundle2.putInt("correct",correct);
        bundle2.putInt("wrong",wrong);
        bundle2.putString("Situation", Situation);
        intent.putExtras(bundle2);
        startActivity(intent);
        finish();
    }

}
