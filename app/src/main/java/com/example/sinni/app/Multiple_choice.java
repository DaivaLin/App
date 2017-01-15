package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Multiple_choice extends AppCompatActivity implements View.OnClickListener{
    Button[] button = new Button[4];
    TextView Question,time;
    String[][] quesion_arry =new String[][]{
            {"腳踏車","bicycle"},{"走路","walk"},{"計程車","taxi"},{"地鐵","subway"},{"車站","station"},{"火車", "train"}
            ,{"飛機","aircraft"},{"飛機場","airport"},{"公車","bus"},{"車","car"},{"馬路","road"},{"十字路口","crossroads"},{"地圖","map"},{"地址","address"},{"市","city"},{"國","country"},{"汽車","car"},{"輛","vehicle"},{"船","boat"},{"停車場","parking lot"},{"搭","take"},{"起飛","take off"}
            ,{"出","out"},{"出來","come out"},{"進","progress"},{"進去","go inside"},{"回去","go back"},{"路口","intersection"},{"紅綠燈","traffic light"},{"左","left"},{"右","right"},{"外","outer"},{"裡","in"},{"下","lower"},{"上","on"},{"這邊","here"},{"出發","set off"},{"離開","go away"}
            ,{"向","to"},{"經過","after"},{"停","stop"},{"出口","export"},{"公里","km"},{"方向","direction"},{"出現","appear"},{"交通","traffic"},{"救護車","ambulance"}};
    String[] material=new String[]{"me","country","come","a","this","count","go","as","Male","look","separate","part","push","enter","think","return","fruit","fe","protect","disappear","poem","person","bright"};
    String[] option;
    int number,cou=30;
    int number1=0;
    int count=0,correct=0,wrong=0;
    Random run=new Random();
    int tine=800;
    private Handler handler = new Handler( );
    String Situation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);
        GetButton();
        time = (TextView) findViewById(R.id.time);
        Question = (TextView) findViewById(R.id.Question);
        getBud();
        number = run.nextInt(quesion_arry.length);
        Question.setText(quesion_arry[number][number1]);
        setOptionEn();
        for (int i = 0; i < 4; i++) {
            button[i].setOnClickListener((View.OnClickListener) this);
        }
        handler.post(runnable);

    }

    @Override
    public void onClick(View v) {
        String a = String.valueOf(v.getTag());
        if (a.equals(quesion_arry[number][1])) {
            showToastMessage("正確",tine );
            correct++;

        }else{
            showToastMessage("錯誤",tine );
            wrong++;
        }
        count++;
        if(count<10){
            number = run.nextInt(quesion_arry.length);
            Question.setText(quesion_arry[number][number1]);
            setOptionEn();}else{
            resultAction();
        }
    }

    void GetButton(){
        button[0]=(Button)findViewById(R.id.button3);
        button[1]=(Button)findViewById(R.id.button4);
        button[2]=(Button)findViewById(R.id.button5);
        button[3]=(Button)findViewById(R.id.button6);
    }

    void setOptionEn(){
        option=new String[4];
        option[0]=quesion_arry[number][1];
        option[1]=material[run.nextInt(material.length)];
        option[2]=material[run.nextInt(material.length)];
        option[3]=material[run.nextInt(material.length)];

        RandomArray(option);
        for(int i=0;i<4;i++){
            button[i].setText(option[i]);
            button[i].setTag(option[i]);
        }
    }

    public static String[] RandomArray(String[] mArray){
        int mLength = mArray.length,mRandom ;
        String mNumber;
        for(int i = 0; i < mLength; i++) {
            mRandom = (int)(Math.random() * mLength);
            mNumber = mArray[i];
            mArray[i] = mArray[mRandom];
            mArray[mRandom] = mNumber;
        }
        return mArray;
    }


    public void showToastMessage(String text, int duration){
        final Toast toast = Toast.makeText(Multiple_choice.this, text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }
    void getBud(){
        if(getIntent().getExtras()!=null){
            Bundle bundle1=getIntent().getExtras();
            Situation = bundle1.getString("Situation");
            count=bundle1.getInt("count");
            correct =bundle1.getInt("correct");
            wrong=bundle1.getInt("wrong");
            //         aTextView.setText(String.valueOf(count));
            if(count==10){
                resultAction();
            }
        }
    }
    void resultAction(){
        Intent intent=new Intent();
        intent.setClass(Multiple_choice.this,Multiple_choice_score.class);
        Bundle bundle2=new Bundle();
        bundle2.putInt("count",count);
        bundle2.putInt("correct",correct);
        bundle2.putInt("wrong",wrong);
        intent.putExtras(bundle2);
        startActivity(intent);
        finish();
    }

    private Runnable runnable = new Runnable( ) {
        public void run ( ) {

            if (cou > 0) {
                time.setText(Integer.toString(cou-1));
                cou--;
                handler.postDelayed(runnable, 1000);
            }else{
                resultAction();
            }
        }
    };
}
