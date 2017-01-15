package com.example.sinni.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static android.R.attr.duration;

public class UnderTheThreePacks extends AppCompatActivity {
    //下三包字判斷
    int[] animationword =new int[]{};
    int[][] animationword1 = new int[][]{{}};
    int[][] animationword2= new int[][]{{}};

    ImageView traditional;
    ImageView[] img = new ImageView[2];
    GifAnimationDrawable gif;
    float x, y;
    int mx, my; // 圖片被拖曳的X ,Y軸距離長度
    String backgroundImageName;
    int a=0,tine=800,ca=0;
    TextView textView1,textView2;
    Handler handler= new Handler();
    int count1=0;
    Button re;
    String  Situation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_layout);

        textView1=(TextView)findViewById(R.id.textView) ;
        textView2=(TextView)findViewById(R.id.textView2);
        traditional = (ImageView) findViewById(R.id.traditional);
        GetImageView();

        if(getIntent().getExtras()!=null){
            Bundle bundle3=getIntent().getExtras();
            Situation = bundle3.getString("Situation");
            count1=bundle3.getInt("count");
            if (count1==4){
                count1=0;
            }
        }
        picture();
        handler.postDelayed(new Runnable(){
            public void run() {
                setanimationword1Img();
                SetImge();
                for (int i = 0; i<img.length; i++) {
                    img[i].setOnTouchListener(imgListener);//觸控時監聽.
                }
            }
        }, 3000);   //5秒

    }

    //動畫
    public void picture() {
        try{
            gif = new GifAnimationDrawable(getResources().openRawResource(animationword[count1]));// 取得 Gif 動畫檔
            traditional.setImageDrawable(gif); // Gif Drawable 設定給 ImageView
            gif.setOneShot(true); // 只播放一次
        }catch (IOException ioe){

        }finally{

        }
    }
    //初始畫UI
    public void GetImageView() {
        img[0] = (ImageView) findViewById(R.id.part1);
        img[1] = (ImageView) findViewById(R.id.part2);
        img[2] = (ImageView) findViewById(R.id.part3);
    }
    //給取圖片
    public void SetImge() {
        for (int i =0; i<animationword2[count1].length; i++){
            Log.e(String.valueOf(count1),String.valueOf(animationword2[count1][i])) ;
            img[i].setImageDrawable(ContextCompat.getDrawable(this,animationword2[count1][i]));
            img[i].setTag(animationword2[count1][i]);
        }
    }
    //圖片監聽
    View.OnTouchListener imgListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // Log.e("View", v.toString());
            switch (event.getAction()) {          //判斷觸控的動作

                case MotionEvent.ACTION_DOWN:// 按下圖片時
                    x = event.getX();//觸控的X軸位置
                    y = event.getY();//觸控的Y軸位置
                case MotionEvent.ACTION_MOVE:// 移動圖片時

                    //getX()：是獲取當前控件(View)的座標
                    //getRawX()：是獲取相對顯示螢幕左上角的座標

                    mx = (int) (event.getRawX() - x);
                    my = (int) (event.getRawY() - y - 150);
                    v.layout(mx,my, mx + v.getWidth(), my + v.getHeight());
                    break;
                case MotionEvent.ACTION_UP:
                    if(mx >= 50 && mx <= 450 && my >= 20 && my <= 400){
                        Utt(v);//下三包字判斷
                    }
                break;
            }
            Log.d("address", String.valueOf(mx) + "~~" + String.valueOf(my)); // 記錄目前位置
            return true;
        }
    };
    //下三包字判斷
    public void Utt(View v){
        backgroundImageName = String.valueOf(v.getTag());
        if(a==0){
            if(mx >= 150 && mx <= 350 && my >= 20 && my <= 210){
                if(backgroundImageName.equals(String.valueOf(animationword2[count1][0]))){
                    v.setVisibility(View.INVISIBLE);
                    a++;
                    // traditional.setImageResource(animationword1[count1][1]);
                    traditional.setImageDrawable(ContextCompat.getDrawable(this,animationword1[count1][1]));
                    showToastMessage("正確",tine);
                }else{
                    showToastMessage("錯誤",tine);
                }
            }else{
                showToastMessage("錯誤",tine);
            }
        }else{
            if(!(mx>=150 && mx<=350 && my>=20&& my<=210)){
                if(backgroundImageName.equals(String.valueOf(animationword2[count1][1]))){
                    v.setVisibility(View.INVISIBLE);
                    //traditional.setImageResource(animationword1[count1][2]);
                    traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count1][2]));
                    showToastMessage("正確",tine);
                    a++;
                    //SetStart();
                }else{
                    showToastMessage("錯誤",tine);
                }
            }else{
                showToastMessage("錯誤",tine);
            }
        }
    }
    public void showToastMessage(String text, int duratin){
        final Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }
    private void SetStart() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UnderTheThreePacks.this);

        builder.setMessage("正確")
                .setCancelable(false)
                .setPositiveButton("next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Refresh();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void Refresh() {
        //自己调到自己的activity
        //  finish();
        Intent intent  = new Intent(UnderTheThreePacks.this,LeftLowerPack.class);
        Bundle bundle = new Bundle();
        count1++;
        bundle.putInt("count",count1);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
    void setanimationword1Img(){
        traditional.setImageResource(animationword1[count1][0]);
    }
}



