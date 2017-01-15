package com.example.sinni.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class StructureTeaching extends AppCompatActivity {
    //結構式選擇畫面
    ImageView leftAndRightCombination
            ,upperAndLowerCombinations
            ,underTheThreePacks
            ,onTheThreeBags
            ,leftLowerPack
            ,topLeftPackage
            ,rightUpperPackage
            ,leftThreePacks
            ,allSurrounded
            ,onTheLowerStructure
            ,leftRightStructure
            ,onTheNextTwoStructures
            ,onTheNextOneStructures
            ,leftAndRightTwoStructures
            ,leftTwoStructures;
    String Situation;

    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure_teaching);
        //浮動button
        if(getIntent().getExtras()!=null){
            Bundle bundle3=getIntent().getExtras();
            Situation = bundle3.getString("Situation");
        }

        floatingButton();
//第一級
        leftAndRightCombination = (ImageView) findViewById(R.id.leftandrightcombination);
        upperAndLowerCombinations = (ImageView) findViewById(R.id.upperandlowercombinations);

//上下組合
        upperAndLowerCombinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent();
                it.setClass(StructureTeaching.this, UpperAndLowerCombinations.class);
                startActivity(it);
                finish();
            }
        });
//左右組合
        leftAndRightCombination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 it=new Intent();it.setClass(StructureTeaching.this,LeftAndRightCombination.class);
                startActivity(it);
                finish();
            }
        });
    }

    //浮動button-function
    public void floatingButton(){
        FloatingActionButton second = new FloatingActionButton(getBaseContext());
        FloatingActionButton third = new FloatingActionButton(getBaseContext());
        //    FloatingActionButton fourth = new FloatingActionButton(getBaseContext());

        //浮動button-第二級
        second.setTitle("第二級");
        second.setColorNormalResId(R.color.other_button_color);
        second.setColorDisabled(R.color.white_pressed);
        second.setColorPressedResId(R.color.black_20);
        second.setIcon(R.drawable.number_two);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StructureTeaching.this, Structures_level2.class);
                startActivity(intent);
            }
        });

        //浮動button-第三級
        third.setTitle("第三級");
        third.setColorNormalResId(R.color.other_button_color);
        third.setColorDisabled(R.color.white_pressed);
        third.setColorPressedResId(R.color.black_20);
        third.setIcon(R.drawable.number_three);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StructureTeaching.this, Structures_level3.class);
                startActivity(intent);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(second);
        menuMultipleActions.addButton(third);

        //浮動button-第四級
//        fourth.setTitle("");
//        fourth.setColorNormalResId(R.color.other_button_color);
//        fourth.setColorDisabled(R.color.white_pressed);
//        fourth.setColorPressedResId(R.color.black_20);
//        fourth.setIcon(R.drawable.number_three);
//        fourth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(getApplicationContext(),"結構",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Structures_level2.this, Structure_home_page.class);
//                startActivity(intent);
//            }
//        });
//        menuMultipleActions.addButton(fourth);

    }

}
