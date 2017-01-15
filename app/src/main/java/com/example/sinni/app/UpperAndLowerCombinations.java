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
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class UpperAndLowerCombinations extends AppCompatActivity {
    int[] animationword =new int[]{R.raw.animationword101,R.raw.animationword104,R.raw.animationword107,R.raw.animationword1010,R.raw.animationword1013,R.raw.animationword1016,R.raw.animationword1019,R.raw.animationword1022};
    int[][] animationword1 = new int[][]{{R.drawable.first101,R.drawable.first102,R.drawable.first103}, {R.drawable.first104, R.drawable.first105, R.drawable.first106}, {R.drawable.first107, R.drawable.first108, R.drawable.first109},{R.drawable.first1010, R.drawable.first1011, R.drawable.first1012},{R.drawable.first1013, R.drawable.first1014, R.drawable.first1015},{R.drawable.first1016, R.drawable.first1017, R.drawable.first1018},{R.drawable.first1019, R.drawable.first1020, R.drawable.first1021},{R.drawable.first1022, R.drawable.first1023, R.drawable.first1024}};
    int[][] animationword2 = new int[][]{{R.drawable.part31, R.drawable.part32}, {R.drawable.part40, R.drawable.part94}, {R.drawable.part30, R.drawable.part18}, {R.drawable.part28, R.drawable.part16}, {R.drawable.part24, R.drawable.part57}, {R.drawable.part19, R.drawable.part15}, {R.drawable.part70, R.drawable.part64}, {R.drawable.part91, R.drawable.part72}, {R.drawable.part5, R.drawable.part10}, {R.drawable.part39, R.drawable.part29}, {R.drawable.part12, R.drawable.part9}};
    ImageView traditional=null;
    ImageView[] img = new ImageView[2];
    GifAnimationDrawable gif;
    float x=0, y=0;
    int mx=0, my=0; // 圖片被拖曳的X ,Y軸距離長度
    String backgroundImageName=null;
    int a=0,tine=500,ca=0;
    TextView textView1,textView2;
    Handler handler= new Handler();
   String Situation;
    int count1=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.all_layout);

            textView1=(TextView)findViewById(R.id.textView) ;
            textView2=(TextView)findViewById(R.id.textView2);
            traditional = (ImageView) findViewById(R.id.traditional);
            getImageView();
            if(getIntent().getExtras()!=null){
                Bundle bundle3=getIntent().getExtras();
                Situation = bundle3.getString("Situation");
                count1=bundle3.getInt("count");
            }
            if (count1==animationword.length){
                count1=0;
            }
            picture();
            handler.postDelayed(new Runnable(){
                public void run() {
                    traditional.setImageDrawable(ContextCompat.getDrawable(UpperAndLowerCombinations.this,animationword1[count1][0]));
                    setImge();
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
        public void getImageView() {
            img[0] = (ImageView) findViewById(R.id.part1);
            img[1] = (ImageView) findViewById(R.id.part2);
        }
        //給取圖片
        public void setImge() {
            for (int i =0; i<animationword2[count1].length; i++){
                // Log.e(String.valueOf(count1),String.valueOf(animationword2[count1][i])) ;
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
                    case MotionEvent.ACTION_UP:// 離開圖片時
                        if(mx >= 50 && mx <= 450 && my >= 20 && my <= 400){
                            about(v);//上下字判斷
                        }
                    break;
                }
                Log.d("address", String.valueOf(mx) + "~~" + String.valueOf(my)); // 記錄目前位置
                return true;
            }
        };
        public void about(View v){
            backgroundImageName = String.valueOf(v.getTag());
            if(a==0){
                if (mx >= 50 && mx <= 450 && my >= 0 && my <= 150) {
                    if(backgroundImageName.equals(String.valueOf(animationword2[count1][0]))) {
                        v.setVisibility(View.INVISIBLE);
                        a++;
                        traditional.setImageDrawable(ContextCompat.getDrawable(UpperAndLowerCombinations.this,animationword1[count1][1]));
                        //  traditional.setImageResource(animationword1[count1][1]);
                        //showToastMessage("正確",tine);
                    }else{
                        //showToastMessage("錯誤",tine);
                    }
                }else{
                   // showToastMessage("錯誤",tine);
                }
            }else{
                if (mx >= 50 && mx <= 450 && my >= 150 && my <= 400) {
                    if(backgroundImageName.equals(String.valueOf(animationword2[count1][1])))
                    {
                        v.setVisibility(View.INVISIBLE);
                        traditional.setImageDrawable(ContextCompat.getDrawable(this,animationword1[count1][2]));
                        //showToastMessage("正確",tine);
                        a++;
                        setStart();
                    }else{
                        //showToastMessage("錯誤",tine);
                    }
                }else{
                    //showToastMessage("錯誤",tine);
                }
            }
        }
        private void setStart() {
            String right = getString(R.string.right);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(right)
                    .setCancelable(false)
                    .setPositiveButton("next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            refresh();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        public void refresh() {
            //自己调到自己的activity
            //  finish();
            count1++;
            Intent intent  = new Intent(UpperAndLowerCombinations.this, UpperAndLowerCombinations.class);
            Bundle bundle = new Bundle();
            bundle.putInt("count",count1);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }


