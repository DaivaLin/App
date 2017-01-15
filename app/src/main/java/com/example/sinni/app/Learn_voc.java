package com.example.sinni.app;

import android.content.Intent;
import android.content.res.Resources;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Locale;

public class Learn_voc extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView voc,spel,mean ;
    ImageView back,last,next,showGIF,sound;
    int w = 0;
    String [] vocmean=new String[]{null};
    String [] vocabulary=new String[]{null};
    String [] spell=new String[]{null};
   // int[] imgIds;
    String Situation;
    int[] imgIds =  {R.drawable.bird,R.drawable.chicken,R.drawable.fish,R.drawable.water,R.drawable.cold,R.drawable.hot,R.drawable.coffee,R.drawable.tea,R.drawable.not_thing,R.drawable.what,R.drawable.not_thing,R.drawable.not_thing,R.drawable.tasty,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.milk,R.drawable.meat,R.drawable.egg,R.drawable.dish,R.drawable.dumpling,R.drawable.rice,R.drawable.noodles,R.drawable.soup,R.drawable.not_thing,R.drawable.cake,R.drawable.bread,R.drawable.fruits,R.drawable.apple,R.drawable.banana,R.drawable.food,R.drawable.drink,R.drawable.juice,R.drawable.wine,R.drawable.cup,R.drawable.cup,R.drawable.not_thing,R.drawable.eat,R.drawable.drinking,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.sweet,R.drawable.menu,R.drawable.chocolate,R.drawable.not_thing,R.drawable.not_thing,R.drawable.bowl,R.drawable.plate,R.drawable.not_thing,R.drawable.bottle,R.drawable.not_thing,R.drawable.half,R.drawable.not_thing,R.drawable.good ,R.drawable.meal,R.drawable.seat,R.drawable.oil,R.drawable.not_thing,R.drawable.health,R.drawable.not_thing,R.drawable.i_am_done,R.drawable.steak,R.drawable.rice2,R.drawable.sandwich,R.drawable.watermelon,R.drawable.beer,R.drawable.black_tea,R.drawable.order,R.drawable.not_thing,R.drawable.not_thing,R.drawable.sour,R.drawable.not_thing,R.drawable.salty,R.drawable.spicy,R.drawable.dessert,R.drawable.ice_cream,R.drawable.cookie,R.drawable.hamburg,R.drawable.vegetables,R.drawable.salt,R.drawable.sugar,R.drawable.cook,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.not_thing,R.drawable.grilled,R.drawable.not_thing,R.drawable.not_thing,R.drawable.knife,R.drawable.fork,R.drawable.spoon,R.drawable.chopsticks};
    Bundle bundle;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_voc);
        setTitle("Learn");
        findView();
        //浮動button
        floatingButton();

        bundle = getIntent().getExtras();
        Situation = bundle.getString("Situation");
        Resources res = getResources();

        switch (Situation){
            case "food":
                vocmean =res.getStringArray(R.array.easy_food_arry);
                vocabulary = res.getStringArray (R.array.easy_food_vocabulary);
                spell = res.getStringArray (R.array.easy_food_spell);
                //imgIds = res.getIntArray (R.array.easy_food_gif);
               // imgIds = new int[]{R.drawable.bird, R.drawable.chicken, R.drawable.fish, R.drawable.water, R.drawable.cold, R.drawable.hot, R.drawable.coffee, R.drawable.tea, R.drawable.not_thing, R.drawable.what, R.drawable.not_thing, R.drawable.not_thing, R.drawable.tasty, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.milk, R.drawable.meat, R.drawable.egg, R.drawable.dish, R.drawable.dumpling, R.drawable.rice, R.drawable.noodles, R.drawable.soup, R.drawable.not_thing, R.drawable.cake, R.drawable.bread, R.drawable.fruits, R.drawable.apple, R.drawable.banana, R.drawable.food, R.drawable.drink, R.drawable.juice, R.drawable.wine, R.drawable.cup, R.drawable.cup, R.drawable.not_thing, R.drawable.eat, R.drawable.drinking, R.drawable.not_thing, R.drawable.not_thing, R.drawable.sweet, R.drawable.menu, R.drawable.chocolate, R.drawable.not_thing, R.drawable.not_thing, R.drawable.bowl, R.drawable.plate, R.drawable.not_thing, R.drawable.bottle, R.drawable.not_thing, R.drawable.half, R.drawable.not_thing, R.drawable.good, R.drawable.meal, R.drawable.seat, R.drawable.oil, R.drawable.not_thing, R.drawable.health, R.drawable.not_thing, R.drawable.i_am_done, R.drawable.steak, R.drawable.rice2, R.drawable.sandwich, R.drawable.watermelon, R.drawable.beer, R.drawable.black_tea, R.drawable.order, R.drawable.not_thing, R.drawable.not_thing, R.drawable.sour, R.drawable.not_thing, R.drawable.salty, R.drawable.spicy, R.drawable.dessert, R.drawable.ice_cream, R.drawable.cookie, R.drawable.hamburg, R.drawable.vegetables, R.drawable.salt, R.drawable.sugar, R.drawable.cook, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.grilled, R.drawable.not_thing, R.drawable.not_thing, R.drawable.knife, R.drawable.fork, R.drawable.spoon, R.drawable.chopsticks};

                break;
            case "shopping":
                vocmean = res.getStringArray (R.array.easy_shopping_arry);
                vocabulary = res.getStringArray (R.array.easy_shopping_vocabulary);
                spell = res.getStringArray (R.array.easy_shopping_spell);
               // imgIds = new int[]{R.drawable.bird, R.drawable.chicken, R.drawable.fish, R.drawable.water, R.drawable.cold, R.drawable.hot, R.drawable.coffee, R.drawable.tea, R.drawable.not_thing, R.drawable.what, R.drawable.not_thing, R.drawable.not_thing, R.drawable.tasty, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.milk, R.drawable.meat, R.drawable.egg, R.drawable.dish, R.drawable.dumpling, R.drawable.rice, R.drawable.noodles, R.drawable.soup, R.drawable.not_thing, R.drawable.cake, R.drawable.bread, R.drawable.fruits, R.drawable.apple, R.drawable.banana, R.drawable.food, R.drawable.drink, R.drawable.juice, R.drawable.wine, R.drawable.cup, R.drawable.cup, R.drawable.not_thing, R.drawable.eat, R.drawable.drinking, R.drawable.not_thing, R.drawable.not_thing, R.drawable.sweet, R.drawable.menu, R.drawable.chocolate, R.drawable.not_thing, R.drawable.not_thing, R.drawable.bowl, R.drawable.plate, R.drawable.not_thing, R.drawable.bottle, R.drawable.not_thing, R.drawable.half, R.drawable.not_thing, R.drawable.good, R.drawable.meal, R.drawable.seat, R.drawable.oil, R.drawable.not_thing, R.drawable.health, R.drawable.not_thing, R.drawable.i_am_done, R.drawable.steak, R.drawable.rice2, R.drawable.sandwich, R.drawable.watermelon, R.drawable.beer, R.drawable.black_tea, R.drawable.order, R.drawable.not_thing, R.drawable.not_thing, R.drawable.sour, R.drawable.not_thing, R.drawable.salty, R.drawable.spicy, R.drawable.dessert, R.drawable.ice_cream, R.drawable.cookie, R.drawable.hamburg, R.drawable.vegetables, R.drawable.salt, R.drawable.sugar, R.drawable.cook, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.grilled, R.drawable.not_thing, R.drawable.not_thing, R.drawable.knife, R.drawable.fork, R.drawable.spoon, R.drawable.chopsticks};

                break;
            case "car":
                vocmean = res.getStringArray (R.array.easy_car_arry);
                vocabulary = res.getStringArray (R.array.easy_car_vocabulary);
                spell = res.getStringArray (R.array.easy_car_spell);
            //    imgIds = new int[]{R.drawable.bird, R.drawable.chicken, R.drawable.fish, R.drawable.water, R.drawable.cold, R.drawable.hot, R.drawable.coffee, R.drawable.tea, R.drawable.not_thing, R.drawable.what, R.drawable.not_thing, R.drawable.not_thing, R.drawable.tasty, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.milk, R.drawable.meat, R.drawable.egg, R.drawable.dish, R.drawable.dumpling, R.drawable.rice, R.drawable.noodles, R.drawable.soup, R.drawable.not_thing, R.drawable.cake, R.drawable.bread, R.drawable.fruits, R.drawable.apple, R.drawable.banana, R.drawable.food, R.drawable.drink, R.drawable.juice, R.drawable.wine, R.drawable.cup, R.drawable.cup, R.drawable.not_thing, R.drawable.eat, R.drawable.drinking, R.drawable.not_thing, R.drawable.not_thing, R.drawable.sweet, R.drawable.menu, R.drawable.chocolate, R.drawable.not_thing, R.drawable.not_thing, R.drawable.bowl, R.drawable.plate, R.drawable.not_thing, R.drawable.bottle, R.drawable.not_thing, R.drawable.half, R.drawable.not_thing, R.drawable.good, R.drawable.meal, R.drawable.seat, R.drawable.oil, R.drawable.not_thing, R.drawable.health, R.drawable.not_thing, R.drawable.i_am_done, R.drawable.steak, R.drawable.rice2, R.drawable.sandwich, R.drawable.watermelon, R.drawable.beer, R.drawable.black_tea, R.drawable.order, R.drawable.not_thing, R.drawable.not_thing, R.drawable.sour, R.drawable.not_thing, R.drawable.salty, R.drawable.spicy, R.drawable.dessert, R.drawable.ice_cream, R.drawable.cookie, R.drawable.hamburg, R.drawable.vegetables, R.drawable.salt, R.drawable.sugar, R.drawable.cook, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.not_thing, R.drawable.grilled, R.drawable.not_thing, R.drawable.not_thing, R.drawable.knife, R.drawable.fork, R.drawable.spoon, R.drawable.chopsticks};

                break;
        }



       tts = new TextToSpeech(this, this);
        tts.speak(vocabulary[0], TextToSpeech.QUEUE_FLUSH, null);     //發音
        showGIF.setImageResource(imgIds[0]);
        setvalue(0);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w<=0){
                    Toast.makeText(Learn_voc.this, "已是第一張" , Toast.LENGTH_SHORT).show();
                }else{
                    w = w -1;
                    setvalue(w);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(w>=vocabulary.length-1){
                    Toast.makeText(Learn_voc.this, "已是最後一張" , Toast.LENGTH_SHORT).show();
                }else{
                    w = w +1;
                    setvalue(w);
                }
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(vocabulary[w], TextToSpeech.QUEUE_FLUSH, null);     //發音
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Learn_voc.this,word_and_voc .class);
                startActivity(intent);
                finish();
            }
        });

    }




    public void findView() {
        voc = (TextView) findViewById(R.id.voc);
        spel = (TextView) findViewById(R.id.spel);
        mean = (TextView) findViewById(R.id.mean);
        last = (ImageView) findViewById(R.id.last);
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        sound = (ImageView) findViewById(R.id.sound);
        showGIF = (ImageView) findViewById(R.id.showGIF);


    }

    public void setvalue(int i) {
        tts.speak(vocabulary[i], TextToSpeech.QUEUE_FLUSH, null);     //發音
        voc.setText(vocabulary[i]);
        spel.setText(spell[i]);
        mean.setText(vocmean[i]);
        showGIF.setImageResource(imgIds[i]);

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

    //浮動button-function
    public void floatingButton() {
        String Multiplechoice = getString(R.string.Multiple_choice);
        FloatingActionButton Multiple_choice = new FloatingActionButton(getBaseContext());
        FloatingActionButton Learn_word = new FloatingActionButton(getBaseContext());

        //浮動button-我的收藏
        Multiple_choice.setTitle(Multiplechoice);
        Multiple_choice.setColorNormalResId(R.color.other_button_color);
        Multiple_choice.setColorDisabled(R.color.white_pressed);
        Multiple_choice.setColorPressedResId(R.color.black_20);
        Multiple_choice.setIcon(R.drawable.icon_check);
        Multiple_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getApplicationContext(), "選擇題", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Learn_voc.this, TextMultiple.class);
                intent.putExtra("Situation", Situation);
                startActivity(intent);
            }
        });


        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(Multiple_choice);

    }

}