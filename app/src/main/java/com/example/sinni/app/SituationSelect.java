package com.example.sinni.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class SituationSelect extends AppCompatActivity {
    ImageView food,shopping,car;
    Bundle bundle;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situation_select);
        setTitle("SituationSelect");
        findView();
        //浮動button
        //floatingButton();
        bundle = new Bundle();
        intent = new Intent();

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SituationSelect.this,Word_or_voc.class);
                bundle.putString("Situation", "food");
                intent.putExtras(bundle);
                startActivity(intent);
                //finish();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SituationSelect.this, Word_or_voc.class);
                bundle.putString("Situation", "shopping");
                intent.putExtras(bundle);
                startActivity(intent);
                //finish();
            }
        });
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SituationSelect.this, Word_or_voc.class);
                bundle.putString("Situation", "car");
                intent.putExtras(bundle);
                startActivity(intent);
                //finish();
            }
        });

    }
    public void findView() {
        food = (ImageView) findViewById(R.id.food);
        shopping = (ImageView) findViewById(R.id.shopping);
        car = (ImageView) findViewById(R.id.car);
    }

    //浮動button-function
    public void floatingButton(){
        com.getbase.floatingactionbutton.FloatingActionButton my_favorite = new FloatingActionButton(getBaseContext());
        FloatingActionButton Structure = new FloatingActionButton(getBaseContext());

        //浮動button-我的收藏
//        my_favorite.setTitle("選擇題");
//        my_favorite.setColorNormalResId(R.color.other_button_color);
//        my_favorite.setColorDisabled(R.color.white_pressed);
//        my_favorite.setColorPressedResId(R.color.black_20);
//        my_favorite.setIcon(R.drawable.icon_check);
//        my_favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"選擇題",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Home_page.this, Multiple_choice.class);
//                startActivity(intent);
//
//            }
//        });

//        //浮動button-附近景點
//        Structure.setTitle("結構");
//        Structure.setColorNormalResId(R.color.other_button_color);
//        Structure.setColorDisabled(R.color.white_pressed);
//        Structure.setColorPressedResId(R.color.black_20);
//        Structure.setIcon(R.drawable.icon_connect);
//        Structure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(SituationSelect.this, Structure_home_page.class);
//                startActivity(intent);
//
//            }
//        });
//        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
//        // menuMultipleActions.addButton(my_favorite);
//        menuMultipleActions.addButton(Structure);
    }
}
