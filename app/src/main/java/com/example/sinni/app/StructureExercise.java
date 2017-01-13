package com.example.sinni.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.attr.duration;

public class StructureExercise extends AppCompatActivity implements View.OnClickListener {
//結構快拼快打
ImageView traditional;
    TextView timev;
    ImageView[] imageButton = new ImageView[6];
    int[][] animationword1 = new int[][]{{R.drawable.first101,R.drawable.first102,R.drawable.first103}, {R.drawable.first104, R.drawable.first105, R.drawable.first106}, {R.drawable.first107, R.drawable.first108, R.drawable.first109},{R.drawable.first1010, R.drawable.first1011, R.drawable.first1012},{R.drawable.first1013, R.drawable.first1014, R.drawable.first1015},{R.drawable.first1016, R.drawable.first1017, R.drawable.first1018},{R.drawable.first1019, R.drawable.first1020, R.drawable.first1021},{R.drawable.first1022, R.drawable.first1023, R.drawable.first1024},{R.drawable.first111,	R.drawable.first112,	R.drawable.first113},
            { R.drawable.first114,R.drawable.first115	,R.drawable.first116}
            ,{R.drawable.first117,	R.drawable.first118,	R.drawable.first119}
    };
    int[][] animationword2 = new int[][]{{R.drawable.part31, R.drawable.part32}
                                        , {R.drawable.part40, R.drawable.part94}
                                        , {R.drawable.part30, R.drawable.part18}
                                        , {R.drawable.part28, R.drawable.part16}
                                        , {R.drawable.part24, R.drawable.part57}
                                        , {R.drawable.part19, R.drawable.part15}
                                        , {R.drawable.part70, R.drawable.part64}
                                        , {R.drawable.part91, R.drawable.part72}
                                        , {R.drawable.part5, R.drawable.part10}
                                        , {R.drawable.part39, R.drawable.part29}
                                        , {R.drawable.part12, R.drawable.part9}
                                        };
    int[] animationword3 = new int[6];
    int[] animationword4 = new int[]{R.drawable.part0,R.drawable.part1,R.drawable.part2,R.drawable.part3,R.drawable.part4,R.drawable.part5,R.drawable.part6,R.drawable.part7,R.drawable.part8,R.drawable.part9,R.drawable.part10,R.drawable.part11,R.drawable.part12,R.drawable.part13,R.drawable.part14,R.drawable.part15,R.drawable.part16,R.drawable.part17,R.drawable.part18,R.drawable.part19,R.drawable.part20,R.drawable.part21,R.drawable.part22,R.drawable.part23,R.drawable.part24,R.drawable.part25,R.drawable.part26,R.drawable.part27,R.drawable.part28,R.drawable.part29,R.drawable.part30,R.drawable.part31,R.drawable.part32,R.drawable.part33,R.drawable.part34,R.drawable.part35,R.drawable.part36,R.drawable.part37,R.drawable.part38,R.drawable.part39,R.drawable.part40,R.drawable.part41,R.drawable.part42,R.drawable.part43,R.drawable.part44,R.drawable.part45,R.drawable.part47,R.drawable.part48,R.drawable.part49,R.drawable.part50,R.drawable.part51,R.drawable.part52,R.drawable.part53,R.drawable.part54,R.drawable.part55,R.drawable.part56,R.drawable.part57,R.drawable.part58,R.drawable.part59,R.drawable.part60,R.drawable.part61,R.drawable.part62,R.drawable.part63,R.drawable.part64,R.drawable.part65,R.drawable.part67,R.drawable.part68,R.drawable.part69,R.drawable.part70,R.drawable.part71,R.drawable.part72,R.drawable.part73,R.drawable.part74,R.drawable.part75,R.drawable.part76,R.drawable.part77,R.drawable.part78,R.drawable.part79,R.drawable.part80,R.drawable.part81,R.drawable.part82,R.drawable.part83,R.drawable.part84,R.drawable.part85,R.drawable.part86,R.drawable.part87,R.drawable.part88,R.drawable.part89,R.drawable.part90,R.drawable.part91,R.drawable.part92,R.drawable.part93,R.drawable.part94,R.drawable.part95,R.drawable.part96,R.drawable.part97,R.drawable.part98};
    String backgroundImageName;
    int time = 100, count = 0, correct = 0, wrong = 0, a = 0, cou = 31;
    Random ran = new Random();
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_exercise);

        timev = (TextView) findViewById(R.id.textView);
        GetImageView();
        SetImge();
        for (int i = 0; i < imageButton.length; i++) {
            imageButton[i].setOnClickListener(this);
        }
        handler.post(runnable);
    }
    //初始畫UI
    public void GetImageView() {
        traditional = (ImageView) findViewById(R.id.traditional);
        imageButton[0] = (ImageView) findViewById(R.id.imageView7);
        imageButton[1] = (ImageView) findViewById(R.id.imageView6);
        imageButton[2] = (ImageView) findViewById(R.id.image);
        imageButton[3] = (ImageView) findViewById(R.id.imageView3);
        imageButton[4] = (ImageView) findViewById(R.id.imageView4);
        imageButton[5] = (ImageView) findViewById(R.id.imageView5);
    }

    //給取圖片
    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void SetImge() {
        traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][0]));
        for (int i = 0; i < animationword2[count].length; i++)
            animationword3[i] = animationword2[count][i];
        for (int i = animationword2[count].length; i < 6; i++)
            animationword3[i] = animationword4[ran.nextInt(animationword4.length)];
        RandomArray(animationword3);
        for (int i = 0; i < animationword3.length; i++) {
            imageButton[i].setImageDrawable(ContextCompat.getDrawable(this, (animationword3[i])));
            imageButton[i].setTag(animationword3[i]);
        }
    }

    @Override
    public void onClick(View v) {
        switch (animationword2[count].length) {
            case 2:
                Two(v);
                break;
            case 3:
                Three(v);
                break;
            case 4:
                Four(v);
                break;
            case 5:
                Fives(v);
                break;
            case 6:
                Six(v);
                break;
        }
    }
    //2
    public void Two(View v) {
        backgroundImageName = String.valueOf(v.getTag());
        if (a == 0) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][0]))) {
                // v.setVisibility(View.INVISIBLE);
                a++;
                //Resources resources = getResources();
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][1]));
                showToastMessage("正確", time);
            } else {
                wrong++;
                Again();
                showToastMessage("錯誤", time);
            }
        } else if (a == 1) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][1]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][2]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }
    }
    //3
    public void Three(View v) {
        backgroundImageName = String.valueOf(v.getTag());
        if (a == 0) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][0]))) {
                // v.setVisibility(View.INVISIBLE);
                a++;
                //Resources resources = getResources();
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][1]));
                showToastMessage("正確", time);
            } else {
                wrong++;
                Again();
                showToastMessage("錯誤", time);
            }
        } else if (a == 1) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][1]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][2]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        } else if (a == 2) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][2]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][3]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }
    }
    //4
    public void Four(View v) {
        backgroundImageName = String.valueOf(v.getTag());
        if (a == 0) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][0]))) {
                // v.setVisibility(View.INVISIBLE);
                a++;
                //Resources resources = getResources();
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][1]));
                showToastMessage("正確", time);
            } else {
                wrong++;
                Again();
                showToastMessage("錯誤", time);
            }
        } else if (a == 1) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][1]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][2]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 2) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][2]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][3]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 3) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][3]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][4]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }
    }
    //5
    public void Fives(View v) {
        backgroundImageName = String.valueOf(v.getTag());
        if (a == 0) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][0]))) {
                // v.setVisibility(View.INVISIBLE);
                a++;
                //Resources resources = getResources();
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][1]));
                showToastMessage("正確", time);
            } else {
                wrong++;
                Again();
                showToastMessage("錯誤", time);
            }
        } else if (a == 1) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][1]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][2]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 2) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][2]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][3]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 3) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][3]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][4]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 4) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][4]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][5]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }
    }
    //6
    public void Six(View v) {
        backgroundImageName = String.valueOf(v.getTag());
        if (a == 0) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][0]))) {
                // v.setVisibility(View.INVISIBLE);
                a++;
                //Resources resources = getResources();
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][1]));
                showToastMessage("正確", time);
            } else {
                wrong++;
                Again();
                showToastMessage("錯誤", time);
            }
        } else if (a == 1) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][1]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][2]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 2) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][2]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][3]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 3) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][3]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][4]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 4) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][4]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][5]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }else if (a == 5) {
            if (backgroundImageName.equals(String.valueOf(animationword2[count][5]))) {
                //v.setVisibility(View.INVISIBLE);
                //traditional.setImageResource(animationword1[count1][2]);
                traditional.setImageDrawable(ContextCompat.getDrawable(this, animationword1[count][6]));
                showToastMessage("正確", time);
                correct++;
                Again();
            } else {
                wrong++;
                showToastMessage("錯誤", time);
                Again();
            }
        }
    }

    public void showToastMessage(String text, int duratin) {
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

    public static int[] RandomArray(int[] mArray) {
        int mLength = mArray.length;
        int mRandom, mNumber;
        for (int i = 0; i < mLength; i++) {
            mRandom = (int) (Math.random() * mLength);
            mNumber = mArray[i];
            mArray[i] = mArray[mRandom];
            mArray[mRandom] = mNumber;
        }
        return mArray;
    }

    void Again() {
        count++;
        if (count == 10) {
            ResultAction();
        } else {
            a = 0;
            SetImge();
        }
    }
    //計時
    private Runnable runnable = new Runnable() {
        public void run() {
            if (cou > 0) {
                timev.setText(Integer.toString(cou - 1));
                cou--;
                handler.postDelayed(runnable, 1000);
            } else {
                ResultAction();
            }
        }
    };
    private Runnable runnable1 = new Runnable() {
        public void run() {

        }
    };
    //結束
    void ResultAction() {
        handler.removeCallbacks(runnable);
        Intent intent = new Intent();
        intent.setClass(StructureExercise.this, End.class);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("count", count);
        bundle2.putInt("correct", correct);
        bundle2.putInt("wrong", wrong);
        intent.putExtras(bundle2);
        startActivity(intent);
        finish();
    }
}
